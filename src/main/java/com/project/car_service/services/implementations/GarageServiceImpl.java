package com.project.car_service.services.implementations;

import com.project.car_service.data.entity.Garage;
import com.project.car_service.data.repository.GarageRepository;
import com.project.car_service.dto.GarageDTO;
import com.project.car_service.services.GarageService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Validated
public class GarageServiceImpl implements GarageService {

	private final GarageRepository garageRepository;

	private final ModelMapper modelMapper;

	@Override
	public List<GarageDTO> getGarages() {
		return garageRepository.findAll().stream()
				.map(this::convertToGarageDTO)
				.collect(Collectors.toList());
	}


	private GarageDTO convertToGarageDTO( Garage garage ) {
		return modelMapper.map(garage, GarageDTO.class);
	}
}
