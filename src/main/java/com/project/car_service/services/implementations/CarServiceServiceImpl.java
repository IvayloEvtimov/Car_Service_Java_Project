package com.project.car_service.services.implementations;

import com.project.car_service.data.entity.CarService;
import com.project.car_service.data.entity.Person;
import com.project.car_service.dto.CarServiceDTO;
import com.project.car_service.dto.CreateCarServiceDTO;
import com.project.car_service.dto.PersonDTO;
import com.project.car_service.dto.UpdateCarServiceDTO;
import com.project.car_service.exceptions.CarServiceNotFoundException;
import com.project.car_service.data.repository.CarServiceRepository;
import com.project.car_service.services.CarServiceService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.AbstractMap;
import java.util.HashSet;
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

	// Maybe Useless
//	@Override
//	public List<CarServiceDTO> findCarServicesByCar_LicensePlateAndEmployee_PID( String licensePlate, String PID ) {
//		return carServiceRepository.findCarServicesByCar_LicensePlateAndEmployee_PID(licensePlate, PID).stream().map(this::convertToCarServiceDTO).collect(Collectors.toList());
//	}

	@Override
	public List<CarServiceDTO> findCarServicesByClient_PID( String PID ) {
		return carServiceRepository.findCarServicesByClient_PID(PID).stream().map(this::convertToCarServiceDTO).collect(Collectors.toList());
	}

	@Override
	public List<PersonDTO> findAllClients() {
		return carServiceRepository.findAllClients().stream().map(this::convertToPersonDTO).collect(Collectors.toList());
	}

	@Override
	public Integer countAllByCar_Model_CarBrand_BrandName( String brand ) {
		return carServiceRepository.countAllByCar_Model_CarBrand_BrandName(brand);
	}

	@Override
	public Integer countAllByCar_Model_Year( Integer year ) {
		return carServiceRepository.countAllByCar_Model_Year(year);
	}

	@Override
	public Integer countAllByQualification_QualificationName( String name ) {
		return carServiceRepository.countAllByQualification_QualificationName(name);
	}

	@Override
	public List<String> findAllBrands() {
		return carServiceRepository.findAllBrands();
	}

	@Override
	public List<Integer> findAllCarYears() {
		return carServiceRepository.findAllCarYears();
	}

	@Override
	public List<String> findAllQualifications() {
		return carServiceRepository.findAllQualifications();
	}

	@Override
	public HashSet<AbstractMap.SimpleEntry<String, Integer>> countCarBrands() {
		List<String> brands = findAllBrands();

		HashSet<AbstractMap.SimpleEntry<String, Integer>> hashSet = new HashSet<>();

		for (String brand : brands) {
			AbstractMap.SimpleEntry<String, Integer> entry = new AbstractMap.SimpleEntry<>(brand, countAllByCar_Model_CarBrand_BrandName(brand));

			hashSet.add(entry);
		}

		return hashSet;
	}

	@Override
	public HashSet<AbstractMap.SimpleEntry<Integer, Integer>> countCarYears() {
		List<Integer> carYears = findAllCarYears();

		HashSet<AbstractMap.SimpleEntry<Integer, Integer>> hashSet = new HashSet<>();

		for (Integer year : carYears) {
			AbstractMap.SimpleEntry<Integer, Integer> entry = new AbstractMap.SimpleEntry<>(year, countAllByCar_Model_Year(year));
			hashSet.add(entry);
		}

		return hashSet;
	}

	@Override
	public HashSet<AbstractMap.SimpleEntry<String, Integer>> countQualifications() {
		List<String> qualificationList = findAllQualifications();
		HashSet<AbstractMap.SimpleEntry<String, Integer>> hashSet = new HashSet<>();

		for (String qualification : qualificationList) {
			AbstractMap.SimpleEntry<String, Integer> entry = new AbstractMap.SimpleEntry<>(qualification, countAllByQualification_QualificationName(qualification));
			hashSet.add(entry);
		}

		return hashSet;
	}

	private CarServiceDTO convertToCarServiceDTO( CarService carService ) {
		return modelMapper.map(carService, CarServiceDTO.class);
	}

	private PersonDTO convertToPersonDTO( Person person ) {
		return modelMapper.map(person, PersonDTO.class);
	}
}
