package lk.ijse.userservice.controller;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {
    private final Map<Integer, String> users = new HashMap<>();

    /*@PostMapping("/register")
    public String register(@RequestParam int id, @RequestParam String name) {
        users.put(id, name);
        return "User registered: " + name;
    }*/

    @PostMapping("/register")
    public String register(@RequestBody Map<String, Object> user) {
        int id = (int) user.get("id");
        String name = (String) user.get("name");
        users.put(id, name);
        return "User registered: " + name;
    }


    /*@GetMapping("/{id}")
    public String getUser(@PathVariable int id) {
        return users.getOrDefault(id, "User not found");
    }*/

    @GetMapping("/{id}")
    public Map<String, Object> getUser(@PathVariable int id) {
        Map<String, Object> response = new HashMap<>();
        if (users.containsKey(id)) {
            response.put("id", id);
            response.put("name", users.get(id));
        } else {
            response.put("error", "User not found");
        }
        return response;
    }

    @GetMapping
    public Map<Integer, String> getAllUsers() {
        return users;
    }


}
