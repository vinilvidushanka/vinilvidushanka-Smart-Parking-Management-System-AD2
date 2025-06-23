package lk.ijse.vehicleservice.controller;

import jakarta.servlet.http.HttpServletRequest;
import lk.ijse.vehicleservice.dto.VehicleDTO;
import lk.ijse.vehicleservice.entity.Vehicle;
import lk.ijse.vehicleservice.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v1/vehicles")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @PostMapping("/add")
    public Vehicle addVehicle(@RequestBody VehicleDTO dto) {
        return vehicleService.addVehicle(dto);
    }

    @GetMapping
    @PreAuthorize("hasRole('OWNER')")
    public List<Vehicle> getAllVehicles(HttpServletRequest request) {
        String authHeader = request.getHeader("Authorization");
        System.out.println(authHeader);
        return vehicleService.getAllVehicles();
    }

    @GetMapping("/user/{userId}")
    @PreAuthorize("hasRole('USER')")
    public List<Vehicle> getVehiclesByUser(@PathVariable Integer userId) {
        return vehicleService.getVehiclesByUserId(userId);
    }
}
