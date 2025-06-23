package lk.ijse.parkingservice.service;

import lk.ijse.parkingservice.dto.ParkingSpaceDTO;

import java.util.List;

public interface ParkingSpaceService {
    // Create a new parking space
    ParkingSpaceDTO createParkingSpace(ParkingSpaceDTO parkingSpaceDTO);

    // Update an existing parking space
    ParkingSpaceDTO updateParkingSpace(Integer spaceId, ParkingSpaceDTO parkingSpaceDTO);

    // Get parking space by ID
    ParkingSpaceDTO getParkingSpaceById(Integer spaceId);

    // Get all parking spaces
    List<ParkingSpaceDTO> getAllParkingSpaces();

    // Delete parking space by ID
    void deleteParkingSpace(Integer spaceId);

    // Get available parking spaces
    List<ParkingSpaceDTO> getAvailableParkingSpaces();

    // Get parking spaces by zone
    List<ParkingSpaceDTO> getParkingSpacesByZone(String zone);

    // Get parking spaces by location
    List<ParkingSpaceDTO> getParkingSpacesByLocation(String location);

    // Get parking spaces by owner
    List<ParkingSpaceDTO> getParkingSpacesByOwner(Integer ownerId);

    // Reserve a parking space
    boolean reserveParkingSpace(Integer spaceId);

    // Release a parking space
    boolean releaseParkingSpace(Integer spaceId);
}
