package lk.ijse.vehicleservice.dto;

public class VehicleDTO {
    private Integer userId;
    private String plateNumber;
    private String model;
    private String color;

    public VehicleDTO() {
    }

    public VehicleDTO(Integer userId, String plateNumber, String model, String color) {
        this.userId = userId;
        this.plateNumber = plateNumber;
        this.model = model;
        this.color = color;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
