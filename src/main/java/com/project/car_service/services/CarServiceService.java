package com.project.car_service.services;

import com.project.car_service.data.entity.CarService;
import com.project.car_service.dto.CarServiceDTO;
import com.project.car_service.dto.CreateCarServiceDTO;
import com.project.car_service.dto.UpdateCarServiceDTO;

import java.util.List;

public interface CarServiceService {

	List<CarServiceDTO> getServices();

	CarServiceDTO getService( Long serviceId );

	CarService createService( CreateCarServiceDTO createCarServiceDTO );

	CarService updateService( Long serviceId, UpdateCarServiceDTO updateCarServiceDTO );

	void deleteService( Long serviceId );


}
