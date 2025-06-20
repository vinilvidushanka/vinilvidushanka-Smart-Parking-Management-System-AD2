package lk.ijse.vehicleservice.controller;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {
    private final Map<Integer, String> vehicles = new HashMap<>();

    @PostMapping("/register")
    public String registerVehicle(@RequestParam int id, @RequestParam String plate) {
        vehicles.put(id, plate);
        return "Vehicle registered: " + plate;
    }

    @GetMapping("/{id}")
    public String getVehicle(@PathVariable int id) {
        return vehicles.getOrDefault(id, "Vehicle not found");
    }
}
