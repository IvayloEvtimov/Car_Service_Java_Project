package com.project.car_service.services;

import com.project.car_service.data.entity.WorkBrand;

public interface WorkBrandService {
	WorkBrand getWorkBrandByCarBrand_BrandNameAndGarage_UIC( String brandName, String UIC);
}
