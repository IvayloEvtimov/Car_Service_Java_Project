package com.project.car_service.web.api;

import com.project.car_service.data.entity.CarService;
import com.project.car_service.dto.*;
import com.project.car_service.services.*;
import com.project.car_service.web.view.model.UpdateCarServiceViewModel;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/carServices")
@AllArgsConstructor
public class CarServiceApiController {

	private final CarServiceService carServiceService;
	private final GarageService garageService;
	private final EmploymentService employmentService;
	private final PersonService personService;
	private final com.project.car_service.services.CarService carService;
	private final QualificationService qualificationService;
	private final WorkBrandService workBrandService;

	private final ModelMapper modelMapper;

	@GetMapping
	public List<CarServiceDTO> getServices() {
		return carServiceService.getServices();
	}

	@RequestMapping("/{id}")
	public CarServiceDTO getService( @PathVariable("id") int id ) {
		return carServiceService.getService((long) id);
	}

	@PostMapping
	public CarService createCarService( @RequestBody @Valid CarService carService ) {
		return carServiceService.createService(modelMapper.map(carService, CreateCarServiceDTO.class));
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/{id}")
	public CarService updateCarService( @PathVariable("id") Long serviceId, @RequestBody UpdateCarServiceViewModel carServiceViewModel ) {

		return carServiceService.updateService(serviceId, modelMapper.map(carServiceViewModel, UpdateCarServiceDTO.class));
	}

	@DeleteMapping(value = "/{id}")
	public void deleteCarService( @PathVariable("id") Long serviceId ) {
		carServiceService.deleteService(serviceId);
	}

	@GetMapping("/findByLicensePlate")
	public List<CarDTO> findByLicensePlateForm() {
		return carService.getCars();
	}

	@GetMapping("/findByLicensePlate/{license}")
	public List<CarServiceDTO> findByLicensePlate( @PathVariable("license") String license ) {
		return carServiceService.findCarServicesByCar_LicensePlate(license);
	}

	@GetMapping("/findByEmployee/")
	public List<EmploymentDTO> findCarServicesByEmployee_PIDForm() {
		return employmentService.getEmployees();
	}

	@GetMapping("/findByEmployee/{PID}")
	public List<CarServiceDTO> findCarServicesByEmployee_PID( @PathVariable("PID") String PID ) {
		return carServiceService.findCarServicesByEmployee_PID(PID);
	}



}
