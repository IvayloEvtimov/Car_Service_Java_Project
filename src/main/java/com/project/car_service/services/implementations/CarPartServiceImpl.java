package com.project.car_service.services.implementations;

import com.project.car_service.data.entity.CarPart;
import com.project.car_service.data.repository.CarPartRepository;
import com.project.car_service.dto.CarPartDTO;
import com.project.car_service.services.CarPartService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Validated
public class CarPartServiceImpl implements CarPartService {
	private final CarPartRepository carPartRepository;

	private ModelMapper modelMapper;


	@Override
	public List<CarPartDTO> getCarParts() {
		return carPartRepository.findAll().stream()
				.map(this::convertToCarPartDTO)
				.collect(Collectors.toList());
	}

	private CarPartDTO convertToCarPartDTO(CarPart carPart) {
		return modelMapper.map(carPart, CarPartDTO.class);
	}
}
