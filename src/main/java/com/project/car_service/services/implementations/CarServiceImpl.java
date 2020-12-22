package com.project.car_service.services.implementations;

import com.project.car_service.data.entity.Car;
import com.project.car_service.data.repository.CarRepository;
import com.project.car_service.dto.CarDTO;
import com.project.car_service.services.CarService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Validated

public class CarServiceImpl implements CarService {
	private final CarRepository carRepository;

	private final ModelMapper modelMapper;


	@Override
	public List<CarDTO> getCars() {
		return carRepository.findAll().stream()
				.map(this::convertToCarDTO)
				.collect(Collectors.toList());
	}


	private CarDTO convertToCarDTO( Car car ) {
		return modelMapper.map(car, CarDTO.class);
	}
}
 