package com.project.car_service.services;

import com.project.car_service.dto.CarDTO;

import java.util.List;

public interface CarService {
	List<CarDTO> getCars();

	List<CarDTO> findAllByOwner_PID(String PID);
}
