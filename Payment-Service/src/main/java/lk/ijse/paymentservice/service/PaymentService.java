package lk.ijse.paymentservice.service;

import lk.ijse.paymentservice.dto.PaymentDTO;
import lk.ijse.paymentservice.entity.Payment;

import java.util.List;

public interface PaymentService {
    Payment createPayment(PaymentDTO paymentDTO);
    List<Payment> getAllPayments();
    Payment getPaymentById(Integer id);
    List<Payment> getPaymentsByUserId(Integer userId);
}
