package com.project.car_service.web.api;

import com.project.car_service.data.entity.CarService;
import com.project.car_service.data.entity.Garage;
import com.project.car_service.dto.*;
import com.project.car_service.services.GarageService;
import com.project.car_service.web.view.model.UpdateCarServiceViewModel;
import com.project.car_service.web.view.model.UpdateGarageViewModel;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/garages")
@AllArgsConstructor
public class GarageServiceApiController {

	private final GarageService garageService;

	private final ModelMapper modelMapper;

	@GetMapping
	public List<GarageDTO> getGarages() {
		return garageService.getGarages();
	}

	@PostMapping
	public Garage createGarage(@RequestBody @Valid Garage garage) {
		return garageService.createGarage(modelMapper.map(garage, CreateGarageDTO.class));
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/{id}")
	public Garage updateGarage(@PathVariable("id") String UIC, @RequestBody UpdateGarageViewModel updateGarageViewModel) {
		return garageService.updateGarage(UIC, modelMapper.map(updateGarageViewModel, UpdateGarageDTO.class));
	}

	@DeleteMapping(value = "/{id}")
	public void deleteGarage(@PathVariable("id") String UIC) {
		garageService.deleteGarage(UIC);
	}

	@GetMapping("/findByUIC/{id}")
	public GarageDTO findByUIC ( @PathVariable("id") String UIC ) {
		return garageService.findByUIC(UIC);
	}
}
