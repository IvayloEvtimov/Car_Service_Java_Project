package com.project.car_service.data.repository;

import com.project.car_service.data.entity.Car;
import com.project.car_service.dto.CarDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, String> {
}
