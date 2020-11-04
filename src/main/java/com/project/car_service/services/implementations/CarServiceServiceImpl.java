package com.project.car_service.services.implementations;

import com.project.car_service.entity.CarService;
import com.project.car_service.repository.CarServiceRepository;
import com.project.car_service.services.CarServiceService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CarServiceServiceImpl implements CarServiceService {

	private final CarServiceRepository carServiceRepository;


	@Override
	public List<CarService> getServices() {
		return carServiceRepository.findAll();
	}

	@Override
	public CarService getService(Long serviceId) {
		return carServiceRepository.findById(serviceId)
				.orElseThrow(() -> new IllegalArgumentException("Wrong service id: " + serviceId));
	}

	@Override
	public CarService create(CarService carService) {
		return carServiceRepository.save(carService);
	}

	@Override
	public CarService update(Long serviceId, CarService carService) {
		return carServiceRepository.save(carService);
	}

	@Override
	public void deleteCar(Long serviceId) {
		carServiceRepository.deleteById(serviceId);
	}
}
