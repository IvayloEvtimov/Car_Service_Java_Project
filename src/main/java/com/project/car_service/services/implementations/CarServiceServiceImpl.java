package com.project.car_service.services.implementations;

import com.project.car_service.data.entity.CarService;
import com.project.car_service.dto.CarServiceDTO;
import com.project.car_service.dto.CreateCarServiceDTO;
import com.project.car_service.dto.UpdateCarServiceDTO;
import com.project.car_service.exceptions.CarServiceNotFoundException;
import com.project.car_service.repository.CarServiceRepository;
import com.project.car_service.services.CarServiceService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Validated
public class CarServiceServiceImpl implements CarServiceService {

	private final CarServiceRepository carServiceRepository;

	private final ModelMapper modelMapper;

	@Override
	public List<CarServiceDTO> getServices() {
		return carServiceRepository.findAll().stream()
				.map(this::convertToCarServiceDTO)
				.collect(Collectors.toList());
	}

	@Override
	public CarServiceDTO getService( @Min(1) Long serviceId ) {
		return modelMapper.map(carServiceRepository.findById(serviceId)
				.orElseThrow(() -> new CarServiceNotFoundException("Invalid school id: " + serviceId)), CarServiceDTO.class);
	}

	@Override
	public CarService createService( @Valid CreateCarServiceDTO createCarServiceDTO ) {
		return carServiceRepository.save(modelMapper.map(createCarServiceDTO, CarService.class));
	}


	@Override
	public CarService updateService( Long serviceId, UpdateCarServiceDTO updateCarServiceDTO ) {
		return carServiceRepository.save(modelMapper.map(updateCarServiceDTO, CarService.class));
	}

	@Override
	public void deleteService( Long serviceId ) {
		carServiceRepository.deleteById(serviceId);
	}

	@Override
	public List<CarServiceDTO> findCarServicesByCar_LicensePlate( String licensePlate ) {
		return carServiceRepository.findCarServicesByCar_LicensePlate(licensePlate).stream().map(this::convertToCarServiceDTO).collect(Collectors.toList());
	}

	@Override
	public List<CarServiceDTO> findCarServicesByEmployee_PID( String PID ) {
		return carServiceRepository.findCarServicesByEmployee_PID(PID).stream().map(this::convertToCarServiceDTO).collect(Collectors.toList());
	}

	@Override
	public List<CarServiceDTO> findCarServicesByCar_LicensePlateAndEmployee_PID( String licensePlate, String PID ) {
		return carServiceRepository.findCarServicesByCar_LicensePlateAndEmployee_PID(licensePlate, PID).stream().map(this::convertToCarServiceDTO).collect(Collectors.toList());
	}

	@Override
	public List<CarServiceDTO> findCarServicesByClient_PID( String PID ) {
		return carServiceRepository.findCarServicesByClient_PID(PID).stream().map(this::convertToCarServiceDTO).collect(Collectors.toList());
	}


	private CarServiceDTO convertToCarServiceDTO( CarService carService ) {
		return modelMapper.map(carService, CarServiceDTO.class);
	}
}
