package com.project.car_service.services;

import com.project.car_service.data.entity.Garage;
import com.project.car_service.dto.CreateGarageDTO;
import com.project.car_service.dto.GarageDTO;
import com.project.car_service.dto.UpdateGarageDTO;

import javax.validation.Valid;
import java.util.List;

public interface GarageService {
	List<GarageDTO> getGarages();

	Garage createGarage(@Valid CreateGarageDTO createGarageDTO);

	Garage updateGarage(String UIC, UpdateGarageDTO updateGarageDTO);

	void deleteGarage(String UIC);

	GarageDTO findByUIC(String UIC);
}
