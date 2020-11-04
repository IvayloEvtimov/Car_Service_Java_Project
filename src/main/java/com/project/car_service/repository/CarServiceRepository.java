package com.project.car_service.repository;

import com.project.car_service.entity.Car;
import com.project.car_service.entity.CarService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarServiceRepository extends JpaRepository<CarService, Long> {

	List<CarService> findBy();

	List<CarService> findAllByCar(Car car);
}
