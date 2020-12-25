package com.project.car_service.data.repository;

import com.project.car_service.data.entity.CarBrand;
import com.project.car_service.data.entity.WorkBrand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkBrandRepository extends JpaRepository<WorkBrand, String> {
	WorkBrand getWorkBrandByCarBrand_BrandNameAndGarage_UIC(String brandName, String UIC);
}
