package lk.ijse.vehicleservice.service.impl;

import lk.ijse.vehicleservice.dto.VehicleDTO;
import lk.ijse.vehicleservice.entity.Vehicle;
import lk.ijse.vehicleservice.repo.VehicleRepo;
import lk.ijse.vehicleservice.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleServiceImpl implements VehicleService {

    private final VehicleRepo vehicleRepo;

    public VehicleServiceImpl(VehicleRepo vehicleRepo) {
        this.vehicleRepo = vehicleRepo;
    }

    @Override
    public Vehicle addVehicle(VehicleDTO dto) {
        if (dto == null) {
            throw new IllegalArgumentException("VehicleDTO cannot be null");
        }
        Vehicle vehicle = new Vehicle();
        vehicle.setUserId(dto.getUserId());
        vehicle.setPlateNumber(dto.getPlateNumber());
        vehicle.setModel(dto.getModel());
        vehicle.setColor(dto.getColor());
        return vehicleRepo.save(vehicle);
    }

    @Override
    public List<Vehicle> getAllVehicles() {
        return vehicleRepo.findAll();
    }

    @Override
    public List<Vehicle> getVehiclesByUserId(Integer userId) {
        return vehicleRepo.findByUserId(userId);
    }
    @Override
    public Vehicle updateVehicle(Integer vehicleId, VehicleDTO dto) {
        Vehicle existingVehicle = vehicleRepo.findById(vehicleId)
                .orElseThrow(() -> new RuntimeException("Vehicle not found with ID: " + vehicleId));

        existingVehicle.setPlateNumber(dto.getPlateNumber());
        existingVehicle.setModel(dto.getModel());
        existingVehicle.setColor(dto.getColor());
        existingVehicle.setUserId(dto.getUserId());

        return vehicleRepo.save(existingVehicle);
    }

}
