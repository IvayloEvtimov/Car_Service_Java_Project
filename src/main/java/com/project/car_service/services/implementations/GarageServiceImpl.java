package com.project.car_service.services.implementations;

import com.project.car_service.data.entity.Garage;
import com.project.car_service.data.repository.GarageRepository;
import com.project.car_service.dto.CreateGarageDTO;
import com.project.car_service.dto.GarageDTO;
import com.project.car_service.dto.PersonDTO;
import com.project.car_service.dto.UpdateGarageDTO;
import com.project.car_service.exceptions.GarageNotFoundException;
import com.project.car_service.exceptions.PersonNotFoundException;
import com.project.car_service.services.GarageService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
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

	@Override
	public Garage createGarage(@Valid CreateGarageDTO createGarageDTO) {
		return garageRepository.save(modelMapper.map(createGarageDTO, Garage.class));
	}

	@Override
	public Garage updateGarage(String UIC, UpdateGarageDTO updateGarageDTO) {
		return garageRepository.save(modelMapper.map(updateGarageDTO, Garage.class));
	}

	@Override
	public void deleteGarage(String UIC) {
		garageRepository.deleteById(UIC);
	}

	@Override
	public GarageDTO findByUIC(String UIC) {
		return modelMapper.map(garageRepository.findById(UIC)
		.orElseThrow(() -> new GarageNotFoundException("Invalid Garage UIC: " + UIC)), GarageDTO.class);
	}

	private GarageDTO convertToGarageDTO(Garage garage) {
		return modelMapper.map(garage, GarageDTO.class);
	}
}
