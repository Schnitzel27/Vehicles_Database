package ch.bzz.vehicle.vehicle.controller;

import ch.bzz.vehicle.vehicle.model.Person;
import ch.bzz.vehicle.vehicle.model.Vehicle;
import ch.bzz.vehicle.vehicle.model.submodel.SubVehicle;
import ch.bzz.vehicle.vehicle.service.PersonService;
import ch.bzz.vehicle.vehicle.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
public class VehicleRest {

    @Autowired
    private PersonService personService;

    @Autowired
    private VehicleService vehicleService;

    @GetMapping("/api/get_persons")
    public ResponseEntity<?> getPersons() {
        return new ResponseEntity<>(personService.getPersons(), HttpStatus.OK);
    }

    @PostMapping("/api/save_person")
    public ResponseEntity<?> savePerson(@RequestBody Person person) {
        System.out.println("called");
        System.out.println(person.toString());
        boolean validate = personService.createPerson(person);
        if (validate) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            System.out.println("error");
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }

    @GetMapping("/api/get_vehicles")
    public ResponseEntity<?> getVehicles() {
        return new ResponseEntity<>(vehicleService.getVehicles(), HttpStatus.OK);
    }

    @PostMapping("/api/save_vehicle")
    public ResponseEntity<?> saveVehicle(@RequestBody SubVehicle subVehicle) {
        System.out.println(subVehicle.toString());
        Vehicle vehicleTmp = new Vehicle();
        vehicleTmp.setId(null);
        vehicleTmp.setPerson_id(personService.findPersonById(subVehicle.getOwnerId()));
        vehicleTmp.setDoors(subVehicle.getDoors());
        vehicleTmp.setColour(subVehicle.getColour());
        vehicleTmp.setPlate(subVehicle.getPlate());
        vehicleTmp.setSeats(subVehicle.getSeats());
        System.out.println(vehicleTmp.toString());
        boolean validate = vehicleService.createVehicle(vehicleTmp);
        if (validate) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            System.out.println("error");
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }

    @DeleteMapping("/api/delete_vehicle/{id}")
    public ResponseEntity<?> deleteVehicle(@PathVariable("id") Long Id) {
        System.out.println("called");
        vehicleService.deleteVehicleById(Id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/api/update_vehicle_colour/{id}/{colour}")
    public ResponseEntity<?> updateVehicleColour(@PathVariable("id") Long Id, @PathVariable("colour") String colour) {
        Vehicle vehicleTmp = vehicleService.getVehicleById(Id);
        vehicleTmp.setColour(colour);
        vehicleService.updateVehicle(vehicleTmp);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
