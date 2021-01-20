package com.project.car_service.services;

import com.project.car_service.data.entity.Car;
import com.project.car_service.data.entity.CarBrand;
import com.project.car_service.data.entity.CarModel;
import com.project.car_service.data.entity.Person;
import com.project.car_service.data.repository.CarRepository;
import com.project.car_service.dto.CarDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class CarServiceTest {

	@MockBean
	private CarRepository carRepository;

	@MockBean
	private CarService carService;

	@Test
	void findAllByOwner_PID() {
		LocalDate localdate = LocalDate.parse("1990-01-01");
		String PID = "1234567";
		Person person = new Person();
		person.setPID(PID);
		person.setFirstName("First_Test1");
		person.setLastName("Last_Test1");
		person.setDateOfBirth(localdate);
		testEntityManager.persistAndFlush(person);

		CarBrand carBrand = new CarBrand();
		carBrand.setBrandName("Test_Brand");

		CarModel carModel = new CarModel();
		carModel.setCarModel("Test_Model");
		carModel.setCarBrand(carBrand);
		carModel.setYear(2020);

		String licensePlate = "123ABC";
		Car car = new Car();
		car.setLicensePlate(licensePlate);
		car.setOwner(person);
		car.setModel(carModel);

		List<Car> carList = new ArrayList<>();
		carList.add(car);

		Mockito.when(carRepository.findAllByOwner_PID(PID)).thenReturn(carList);

		List<CarDTO> result = carService.findAllByOwner_PID(PID);
		assertThat(result.size()).isEqualTo(carList.size());
	}
}