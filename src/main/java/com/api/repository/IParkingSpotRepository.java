package com.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.model.ParkingSpotModel;

@Repository
public interface IParkingSpotRepository extends JpaRepository<ParkingSpotModel, Long>{

	boolean existsByLicencePlateCar(String licencePlateCar);

	boolean existsByParkingSpotNumber(String parkingSpotNumber);
	
	boolean existsByApartmentAndBlock(String apartment, String block);
	 
	
}
