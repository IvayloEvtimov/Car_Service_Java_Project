package com.project.car_service.data.repository;

import com.project.car_service.data.entity.CarPart;
import com.project.car_service.services.CarPartService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarPartRepository extends JpaRepository<CarPart, Long> {
}
