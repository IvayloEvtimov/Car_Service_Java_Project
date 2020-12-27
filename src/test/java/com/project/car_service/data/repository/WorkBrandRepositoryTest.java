package com.project.car_service.data.repository;

import com.project.car_service.data.entity.CarBrand;
import com.project.car_service.data.entity.Garage;
import com.project.car_service.data.entity.WorkBrand;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class WorkBrandRepositoryTest {

	@Autowired
	private TestEntityManager testEntityManager;

	@Autowired
	private WorkBrandRepository workBrandRepository;

	@Test
	public void getWorkBrandByCarBrand_BrandNameAndGarage_UIC(){
		String brandName = "Brand_Test";
		CarBrand carBrand = new CarBrand();
		carBrand.setBrandName(brandName);
		testEntityManager.persistAndFlush(carBrand);

		String UIC = "654312897";
		Garage garage = new Garage();
		garage.setUIC(UIC);
		garage.setName("Test_Garage");
		garage.setAddress("Test_address");
		testEntityManager.persistAndFlush(garage);

		WorkBrand workBrand = new WorkBrand();
		workBrand.setGarage(garage);
		workBrand.setCarBrand(carBrand);
		testEntityManager.persistAndFlush(workBrand);

		assertThat(workBrandRepository.getWorkBrandByCarBrand_BrandNameAndGarage_UIC(brandName,UIC)).isNotEqualTo(null);
	}
}
