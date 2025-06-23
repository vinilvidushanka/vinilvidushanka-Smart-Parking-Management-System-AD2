package lk.ijse.parkingservice.controller;

import lk.ijse.parkingservice.dto.ParkingSpaceDTO;
import lk.ijse.parkingservice.service.ParkingSpaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v1/parking")
public class ParkingController {
    @Autowired
    private ParkingSpaceService parkingSpaceService;

    public ParkingController(ParkingSpaceService parkingSpaceService) {
        this.parkingSpaceService = parkingSpaceService;
    }

    // Create new parking space
    @PostMapping
    public ResponseEntity<ParkingSpaceDTO> createParkingSpace(@RequestBody ParkingSpaceDTO dto) {
        return ResponseEntity.ok(parkingSpaceService.createParkingSpace(dto));
    }

    // Update existing parking space
    @PutMapping("/{id}")
    public ResponseEntity<ParkingSpaceDTO> updateParkingSpace(
            @PathVariable Integer id,
            @RequestBody ParkingSpaceDTO dto) {
        return ResponseEntity.ok(parkingSpaceService.updateParkingSpace(id, dto));
    }

    // Get parking space by ID
    @GetMapping("/{id}")
    public ResponseEntity<ParkingSpaceDTO> getParkingSpace(@PathVariable Integer id) {
        return ResponseEntity.ok(parkingSpaceService.getParkingSpaceById(id));
    }

    // Get all parking spaces
    @GetMapping
    public ResponseEntity<List<ParkingSpaceDTO>> getAllSpaces() {
        return ResponseEntity.ok(parkingSpaceService.getAllParkingSpaces());
    }

    // Delete parking space by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSpace(@PathVariable Integer id) {
        parkingSpaceService.deleteParkingSpace(id);
        return ResponseEntity.noContent().build();
    }

    // Get all available parking spaces
    @GetMapping("/available")
    public ResponseEntity<List<ParkingSpaceDTO>> getAvailableSpaces() {
        return ResponseEntity.ok(parkingSpaceService.getAvailableParkingSpaces());
    }

    // Get spaces by zone
    @GetMapping("/zone/{zone}")
    public ResponseEntity<List<ParkingSpaceDTO>> getByZone(@PathVariable String zone) {
        return ResponseEntity.ok(parkingSpaceService.getParkingSpacesByZone(zone));
    }

    // Get spaces by location keyword
    @GetMapping("/location/{location}")
    public ResponseEntity<List<ParkingSpaceDTO>> getByLocation(@PathVariable String location) {
        return ResponseEntity.ok(parkingSpaceService.getParkingSpacesByLocation(location));
    }

    // Get spaces by owner
    @GetMapping("/owner/{ownerId}")
    public ResponseEntity<List<ParkingSpaceDTO>> getByOwner(@PathVariable Integer ownerId) {
        return ResponseEntity.ok(parkingSpaceService.getParkingSpacesByOwner(ownerId));
    }

    // Reserve space
    @PostMapping("/reserve/{id}")
    public ResponseEntity<String> reserveSpace(@PathVariable Integer id) {
        boolean result = parkingSpaceService.reserveParkingSpace(id);
        return result ?
                ResponseEntity.ok("Space reserved successfully") :
                ResponseEntity.badRequest().body("Failed to reserve space");
    }

    // Release space
    @PostMapping("/release/{id}")
    public ResponseEntity<String> releaseSpace(@PathVariable Integer id) {
        boolean result = parkingSpaceService.releaseParkingSpace(id);
        return result ?
                ResponseEntity.ok("Space released successfully") :
                ResponseEntity.badRequest().body("Failed to release space");
    }
}
