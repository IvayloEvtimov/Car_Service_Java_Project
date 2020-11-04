package com.project.car_service.controllers.api;

import com.project.car_service.entity.CarWork;
import com.project.car_service.services.CarService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/carWork")
@AllArgsConstructor
public class CarWorkApiController {
	private final CarService carService;

	@GetMapping
	public List<CarWork> getServices() {
		return carService.getServices();
	}

	@RequestMapping("/{id}")
	public CarWork getService(@PathVariable("id") int id) {
		return carService.getService((long) id);
	}

	@PostMapping
	public CarWork createCarWor(@RequestBody CarWork carWork){
		return carService.create(carWork);
	}


}
