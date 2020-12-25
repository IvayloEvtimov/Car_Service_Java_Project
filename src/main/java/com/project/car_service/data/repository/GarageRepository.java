package com.project.car_service.data.repository;

import com.project.car_service.data.entity.Garage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GarageRepository extends JpaRepository<Garage, String> {

}
