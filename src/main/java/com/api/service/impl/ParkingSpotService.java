package com.api.service.impl;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.api.model.ParkingSpotModel;
import com.api.repository.IParkingSpotRepository;
import com.api.service.IParkingSpotService;

@Service
public class ParkingSpotService implements IParkingSpotService {

	final IParkingSpotRepository parkingSpotRepository;

	public ParkingSpotService(IParkingSpotRepository parkingSpotRepository) {
		this.parkingSpotRepository = parkingSpotRepository;
	}

	@Override
	@Transactional
	public ParkingSpotModel save(ParkingSpotModel parkingSpotModel) {
		return this.parkingSpotRepository.save(parkingSpotModel);
	}

	@Override
	public boolean existsByLicencePlateCar(String licencePlateCar) {
		return this.parkingSpotRepository.existsByLicencePlateCar(licencePlateCar);
	}

	@Override
	public boolean existsByParkingSpotNumber(String parkingSpotNumber) {
		return this.parkingSpotRepository.existsByParkingSpotNumber(parkingSpotNumber);
	}

	@Override
	public boolean existsByApartmentAndBlock(String apartment, String block) {
		return this.parkingSpotRepository.existsByApartmentAndBlock(apartment, block);
	}

	@Override
	public Page<ParkingSpotModel> findAll(Pageable pageable) {
		if (idBonito()) {
			System.out.println("Oiiiiiiiiiii...........");
		}
		return this.parkingSpotRepository.findAll(pageable);
	}

	@Override
	public Optional<ParkingSpotModel> findById(Long id) {
		return this.parkingSpotRepository.findById(id);
	}

	@Override
	@Transactional
	public void delete(ParkingSpotModel parkingSpotModel) {
		this.parkingSpotRepository.delete(parkingSpotModel);
	}
	
}
