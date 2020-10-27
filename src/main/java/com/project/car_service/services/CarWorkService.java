package com.project.car_service.services;

import com.project.car_service.entity.*;

import java.util.List;

public interface CarWorkService {

	List<CarWork> getServices();

	CarWork getService(Long serviceId);

	CarWork create(CarWork carWork);

	CarWork update(Long serviceId, CarWork carWork);

	void deleteCar(Long serviceId);


}
