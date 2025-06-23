package lk.ijse.paymentservice.service.impl;

import lk.ijse.paymentservice.dto.PaymentDTO;
import lk.ijse.paymentservice.entity.Payment;
import lk.ijse.paymentservice.repo.PaymentRepo;
import lk.ijse.paymentservice.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private PaymentRepo paymentRepo;

    public PaymentServiceImpl(PaymentRepo paymentRepo) {
        this.paymentRepo = paymentRepo;
    }

    @Override
    public Payment createPayment(PaymentDTO dto) {
        Payment payment = new Payment();
        payment.setUserId(dto.getUserId());
        payment.setSpaceId(dto.getSpaceId());
        payment.setAmount(dto.getAmount());
        payment.setStatus(dto.getStatus());
        payment.setTimestamp(LocalDateTime.now());

        return paymentRepo.save(payment);
    }

    @Override
    public List<Payment> getAllPayments() {
        return paymentRepo.findAll();
    }

    @Override
    public Payment getPaymentById(Integer id) {
        return paymentRepo.findById(id).orElse(null);
    }

    @Override
    public List<Payment> getPaymentsByUserId(Integer userId) {
        return paymentRepo.findByUserId(userId);
    }
}
