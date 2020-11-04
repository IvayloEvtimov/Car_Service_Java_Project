package com.project.car_service.services.implementations;

import com.project.car_service.repository.CarWorkRepository;
import com.project.car_service.services.CarService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CarServiceImpl implements CarService {

	private final CarWorkRepository carWorkRepository;


	@Override
	public List<CarWork> getServices() {
		return carWorkRepository.findAll();
	}

	@Override
	public CarWork getService(Long serviceId) {
		return carWorkRepository.findById(serviceId)
				.orElseThrow(() -> new IllegalArgumentException("Wrong service id: " + serviceId));
	}

	@Override
	public CarWork create(CarWork carWork) {
		return carWorkRepository.save(carWork);
	}

	@Override
	public CarWork update(Long serviceId, CarWork carWork) {
		return carWorkRepository.save(carWork);
	}

	@Override
	public void deleteCar(Long serviceId) {
		carWorkRepository.deleteById(serviceId);
	}
}
