package com.project.car_service.services.implementations;

import com.project.car_service.data.entity.Car;
import com.project.car_service.data.repository.CarRepository;
import com.project.car_service.dto.CarDTO;
import com.project.car_service.services.CarService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@AllArgsConstructor
@Validated
public class CarServiceImpl implements CarService {
	private final CarRepository carRepository;

	private final ModelMapper modelMapper;

	@Override
	public List<CarDTO> getCars() {
		return carRepository.findAll().stream();
	}

	private CarDTO convertToCarDTO( Car car ) {
		return modelMapper.map(car, CarDTO.class);
	}
}
 