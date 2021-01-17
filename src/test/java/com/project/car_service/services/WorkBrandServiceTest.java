package com.project.car_service.services;

import com.project.car_service.data.entity.CarBrand;
import com.project.car_service.data.entity.Garage;
import com.project.car_service.data.entity.WorkBrand;
import com.project.car_service.data.repository.WorkBrandRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class WorkBrandServiceTest {

	@MockBean
	private WorkBrandRepository workBrandRepository;

	@Autowired
	private WorkBrandService service;

	@Test
	void getWorkBrandByCarBrand_BrandNameAndGarage_UIC() {
		String brandName = "Brand_Test";
		CarBrand carBrand = new CarBrand();
		carBrand.setBrandName(brandName);

		String UIC = "654312897";
		Garage garage = new Garage();
		garage.setUIC(UIC);
		garage.setName("Test_Garage");
		garage.setAddress("Test_address");

		WorkBrand workBrand = new WorkBrand();
		workBrand.setGarage(garage);
		workBrand.setCarBrand(carBrand);

		Mockito.when(workBrandRepository.getWorkBrandByCarBrand_BrandNameAndGarage_UIC(brandName,UIC)).thenReturn(workBrand);
		assertThat(service.getWorkBrandByCarBrand_BrandNameAndGarage_UIC(brandName,UIC)).isEqualTo(workBrand);


	}
}