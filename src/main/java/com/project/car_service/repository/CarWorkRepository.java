package com.project.car_service.repository;

import com.project.car_service.entity.Car;
import com.project.car_service.entity.CarWork;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarWorkRepository extends JpaRepository<CarWork, Long> {

	List<CarWork> findBy();

	List<CarWork> findAllByCar(Car car);
}
