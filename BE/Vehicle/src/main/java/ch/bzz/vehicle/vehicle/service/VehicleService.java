package ch.bzz.vehicle.vehicle.service;

import ch.bzz.vehicle.vehicle.model.Person;
import ch.bzz.vehicle.vehicle.model.Vehicle;
import ch.bzz.vehicle.vehicle.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    public List<Vehicle> getVehicles() {
        return vehicleRepository.findAll();
    }

    public boolean createVehicle(Vehicle vehicle) {
        if (vehicle.getColour().isEmpty()
                || vehicle.getDoors() < 1
                || vehicle.getSeats() < 1
                || vehicle.getPlate().isEmpty()
                || vehicle.getPerson_id() == null
        ) {
            return false;
        } else {
            vehicleRepository.save(vehicle);
            return true;
        }
    }

    public void deleteVehicleById(Long Id) {
        vehicleRepository.deleteById(Id);
    }

    public Vehicle getVehicleById(Long id) {
        return vehicleRepository.findById(id).orElse(null);
    }

    public void updateVehicle(Vehicle vehicle) {
        vehicleRepository.save(vehicle);
    }

}
