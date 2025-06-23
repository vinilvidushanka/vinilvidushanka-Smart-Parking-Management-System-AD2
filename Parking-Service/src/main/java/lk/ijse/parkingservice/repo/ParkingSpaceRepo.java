package lk.ijse.parkingservice.repo;

import lk.ijse.parkingservice.entity.ParkingSpace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParkingSpaceRepo extends JpaRepository<ParkingSpace, Integer> {
    // Find available parking spaces
    List<ParkingSpace> findByAvailableTrue();

    // Find parking spaces by zone
    List<ParkingSpace> findByZone(String zone);

    List<ParkingSpace> findByLocationContainingIgnoreCase(String location);

    List<ParkingSpace> findByOwnerId(Integer ownerId);

}
