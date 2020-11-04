package com.project.car_service.services;

import com.project.car_service.entity.*;

import java.util.List;

public interface CarServiceService {

	List<CarService> getServices();

	CarService getService(Long serviceId);

	CarService create(CarService carService);

	CarService update(Long serviceId, CarService carService);

	void deleteCar(Long serviceId);


}
