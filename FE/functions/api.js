var apiUrl = "http://localhost:8080/api/";
var selectedOwnerId = null;
var updateColour = "White";

function getAllVehicles() {
  fetch(apiUrl + "get_vehicles", {
    method: "GET",
    headers: {
      "content-type": "application/json",
    },
  })
    .then((response) => response.json())
    .then((json) => writeAllVehicles(json))
    .catch((err) => {
      console.error(err);
    });
}

function writeAllVehicles(json) {
  console.log(json);
  document.getElementById("allVehicles").innerHTML = json
    .map(
      (vehicle) =>
        `
                    <tr>
                        <th scope="row">${vehicle.id}</th>
                        <td>${vehicle.plate}</td>
                        <td>${vehicle.colour}</td>
                        <td>${vehicle.seats}</td>
                        <td>${vehicle.doors}</td>
                        <td>${vehicle.person_id.lastname} ${vehicle.person_id.prename}</td>
                        <td><button type="button" class="btn btn-danger" onclick="deleteVehicleById(${vehicle.id})">Delete Vehicle</button></td>
                        <td><button type="button" class="btn btn-warning" onclick="updateVehicleColourByIdToBlackOrWhite(${vehicle.id})">Update Colour to "${updateColour}"</button></td>
                    </tr>
                    `
    )
    .join("");
}

function getAllPersons() {
  fetch(apiUrl + "get_persons", {
    method: "GET",
    headers: {
      "content-type": "application/json",
    },
  })
    .then((response) => response.json())
    .then((json) => writeAllPersons(json))
    .catch((err) => {
      console.error(err);
    });
}

function writeAllPersons(json) {
  console.log(json);
  document.getElementById("allPersons").innerHTML = json
    .map(
      (person) =>
        `
                    <tr>
                        <th scope="row">${person.id}</th>
                        <td>${person.lastname}</td>
                        <td>${person.prename}</td>
                    </tr>
                    `
    )
    .join("");
  document.getElementById("dropdownOwner").innerHTML = json
    .map(
      (person) =>
        `
        <li><button class="dropdown-item" type="button" onclick="selectedOwnerHandler(${person.id})">${person.id} ${person.lastname} ${person.prename}</button></li>
        `
    )
}

function selectedOwnerHandler(Id) {
  selectedOwnerId = Id;
  if(selectedOwnerId) {
    document.getElementById("selectedOwner").innerHTML = "<p>" + selectedOwnerId + "</p>"
  }
}

function savePerson() {
  var person = {
    id: null,
    lastname: document.getElementById("inputLastname").value,
    prename: document.getElementById("inputPrename").value,
    hair_colour: document.getElementById("inputHairColour").value,
    size: document.getElementById("inputSize").value,
    address: document.getElementById("inputAddress").value,
    house_number: document.getElementById("inputHouseNumber").value,
    plz: document.getElementById("inputPLZ").value,
    place: document.getElementById("inputPlace").value
  };
  if (!person.lastname
    || !person.prename
    || !person.hair_colour
    || !person.size
    || !person.address
    || !person.house_number
    || !person.plz
    || !person.place
  ) {
    console.log("Please fill out every input field.");
    document.getElementById("errorCreateUser").innerHTML = "Please fill out every input field.";
  } else {
    document.getElementById("inputLastname").value = null,
    document.getElementById("inputPrename").value = null,
    document.getElementById("inputHairColour").value = null,
    document.getElementById("inputSize").value = null,
    document.getElementById("inputAddress").value = null,
    document.getElementById("inputHouseNumber").value = null,
    document.getElementById("inputPLZ").value = null,
    document.getElementById("inputPlace").value = null

    fetch(apiUrl + "save_person", {
      method: "POST",
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify(person)
    }).then(res => {
      console.log("Request complete! response:", res);
      getAllPersons();
    });
  }
}

function saveVehicle() {
  var vehicle = {
    id: null,
    colour: document.getElementById("inputColour").value,
    seats: document.getElementById("inputSeats").value,
    doors: document.getElementById("inputDoors").value,
    plate: document.getElementById("inputPlate").value,
    ownerId: selectedOwnerId,
  };
  if (!vehicle.colour
    || !vehicle.seats
    || !vehicle.doors
    || !vehicle.plate
    || !vehicle.ownerId
    || !selectedOwnerId
  ) {
    console.log("Please fill out every input field.");
    document.getElementById("errorCreateVehicle").innerHTML = "Please fill out every input field.";
  } else {
    document.getElementById("inputColour").value = null,
    document.getElementById("inputSeats").value = null,
    document.getElementById("inputDoors").value = null,
    document.getElementById("inputPlate").value = null,
    selectedOwnerId = null;
    document.getElementById("selectedOwner").innerHTML = "";

    fetch(apiUrl + "save_vehicle", {
      method: "POST",
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify(vehicle)
    }).then(res => {
      console.log("Request complete! response:", res);
      getAllVehicles();
    });
  }
}

function deleteVehicleById(Id) {
  fetch(apiUrl + "delete_vehicle/" + Id, {
    method: "DELETE",
    headers: {
      "content-type": "application/json",
    },
  })
    .then(() => {
      getAllVehicles();
    })
    .catch((err) => {
      console.error(err);
    });
}

function updateVehicleColourByIdToBlackOrWhite(Id) {
  console.log(updateColour)
  fetch(apiUrl + "update_vehicle_colour/" + Id + "/" + updateColour, {
    method: "PUT",
    headers: {
      "content-type": "application/json",
    },
  })
    .then(() => {
      getAllVehicles();
    })
    .catch((err) => {
      console.error(err);
    });
    if(updateColour === "White") {
      updateColour = "Black";
    } else if(updateColour === "Black") {
      updateColour = "White";
    }
}