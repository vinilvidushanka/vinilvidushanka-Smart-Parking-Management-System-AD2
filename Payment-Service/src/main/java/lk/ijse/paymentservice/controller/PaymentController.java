package lk.ijse.paymentservice.controller;

import jakarta.servlet.http.HttpServletRequest;
import lk.ijse.paymentservice.dto.PaymentDTO;
import lk.ijse.paymentservice.entity.Payment;
import lk.ijse.paymentservice.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v1/payments")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    // Create payment
    @PostMapping("/create")
    public Payment createPayment(@RequestBody PaymentDTO dto) {
        return paymentService.createPayment(dto);
    }

    // Get all payments (admin/owner)
    @GetMapping("/all")
    @PreAuthorize("hasAuthority('OWNER')")
    public List<Payment> getAllPayments() {
        return paymentService.getAllPayments();
    }

    // Get payment by ID
    @GetMapping("/{id}")
    @PreAuthorize("hasRole('OWNER')")
    public Payment getPaymentById(@PathVariable Integer id) {
        return paymentService.getPaymentById(id);
    }

    // Get all payments by user ID
    @GetMapping("/user/{userId}")
    @PreAuthorize("hasRole('USER')")
    public List<Payment> getPaymentsByUser(@PathVariable Integer userId, HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        System.out.println("Token: " + token); // optional logging
        return paymentService.getPaymentsByUserId(userId);
    }
}
