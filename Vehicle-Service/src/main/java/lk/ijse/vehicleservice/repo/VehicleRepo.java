package lk.ijse.vehicleservice.repo;

import lk.ijse.vehicleservice.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VehicleRepo extends JpaRepository<Vehicle, Integer> {
    List<Vehicle> findByUserId(Integer userId);
}
