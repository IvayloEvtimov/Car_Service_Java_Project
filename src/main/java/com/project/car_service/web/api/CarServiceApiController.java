package com.project.car_service.web.api;

import com.project.car_service.data.entity.CarService;
import com.project.car_service.dto.CarServiceDTO;
import com.project.car_service.dto.CreateCarServiceDTO;
import com.project.car_service.dto.UpdateCarServiceDTO;
import com.project.car_service.services.CarServiceService;
import com.project.car_service.web.view.model.UpdateCarServiceViewModel;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/carService")
@AllArgsConstructor
public class CarServiceApiController {

	private final CarServiceService carServiceService;

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

}
