package lk.ijse.paymentservice.controller;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/payments")
public class PaymentController {
    private final Map<Integer, String> receipts = new HashMap<>();

    @PostMapping("/pay")
    public String pay(@RequestParam int id, @RequestParam double amount) {
        String receipt = "Paid $" + amount + " for booking " + id;
        receipts.put(id, receipt);
        return receipt;
    }

    @GetMapping("/receipt/{id}")
    public String getReceipt(@PathVariable int id) {
        return receipts.getOrDefault(id, "No receipt found");
    }
}
