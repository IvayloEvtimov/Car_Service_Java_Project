package com.project.car_service.services.implementations;

import com.project.car_service.data.entity.WorkBrand;
import com.project.car_service.data.repository.WorkBrandRepository;
import com.project.car_service.services.WorkBrandService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@AllArgsConstructor
@Validated
public class WorkBrandServiceImpl implements WorkBrandService {
	private final WorkBrandRepository workBrandRepository;

	private final ModelMapper modelMapper;

	@Override
	public WorkBrand getWorkBrandByCarBrand_BrandNameAndGarage_UIC( String brandName, String UIC ) {
		return workBrandRepository.getWorkBrandByCarBrand_BrandNameAndGarage_UIC(brandName,UIC);
	}
}
