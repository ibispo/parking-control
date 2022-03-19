package com.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.api.model.ParkingSpotModel;

public interface IParkingSpotService {

	ParkingSpotModel save(ParkingSpotModel parkingSpotModel);
	
	boolean existsByLicencePlateCar(String licencePlateCar);
	
	boolean existsByParkingSpotNumber(String parkingSpotNumber);
	
	boolean existsByApartmentAndBlock(String apartment, String block);
	
	Page<ParkingSpotModel> findAll(Pageable pageable);

	Optional<ParkingSpotModel> findById(Long id);
	
	void delete(ParkingSpotModel parkingSpotModel);
	
	// News
	default boolean idBonito() {
		return true;
	}
	
	
}
