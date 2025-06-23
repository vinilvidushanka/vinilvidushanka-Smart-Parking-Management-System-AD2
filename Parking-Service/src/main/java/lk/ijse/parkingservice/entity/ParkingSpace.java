package lk.ijse.parkingservice.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "parking_space")
public class ParkingSpace {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer spaceId;

    private String location;
    private String zone;
    private boolean available;
    private Integer ownerId; // UserId of the space owner

    public ParkingSpace() {
    }

    public ParkingSpace(Integer spaceId, String location, String zone, boolean available, Integer ownerId) {
        this.spaceId = spaceId;
        this.location = location;
        this.zone = zone;
        this.available = available;
        this.ownerId = ownerId;
    }

    public Integer getSpaceId() {
        return spaceId;
    }

    public void setSpaceId(Integer spaceId) {
        this.spaceId = spaceId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }
}
