package lk.ijse.parkingservice.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/parking")
public class ParkingController {
    private final Map<Integer, Boolean> spaces = new HashMap<>();

    @PostMapping("/add")
    public String addSpace(@RequestParam int id) {
        spaces.put(id, true);
        return "Parking space added: " + id;
    }

    @PostMapping("/reserve")
    public String reserveSpace(@RequestParam int id) {
        if (spaces.getOrDefault(id, false)) {
            spaces.put(id, false);
            return "Space reserved: " + id;
        }
        return "Space not available";
    }

    @PostMapping("/release")
    public String releaseSpace(@RequestParam int id) {
        spaces.put(id, true);
        return "Space released: " + id;
    }
}
