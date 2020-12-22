package com.project.car_service.services;

import com.project.car_service.dto.GarageDTO;

import java.util.List;

public interface GarageService {
	List<GarageDTO> getGarages();
}
