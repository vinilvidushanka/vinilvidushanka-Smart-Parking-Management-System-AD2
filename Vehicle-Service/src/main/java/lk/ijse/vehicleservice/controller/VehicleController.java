package lk.ijse.vehicleservice.controller;

import jakarta.servlet.http.HttpServletRequest;
import lk.ijse.vehicleservice.dto.VehicleDTO;
import lk.ijse.vehicleservice.entity.Vehicle;
import lk.ijse.vehicleservice.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/vehicles")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @PostMapping("/add")
    public Vehicle addVehicle(@RequestBody VehicleDTO dto) {
        return vehicleService.addVehicle(dto);
    }

    @GetMapping("/all")
    public List<Vehicle> getAllVehicles() {
        return vehicleService.getAllVehicles();
    }

    @GetMapping("/user/{userId}")
    public List<Vehicle> getVehiclesByUser(@PathVariable Integer userId) {
        return vehicleService.getVehiclesByUserId(userId);
    }

    @PutMapping("/update/{vehicleId}")
    public Vehicle updateVehicle(@PathVariable Integer vehicleId, @RequestBody VehicleDTO dto) {
        return vehicleService.updateVehicle(vehicleId, dto);
    }

}