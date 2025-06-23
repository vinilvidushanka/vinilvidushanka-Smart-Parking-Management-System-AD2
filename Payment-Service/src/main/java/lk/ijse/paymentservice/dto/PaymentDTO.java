package lk.ijse.paymentservice.dto;

import java.time.LocalDateTime;

public class PaymentDTO {
    private Integer paymentId;
    private Integer userId;
    private Integer spaceId;
    private double amount;
    private String status;
    private LocalDateTime timestamp;

    public PaymentDTO() {
    }

    public PaymentDTO(Integer paymentId, Integer userId, Integer spaceId, double amount, String status, LocalDateTime timestamp) {
        this.paymentId = paymentId;
        this.userId = userId;
        this.spaceId = spaceId;
        this.amount = amount;
        this.status = status;
        this.timestamp = timestamp;
    }

    public Integer getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Integer paymentId) {
        this.paymentId = paymentId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getSpaceId() {
        return spaceId;
    }

    public void setSpaceId(Integer spaceId) {
        this.spaceId = spaceId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
