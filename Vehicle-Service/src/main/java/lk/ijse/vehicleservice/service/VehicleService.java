package lk.ijse.vehicleservice.service;

import lk.ijse.vehicleservice.dto.VehicleDTO;
import lk.ijse.vehicleservice.entity.Vehicle;

import java.util.List;

public interface VehicleService {
    Vehicle addVehicle(VehicleDTO dto);
    List<Vehicle> getAllVehicles();
    List<Vehicle> getVehiclesByUserId(Integer userId);
    Vehicle updateVehicle(Integer vehicleId, VehicleDTO dto);

}
