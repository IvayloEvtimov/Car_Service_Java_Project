package com.project.car_service.controllers.api;

import com.project.car_service.entity.CarService;
import com.project.car_service.services.CarServiceService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/carWork")
@AllArgsConstructor
public class CarServiceApiController {
	private final CarServiceService carServiceService;

	@GetMapping
	public List<CarService> getServices() {
		return carServiceService.getServices();
	}

	@RequestMapping("/{id}")
	public CarService getService(@PathVariable("id") int id) {
		return carServiceService.getService((long) id);
	}

	@PostMapping
	public CarService createCarWor(@RequestBody CarService carWork){
		return carServiceService.create(carWork);
	}


}
