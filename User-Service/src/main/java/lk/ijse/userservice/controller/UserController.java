package lk.ijse.userservice.controller;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {
    private final Map<Integer, String> users = new HashMap<>();

    @PostMapping("/register")
    public String register(@RequestParam int id, @RequestParam String name) {
        users.put(id, name);
        return "User registered: " + name;
    }

    @GetMapping("/{id}")
    public String getUser(@PathVariable int id) {
        return users.getOrDefault(id, "User not found");
    }
}
