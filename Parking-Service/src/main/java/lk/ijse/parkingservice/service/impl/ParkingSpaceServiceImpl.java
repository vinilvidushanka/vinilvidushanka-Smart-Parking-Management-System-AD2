package lk.ijse.parkingservice.service.impl;

import lk.ijse.parkingservice.dto.ParkingSpaceDTO;
import lk.ijse.parkingservice.entity.ParkingSpace;
import lk.ijse.parkingservice.repo.ParkingSpaceRepo;
import lk.ijse.parkingservice.service.ParkingSpaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ParkingSpaceServiceImpl implements ParkingSpaceService {

    @Autowired
    private ParkingSpaceRepo parkingSpaceRepo;

    @Override
    public ParkingSpaceDTO createParkingSpace(ParkingSpaceDTO dto) {
        ParkingSpace space = mapToEntity(dto);
        space.setAvailable(true); // default to available
        return mapToDTO(parkingSpaceRepo.save(space));
    }

    @Override
    public ParkingSpaceDTO updateParkingSpace(Integer spaceId, ParkingSpaceDTO dto) {
        ParkingSpace existing = parkingSpaceRepo.findById(spaceId)
                .orElseThrow(() -> new RuntimeException("Parking space not found with id " + spaceId));

        existing.setLocation(dto.getLocation());
        existing.setZone(dto.getZone());
        existing.setAvailable(dto.isAvailable());
        existing.setOwnerId(dto.getOwnerId());

        return mapToDTO(parkingSpaceRepo.save(existing));
    }

    @Override
    public ParkingSpaceDTO getParkingSpaceById(Integer spaceId) {
        ParkingSpace space = parkingSpaceRepo.findById(spaceId)
                .orElseThrow(() -> new RuntimeException("Parking space not found with id " + spaceId));
        return mapToDTO(space);
    }

    @Override
    public List<ParkingSpaceDTO> getAllParkingSpaces() {
        return parkingSpaceRepo.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteParkingSpace(Integer spaceId) {
        if (!parkingSpaceRepo.existsById(spaceId)) {
            throw new RuntimeException("Cannot delete. Parking space not found with id " + spaceId);
        }
        parkingSpaceRepo.deleteById(spaceId);
    }

    @Override
    public List<ParkingSpaceDTO> getAvailableParkingSpaces() {
        return parkingSpaceRepo.findByAvailableTrue()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<ParkingSpaceDTO> getParkingSpacesByZone(String zone) {
        return parkingSpaceRepo.findByZone(zone)
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<ParkingSpaceDTO> getParkingSpacesByLocation(String location) {
        return parkingSpaceRepo.findByLocationContainingIgnoreCase(location)
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<ParkingSpaceDTO> getParkingSpacesByOwner(Integer ownerId) {
        return parkingSpaceRepo.findByOwnerId(ownerId)
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }



    @Override
    public boolean reserveParkingSpace(Integer spaceId) {
        Optional<ParkingSpace> optional = parkingSpaceRepo.findById(spaceId);
        if (optional.isPresent() && optional.get().isAvailable()) {
            ParkingSpace space = optional.get();
            space.setAvailable(false);
            parkingSpaceRepo.save(space);
            return true;
        }
        return false;
    }

    @Override
    public boolean releaseParkingSpace(Integer spaceId) {
        Optional<ParkingSpace> optional = parkingSpaceRepo.findById(spaceId);
        if (optional.isPresent() && !optional.get().isAvailable()) {
            ParkingSpace space = optional.get();
            space.setAvailable(true);
            parkingSpaceRepo.save(space);
            return true;
        }
        return false;
    }

    // Mapping helpers
    private ParkingSpaceDTO mapToDTO(ParkingSpace space) {
        ParkingSpaceDTO dto = new ParkingSpaceDTO();
        dto.setSpaceId(space.getSpaceId());
        dto.setLocation(space.getLocation());
        dto.setZone(space.getZone());
        dto.setAvailable(space.isAvailable());
        dto.setOwnerId(space.getOwnerId());
        return dto;
    }

    private ParkingSpace mapToEntity(ParkingSpaceDTO dto) {
        ParkingSpace space = new ParkingSpace();
        space.setSpaceId(dto.getSpaceId());
        space.setLocation(dto.getLocation());
        space.setZone(dto.getZone());
        space.setAvailable(dto.isAvailable());
        space.setOwnerId(dto.getOwnerId());
        return space;
    }
}
