package com.project.car_service.data.repository;

import com.project.car_service.data.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, String> {
	List<Car> findAllByOwner_PID(String PID);
}
