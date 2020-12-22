package com.project.car_service.repository;

import com.project.car_service.data.entity.Car;
import com.project.car_service.data.entity.CarService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarServiceRepository extends JpaRepository<CarService, Long> {

//	List<CarService> findById();


	List<CarService> findAllByCar(Car car);
}
