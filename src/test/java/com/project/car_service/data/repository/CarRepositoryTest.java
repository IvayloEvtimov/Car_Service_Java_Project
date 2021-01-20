package com.project.car_service.data.repository;

import com.project.car_service.data.entity.Car;
import com.project.car_service.data.entity.CarBrand;
import com.project.car_service.data.entity.CarModel;
import com.project.car_service.data.entity.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class CarRepositoryTest {
	@Autowired
	private TestEntityManager testEntityManager;

	@Autowired
	private CarRepository carRepository;

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
		testEntityManager.persistAndFlush(carBrand);

		CarModel carModel = new CarModel();
		carModel.setCarModel("Test_Model");
		carModel.setCarBrand(carBrand);
		carModel.setYear(2020);
		testEntityManager.persistAndFlush(carModel);

		Car car = new Car();
		car.setLicensePlate("123ABC");
		car.setOwner(client);
		car.setModel(carModel);
		testEntityManager.persistAndFlush(car);

		Car car1 = new Car();
		car1.setLicensePlate("ABC123");
		car1.setOwner(client);
		car1.setModel(carModel);
		testEntityManager.persistAndFlush(car);

		assertThat(carRepository.findAllByOwner_PID(PID).size()).isEqualTo(2);
	}

	@Test
	void findAllByWrongOwner_PID() {
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
		testEntityManager.persistAndFlush(carBrand);

		CarModel carModel = new CarModel();
		carModel.setCarModel("Test_Model");
		carModel.setCarBrand(carBrand);
		carModel.setYear(2020);
		testEntityManager.persistAndFlush(carModel);

		Car car = new Car();
		car.setLicensePlate("123ABC");
		car.setOwner(person);
		car.setModel(carModel);
		testEntityManager.persistAndFlush(car);

		assertThat(carRepository.findAllByOwner_PID("Something").size()).isEqualTo(0);
	}
}