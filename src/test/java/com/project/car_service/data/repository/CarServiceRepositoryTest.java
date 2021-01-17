package com.project.car_service.data.repository;

import com.project.car_service.data.entity.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.time.LocalDate;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class CarServiceRepositoryTest {
	@Autowired
	private TestEntityManager testEntityManager;

	@Autowired
	private CarServiceRepository carServiceRepository;

	@Test
	void findCarServicesByCar_LicensePlate() {
		LocalDate localdate = LocalDate.parse("1990-01-01");
		Person employee = new Person();
		employee.setPID("1234567");
		employee.setFirstName("First_Test1");
		employee.setLastName("Last_Test1");
		employee.setDateOfBirth(localdate);
		testEntityManager.persistAndFlush(employee);

		Person employee2 = new Person();
		employee2.setPID("54321");
		employee2.setFirstName("First_Test2");
		employee2.setLastName("Last_Test2");
		employee2.setDateOfBirth(localdate);
		testEntityManager.persistAndFlush(employee2);

		Garage garage = new Garage();
		garage.setUIC("654312897");
		garage.setName("Test_Garage");
		garage.setAddress("Test_address");
		testEntityManager.persistAndFlush(garage);

		Garage garage2 = new Garage();
		garage2.setUIC("542345");
		garage2.setName("Test_Garage2");
		garage2.setAddress("Test_address2");
		testEntityManager.persistAndFlush(garage2);

		Qualification qualification = new Qualification();
		qualification.setQualificationName("Test_Qualification");
		testEntityManager.persistAndFlush(qualification);

		Person client = new Person();
		client.setPID("1231312423");
		client.setFirstName("First_Test1");
		client.setLastName("Last_Test1");
		client.setDateOfBirth(localdate);
		testEntityManager.persistAndFlush(client);

		CarBrand carBrand = new CarBrand();
		carBrand.setBrandName("Test_Brand");
		testEntityManager.persistAndFlush(carBrand);

		CarModel carModel = new CarModel();
		carModel.setCarModel("Test_Model");
		carModel.setCarBrand(carBrand);
		carModel.setYear(2020);
		testEntityManager.persistAndFlush(carModel);

		String licensePlate = "123ABC";
		Car car = new Car();
		car.setLicensePlate(licensePlate);
		car.setOwner(client);
		car.setModel(carModel);
		testEntityManager.persistAndFlush(car);

		CarService carService = new CarService();
//		carService.setServiceID(1000L);
		carService.setGarage(garage);
		carService.setEmployee(employee);
		carService.setClient(client);
		carService.setCar(car);
		carService.setQualification(qualification);
		carService.setDateOfService(new Date());
		carService.setPrice(123);
		testEntityManager.persistAndFlush(carService);

		CarService carService2 = new CarService();
//		carService2.setServiceID(1000L);
		carService2.setGarage(garage2);
		carService2.setEmployee(employee2);
		carService2.setClient(client);
		carService2.setCar(car);
		carService2.setQualification(qualification);
		carService2.setDateOfService(new Date());
		carService2.setPrice(123);
		testEntityManager.persistAndFlush(carService2);

		assertThat(carServiceRepository.findCarServicesByCar_LicensePlate(licensePlate).size()).isEqualTo(2);
	}

	@Test
	void findCarServicesByWrongCar_LicensePlate() {
		LocalDate localdate = LocalDate.parse("1990-01-01");
		Person employee = new Person();
		employee.setPID("1234567");
		employee.setFirstName("First_Test1");
		employee.setLastName("Last_Test1");
		employee.setDateOfBirth(localdate);
		testEntityManager.persistAndFlush(employee);

		Garage garage = new Garage();
		garage.setUIC("654312897");
		garage.setName("Test_Garage");
		garage.setAddress("Test_address");
		testEntityManager.persistAndFlush(garage);

		Qualification qualification = new Qualification();
		qualification.setQualificationName("Test_Qualification");
		testEntityManager.persistAndFlush(qualification);

		Person client = new Person();
		client.setPID("1231312423");
		client.setFirstName("First_Test1");
		client.setLastName("Last_Test1");
		client.setDateOfBirth(localdate);
		testEntityManager.persistAndFlush(client);

		CarBrand carBrand = new CarBrand();
		carBrand.setBrandName("Test_Brand");
		testEntityManager.persistAndFlush(carBrand);

		CarModel carModel = new CarModel();
		carModel.setCarModel("Test_Model");
		carModel.setCarBrand(carBrand);
		carModel.setYear(2020);
		testEntityManager.persistAndFlush(carModel);

		String licensePlate = "123ABC";
		Car car = new Car();
		car.setLicensePlate(licensePlate);
		car.setOwner(client);
		car.setModel(carModel);
		testEntityManager.persistAndFlush(car);

		CarService carService = new CarService();
//		carService.setServiceID(1000L);
		carService.setGarage(garage);
		carService.setEmployee(employee);
		carService.setClient(client);
		carService.setCar(car);
		carService.setQualification(qualification);
		carService.setDateOfService(new Date());
		carService.setPrice(123);
		testEntityManager.persistAndFlush(carService);

		assertThat(carServiceRepository.findCarServicesByCar_LicensePlate("ABC123").size()).isEqualTo(0);
	}

	@Test
	void findCarServicesByEmployee_PID() {
		String PID = "1234567";
		LocalDate localdate = LocalDate.parse("1990-01-01");
		Person employee = new Person();
		employee.setPID(PID);
		employee.setFirstName("First_Test1");
		employee.setLastName("Last_Test1");
		employee.setDateOfBirth(localdate);
		testEntityManager.persistAndFlush(employee);


		Garage garage = new Garage();
		garage.setUIC("654312897");
		garage.setName("Test_Garage");
		garage.setAddress("Test_address");
		testEntityManager.persistAndFlush(garage);

		Garage garage2 = new Garage();
		garage2.setUIC("542345");
		garage2.setName("Test_Garage2");
		garage2.setAddress("Test_address2");
		testEntityManager.persistAndFlush(garage2);

		Qualification qualification = new Qualification();
		qualification.setQualificationName("Test_Qualification");
		testEntityManager.persistAndFlush(qualification);

		Person client = new Person();
		client.setPID("1231312423");
		client.setFirstName("First_Test1");
		client.setLastName("Last_Test1");
		client.setDateOfBirth(localdate);
		testEntityManager.persistAndFlush(client);

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

		CarService carService = new CarService();
//		carService.setServiceID(1000L);
		carService.setGarage(garage);
		carService.setEmployee(employee);
		carService.setClient(client);
		carService.setCar(car);
		carService.setQualification(qualification);
		carService.setDateOfService(new Date());
		carService.setPrice(123);
		testEntityManager.persistAndFlush(carService);

		CarService carService2 = new CarService();
//		carService2.setServiceID(1000L);
		carService2.setGarage(garage2);
		carService2.setEmployee(employee);
		carService2.setClient(client);
		carService2.setCar(car);
		carService2.setQualification(qualification);
		carService2.setDateOfService(new Date());
		carService2.setPrice(123);
		testEntityManager.persistAndFlush(carService2);

		assertThat(carServiceRepository.findCarServicesByEmployee_PID(PID).size()).isEqualTo(2);
	}

	@Test
	void findCarServicesByWrongEmployee_PID() {
		String PID = "1234567";
		LocalDate localdate = LocalDate.parse("1990-01-01");
		Person employee = new Person();
		employee.setPID(PID);
		employee.setFirstName("First_Test1");
		employee.setLastName("Last_Test1");
		employee.setDateOfBirth(localdate);
		testEntityManager.persistAndFlush(employee);


		Garage garage = new Garage();
		garage.setUIC("654312897");
		garage.setName("Test_Garage");
		garage.setAddress("Test_address");
		testEntityManager.persistAndFlush(garage);

		Garage garage2 = new Garage();
		garage2.setUIC("542345");
		garage2.setName("Test_Garage2");
		garage2.setAddress("Test_address2");
		testEntityManager.persistAndFlush(garage);

		Qualification qualification = new Qualification();
		qualification.setQualificationName("Test_Qualification");
		testEntityManager.persistAndFlush(qualification);

		Person client = new Person();
		client.setPID("1231312423");
		client.setFirstName("First_Test1");
		client.setLastName("Last_Test1");
		client.setDateOfBirth(localdate);
		testEntityManager.persistAndFlush(client);

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

		CarService carService = new CarService();
//		carService.setServiceID(1000L);
		carService.setGarage(garage);
		carService.setEmployee(employee);
		carService.setClient(client);
		carService.setCar(car);
		carService.setQualification(qualification);
		carService.setDateOfService(new Date());
		carService.setPrice(123);
		testEntityManager.persistAndFlush(carService);


		assertThat(carServiceRepository.findCarServicesByEmployee_PID("423918748").size()).isEqualTo(0);
	}

	@Test
	void findCarServicesByCar_LicensePlateAndEmployee_PID() {

		String PID = "1234567";
		LocalDate localdate = LocalDate.parse("1990-01-01");
		Person employee = new Person();
		employee.setPID(PID);
		employee.setFirstName("First_Test1");
		employee.setLastName("Last_Test1");
		employee.setDateOfBirth(localdate);
		testEntityManager.persistAndFlush(employee);


		Garage garage = new Garage();
		garage.setUIC("654312897");
		garage.setName("Test_Garage");
		garage.setAddress("Test_address");
		testEntityManager.persistAndFlush(garage);

		Garage garage2 = new Garage();
		garage2.setUIC("542345");
		garage2.setName("Test_Garage2");
		garage2.setAddress("Test_address2");
		testEntityManager.persistAndFlush(garage2);

		Qualification qualification = new Qualification();
		qualification.setQualificationName("Test_Qualification");
		testEntityManager.persistAndFlush(qualification);

		Person client = new Person();
		client.setPID("1231312423");
		client.setFirstName("First_Test1");
		client.setLastName("Last_Test1");
		client.setDateOfBirth(localdate);
		testEntityManager.persistAndFlush(client);

		CarBrand carBrand = new CarBrand();
		carBrand.setBrandName("Test_Brand");
		testEntityManager.persistAndFlush(carBrand);

		CarModel carModel = new CarModel();
		carModel.setCarModel("Test_Model");
		carModel.setCarBrand(carBrand);
		carModel.setYear(2020);
		testEntityManager.persistAndFlush(carModel);

		String licensePlate = "123ABC";
		Car car = new Car();
		car.setLicensePlate(licensePlate);
		car.setOwner(client);
		car.setModel(carModel);
		testEntityManager.persistAndFlush(car);

		CarService carService = new CarService();
//		carService.setServiceID(1000L);
		carService.setGarage(garage);
		carService.setEmployee(employee);
		carService.setClient(client);
		carService.setCar(car);
		carService.setQualification(qualification);
		carService.setDateOfService(new Date());
		carService.setPrice(123);
		testEntityManager.persistAndFlush(carService);

		CarService carService2 = new CarService();
//		carService2.setServiceID(1000L);
		carService2.setGarage(garage2);
		carService2.setEmployee(employee);
		carService2.setClient(client);
		carService2.setCar(car);
		carService2.setQualification(qualification);
		carService2.setDateOfService(new Date());
		carService2.setPrice(123);
		testEntityManager.persistAndFlush(carService2);

		assertThat(carServiceRepository.findCarServicesByCar_LicensePlateAndEmployee_PID(licensePlate, PID).size()).isEqualTo(2);
	}

	@Test
	void findCarServicesByWrongCar_LicensePlateAndEmployee_PID() {
		String PID = "1234567";
		LocalDate localdate = LocalDate.parse("1990-01-01");
		Person employee = new Person();
		employee.setPID(PID);
		employee.setFirstName("First_Test1");
		employee.setLastName("Last_Test1");
		employee.setDateOfBirth(localdate);
		testEntityManager.persistAndFlush(employee);


		Garage garage = new Garage();
		garage.setUIC("654312897");
		garage.setName("Test_Garage");
		garage.setAddress("Test_address");
		testEntityManager.persistAndFlush(garage);

		Garage garage2 = new Garage();
		garage2.setUIC("542345");
		garage2.setName("Test_Garage2");
		garage2.setAddress("Test_address2");
		testEntityManager.persistAndFlush(garage2);

		Qualification qualification = new Qualification();
		qualification.setQualificationName("Test_Qualification");
		testEntityManager.persistAndFlush(qualification);

		Person client = new Person();
		client.setPID("1231312423");
		client.setFirstName("First_Test1");
		client.setLastName("Last_Test1");
		client.setDateOfBirth(localdate);
		testEntityManager.persistAndFlush(client);

		CarBrand carBrand = new CarBrand();
		carBrand.setBrandName("Test_Brand");
		testEntityManager.persistAndFlush(carBrand);

		CarModel carModel = new CarModel();
		carModel.setCarModel("Test_Model");
		carModel.setCarBrand(carBrand);
		carModel.setYear(2020);
		testEntityManager.persistAndFlush(carModel);

		String licensePlate = "123ABC";
		Car car = new Car();
		car.setLicensePlate(licensePlate);
		car.setOwner(client);
		car.setModel(carModel);
		testEntityManager.persistAndFlush(car);

		CarService carService = new CarService();
//		carService.setServiceID(1000L);
		carService.setGarage(garage);
		carService.setEmployee(employee);
		carService.setClient(client);
		carService.setCar(car);
		carService.setQualification(qualification);
		carService.setDateOfService(new Date());
		carService.setPrice(123);
		testEntityManager.persistAndFlush(carService);

		CarService carService2 = new CarService();
//		carService2.setServiceID(1000L);
		carService2.setGarage(garage2);
		carService2.setEmployee(employee);
		carService2.setClient(client);
		carService2.setCar(car);
		carService2.setQualification(qualification);
		carService2.setDateOfService(new Date());
		carService2.setPrice(123);
		testEntityManager.persistAndFlush(carService);

		assertThat(carServiceRepository.findCarServicesByCar_LicensePlateAndEmployee_PID("ABC123", PID).size()).isEqualTo(0);
	}

	@Test
	void findCarServicesByCar_LicensePlateAndWrongEmployee_PID() {
		String PID = "1234567";
		LocalDate localdate = LocalDate.parse("1990-01-01");
		Person employee = new Person();
		employee.setPID(PID);
		employee.setFirstName("First_Test1");
		employee.setLastName("Last_Test1");
		employee.setDateOfBirth(localdate);
		testEntityManager.persistAndFlush(employee);

		Garage garage = new Garage();
		garage.setUIC("654312897");
		garage.setName("Test_Garage");
		garage.setAddress("Test_address");
		testEntityManager.persistAndFlush(garage);

		Garage garage2 = new Garage();
		garage2.setUIC("542345");
		garage2.setName("Test_Garage2");
		garage2.setAddress("Test_address2");
		testEntityManager.persistAndFlush(garage);

		Qualification qualification = new Qualification();
		qualification.setQualificationName("Test_Qualification");
		testEntityManager.persistAndFlush(qualification);

		Person client = new Person();
		client.setPID("1231312423");
		client.setFirstName("First_Test1");
		client.setLastName("Last_Test1");
		client.setDateOfBirth(localdate);
		testEntityManager.persistAndFlush(client);

		CarBrand carBrand = new CarBrand();
		carBrand.setBrandName("Test_Brand");
		testEntityManager.persistAndFlush(carBrand);

		CarModel carModel = new CarModel();
		carModel.setCarModel("Test_Model");
		carModel.setCarBrand(carBrand);
		carModel.setYear(2020);
		testEntityManager.persistAndFlush(carModel);

		String licensePlate = "123ABC";
		Car car = new Car();
		car.setLicensePlate(licensePlate);
		car.setOwner(client);
		car.setModel(carModel);
		testEntityManager.persistAndFlush(car);

		CarService carService = new CarService();
//		carService.setServiceID(1000L);
		carService.setGarage(garage);
		carService.setEmployee(employee);
		carService.setClient(client);
		carService.setCar(car);
		carService.setQualification(qualification);
		carService.setDateOfService(new Date());
		carService.setPrice(123);
		testEntityManager.persistAndFlush(carService);

		CarService carService2 = new CarService();
//		carService2.setServiceID(1000L);
		carService2.setGarage(garage2);
		carService2.setEmployee(employee);
		carService2.setClient(client);
		carService2.setCar(car);
		carService2.setQualification(qualification);
		carService2.setDateOfService(new Date());
		carService2.setPrice(123);
		testEntityManager.persistAndFlush(carService);

		assertThat(carServiceRepository.findCarServicesByCar_LicensePlateAndEmployee_PID(licensePlate, "89832982").size()).isEqualTo(0);
	}

	@Test
	void findCarServicesByWrongCar_LicensePlateAndWrongEmployee_PID() {
		String PID = "1234567";
		LocalDate localdate = LocalDate.parse("1990-01-01");
		Person employee = new Person();
		employee.setPID(PID);
		employee.setFirstName("First_Test1");
		employee.setLastName("Last_Test1");
		employee.setDateOfBirth(localdate);
		testEntityManager.persistAndFlush(employee);


		Garage garage = new Garage();
		garage.setUIC("654312897");
		garage.setName("Test_Garage");
		garage.setAddress("Test_address");
		testEntityManager.persistAndFlush(garage);

		Garage garage2 = new Garage();
		garage2.setUIC("542345");
		garage2.setName("Test_Garage2");
		garage2.setAddress("Test_address2");
		testEntityManager.persistAndFlush(garage);

		Qualification qualification = new Qualification();
		qualification.setQualificationName("Test_Qualification");
		testEntityManager.persistAndFlush(qualification);

		Person client = new Person();
		client.setPID("1231312423");
		client.setFirstName("First_Test1");
		client.setLastName("Last_Test1");
		client.setDateOfBirth(localdate);
		testEntityManager.persistAndFlush(client);

		CarBrand carBrand = new CarBrand();
		carBrand.setBrandName("Test_Brand");
		testEntityManager.persistAndFlush(carBrand);

		CarModel carModel = new CarModel();
		carModel.setCarModel("Test_Model");
		carModel.setCarBrand(carBrand);
		carModel.setYear(2020);
		testEntityManager.persistAndFlush(carModel);

		String licensePlate = "123ABC";
		Car car = new Car();
		car.setLicensePlate(licensePlate);
		car.setOwner(client);
		car.setModel(carModel);
		testEntityManager.persistAndFlush(car);

		CarService carService = new CarService();
//		carService.setServiceID(1000L);
		carService.setGarage(garage);
		carService.setEmployee(employee);
		carService.setClient(client);
		carService.setCar(car);
		carService.setQualification(qualification);
		carService.setDateOfService(new Date());
		carService.setPrice(123);
		testEntityManager.persistAndFlush(carService);

		CarService carService2 = new CarService();
//		carService2.setServiceID(1000L);
		carService2.setGarage(garage2);
		carService2.setEmployee(employee);
		carService2.setClient(client);
		carService2.setCar(car);
		carService2.setQualification(qualification);
		carService2.setDateOfService(new Date());
		carService2.setPrice(123);
		testEntityManager.persistAndFlush(carService);

		assertThat(carServiceRepository.findCarServicesByCar_LicensePlateAndEmployee_PID("ABC123", "89832982").size()).isEqualTo(0);
	}

	@Test
	void findCarServicesByClient_PID() {
		LocalDate localdate = LocalDate.parse("1990-01-01");
		Person employee = new Person();
		employee.setPID("1234567");
		employee.setFirstName("First_Test1");
		employee.setLastName("Last_Test1");
		employee.setDateOfBirth(localdate);
		testEntityManager.persistAndFlush(employee);

		Garage garage = new Garage();
		garage.setUIC("654312897");
		garage.setName("Test_Garage");
		garage.setAddress("Test_address");
		testEntityManager.persistAndFlush(garage);

		Qualification qualification = new Qualification();
		qualification.setQualificationName("Test_Qualification");
		testEntityManager.persistAndFlush(qualification);

		String PID = "1231312423";
		Person client = new Person();
		client.setPID(PID);
		client.setFirstName("First_Test1");
		client.setLastName("Last_Test1");
		client.setDateOfBirth(localdate);
		testEntityManager.persistAndFlush(client);


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

		Car car2 = new Car();
		car2.setLicensePlate("ABC123");
		car2.setOwner(client);
		car2.setModel(carModel);
		testEntityManager.persistAndFlush(car2);

		CarService carService = new CarService();
//		carService.setServiceID(1000L);
		carService.setGarage(garage);
		carService.setEmployee(employee);
		carService.setClient(client);
		carService.setCar(car);
		carService.setQualification(qualification);
		carService.setDateOfService(new Date());
		carService.setPrice(123);
		testEntityManager.persistAndFlush(carService);

		CarService carService2 = new CarService();
//		carService2.setServiceID(1000L);
		carService2.setGarage(garage);
		carService2.setEmployee(employee);
		carService2.setClient(client);
		carService2.setCar(car2);
		carService2.setQualification(qualification);
		carService2.setDateOfService(new Date());
		carService2.setPrice(123);
		testEntityManager.persistAndFlush(carService2);

		assertThat(carServiceRepository.findCarServicesByClient_PID(PID).size()).isEqualTo(2);
	}

	@Test
	void findCarServicesByWrongClient_PID() {
		LocalDate localdate = LocalDate.parse("1990-01-01");
		Person employee = new Person();
		employee.setPID("1234567");
		employee.setFirstName("First_Test1");
		employee.setLastName("Last_Test1");
		employee.setDateOfBirth(localdate);
		testEntityManager.persistAndFlush(employee);

		Garage garage = new Garage();
		garage.setUIC("654312897");
		garage.setName("Test_Garage");
		garage.setAddress("Test_address");
		testEntityManager.persistAndFlush(garage);

		Qualification qualification = new Qualification();
		qualification.setQualificationName("Test_Qualification");
		testEntityManager.persistAndFlush(qualification);

		String PID = "1231312423";
		Person client = new Person();
		client.setPID(PID);
		client.setFirstName("First_Test1");
		client.setLastName("Last_Test1");
		client.setDateOfBirth(localdate);
		testEntityManager.persistAndFlush(client);


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

		CarService carService = new CarService();
//		carService.setServiceID(1000L);
		carService.setGarage(garage);
		carService.setEmployee(employee);
		carService.setClient(client);
		carService.setCar(car);
		carService.setQualification(qualification);
		carService.setDateOfService(new Date());
		carService.setPrice(123);
		testEntityManager.persistAndFlush(carService);

		assertThat(carServiceRepository.findCarServicesByClient_PID("583947539").size()).isEqualTo(0);
	}

	@Test
	void findAllClients() {
		LocalDate localdate = LocalDate.parse("1990-01-01");
		Person employee = new Person();
		employee.setPID("1234567");
		employee.setFirstName("First_Test1");
		employee.setLastName("Last_Test1");
		employee.setDateOfBirth(localdate);
		testEntityManager.persistAndFlush(employee);

		Garage garage = new Garage();
		garage.setUIC("654312897");
		garage.setName("Test_Garage");
		garage.setAddress("Test_address");
		testEntityManager.persistAndFlush(garage);

		Qualification qualification = new Qualification();
		qualification.setQualificationName("Test_Qualification");
		testEntityManager.persistAndFlush(qualification);


		Person client = new Person();
		client.setPID("1231312423");
		client.setFirstName("First_Test1");
		client.setLastName("Last_Test1");
		client.setDateOfBirth(localdate);
		testEntityManager.persistAndFlush(client);

		Person client2 = new Person();
		client2.setPID("58434957");
		client2.setFirstName("First_Test1");
		client2.setLastName("Last_Test1");
		client2.setDateOfBirth(localdate);
		testEntityManager.persistAndFlush(client2);

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

		Car car2 = new Car();
		car2.setLicensePlate("ABC123");
		car2.setOwner(client2);
		car2.setModel(carModel);
		testEntityManager.persistAndFlush(car2);

		CarService carService = new CarService();
//		carService.setServiceID(1000L);
		carService.setGarage(garage);
		carService.setEmployee(employee);
		carService.setClient(client);
		carService.setCar(car);
		carService.setQualification(qualification);
		carService.setDateOfService(new Date());
		carService.setPrice(123);
		testEntityManager.persistAndFlush(carService);

		CarService carService2 = new CarService();
//		carService2.setServiceID(1000L);
		carService2.setGarage(garage);
		carService2.setEmployee(employee);
		carService2.setClient(client2);
		carService2.setCar(car2);
		carService2.setQualification(qualification);
		carService2.setDateOfService(new Date());
		carService2.setPrice(123);
		testEntityManager.persistAndFlush(carService2);

		assertThat(carServiceRepository.findAllClients().size()).isEqualTo(2);
	}

	@Test
	void findAllBrands() {
		LocalDate localdate = LocalDate.parse("1990-01-01");
		Person employee = new Person();
		employee.setPID("1234567");
		employee.setFirstName("First_Test1");
		employee.setLastName("Last_Test1");
		employee.setDateOfBirth(localdate);
		testEntityManager.persistAndFlush(employee);

		Garage garage = new Garage();
		garage.setUIC("654312897");
		garage.setName("Test_Garage");
		garage.setAddress("Test_address");
		testEntityManager.persistAndFlush(garage);

		Qualification qualification = new Qualification();
		qualification.setQualificationName("Test_Qualification");
		testEntityManager.persistAndFlush(qualification);

		String PID = "1231312423";
		Person client = new Person();
		client.setPID(PID);
		client.setFirstName("First_Test1");
		client.setLastName("Last_Test1");
		client.setDateOfBirth(localdate);
		testEntityManager.persistAndFlush(client);


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

		CarBrand carBrand2 = new CarBrand();
		carBrand2.setBrandName("Test_Brand2");
		testEntityManager.persistAndFlush(carBrand2);

		CarModel carModel2 = new CarModel();
		carModel2.setCarModel("Test_Model2");
		carModel2.setCarBrand(carBrand2);
		carModel2.setYear(2020);
		testEntityManager.persistAndFlush(carModel2);

		Car car2 = new Car();
		car2.setLicensePlate("ABC123");
		car2.setOwner(client);
		car2.setModel(carModel2);
		testEntityManager.persistAndFlush(car2);

		CarService carService = new CarService();
//		carService.setServiceID(1000L);
		carService.setGarage(garage);
		carService.setEmployee(employee);
		carService.setClient(client);
		carService.setCar(car);
		carService.setQualification(qualification);
		carService.setDateOfService(new Date());
		carService.setPrice(123);
		testEntityManager.persistAndFlush(carService);

		CarService carService2 = new CarService();
//		carService2.setServiceID(1001L);
		carService2.setGarage(garage);
		carService2.setEmployee(employee);
		carService2.setClient(client);
		carService2.setCar(car2);
		carService2.setQualification(qualification);
		carService2.setDateOfService(new Date());
		carService2.setPrice(123);
		testEntityManager.persistAndFlush(carService2);

		assertThat(carServiceRepository.findAllBrands().size()).isEqualTo(2);
	}

	@Test
	void findAllCarYears() {
		LocalDate localdate = LocalDate.parse("1990-01-01");
		Person employee = new Person();
		employee.setPID("1234567");
		employee.setFirstName("First_Test1");
		employee.setLastName("Last_Test1");
		employee.setDateOfBirth(localdate);
		testEntityManager.persistAndFlush(employee);

		Garage garage = new Garage();
		garage.setUIC("654312897");
		garage.setName("Test_Garage");
		garage.setAddress("Test_address");
		testEntityManager.persistAndFlush(garage);

		Qualification qualification = new Qualification();
		qualification.setQualificationName("Test_Qualification");
		testEntityManager.persistAndFlush(qualification);

		String PID = "1231312423";
		Person client = new Person();
		client.setPID(PID);
		client.setFirstName("First_Test1");
		client.setLastName("Last_Test1");
		client.setDateOfBirth(localdate);
		testEntityManager.persistAndFlush(client);


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

		CarBrand carBrand2 = new CarBrand();
		carBrand2.setBrandName("Test_Brand2");
		testEntityManager.persistAndFlush(carBrand2);

		CarModel carModel2 = new CarModel();
		carModel2.setCarModel("Test_Model2");
		carModel2.setCarBrand(carBrand);
		carModel2.setYear(2019);
		testEntityManager.persistAndFlush(carModel2);

		Car car2 = new Car();
		car2.setLicensePlate("ABC123");
		car2.setOwner(client);
		car2.setModel(carModel2);
		testEntityManager.persistAndFlush(car2);

		CarService carService = new CarService();
//		carService.setServiceID(1000L);
		carService.setGarage(garage);
		carService.setEmployee(employee);
		carService.setClient(client);
		carService.setCar(car);
		carService.setQualification(qualification);
		carService.setDateOfService(new Date());
		carService.setPrice(123);
		testEntityManager.persistAndFlush(carService);

		CarService carService2 = new CarService();
//		carService2.setServiceID(1000L);
		carService2.setGarage(garage);
		carService2.setEmployee(employee);
		carService2.setClient(client);
		carService2.setCar(car2);
		carService2.setQualification(qualification);
		carService2.setDateOfService(new Date());
		carService2.setPrice(123);
		testEntityManager.persistAndFlush(carService2);

		assertThat(carServiceRepository.findAllCarYears().size()).isEqualTo(2);
	}

	@Test
	void findAllQualifications() {
		LocalDate localdate = LocalDate.parse("1990-01-01");
		Person employee = new Person();
		employee.setPID("1234567");
		employee.setFirstName("First_Test1");
		employee.setLastName("Last_Test1");
		employee.setDateOfBirth(localdate);
		testEntityManager.persistAndFlush(employee);

		Garage garage = new Garage();
		garage.setUIC("654312897");
		garage.setName("Test_Garage");
		garage.setAddress("Test_address");
		testEntityManager.persistAndFlush(garage);

		Qualification qualification = new Qualification();
		qualification.setQualificationName("Test_Qualification");
		testEntityManager.persistAndFlush(qualification);

		Qualification qualification2 = new Qualification();
		qualification2.setQualificationName("Test_Qualification2");
		testEntityManager.persistAndFlush(qualification2);

		String PID = "1231312423";
		Person client = new Person();
		client.setPID(PID);
		client.setFirstName("First_Test1");
		client.setLastName("Last_Test1");
		client.setDateOfBirth(localdate);
		testEntityManager.persistAndFlush(client);


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

		CarService carService = new CarService();
//		carService.setServiceID(1000L);
		carService.setGarage(garage);
		carService.setEmployee(employee);
		carService.setClient(client);
		carService.setCar(car);
		carService.setQualification(qualification);
		carService.setDateOfService(new Date());
		carService.setPrice(123);
		testEntityManager.persistAndFlush(carService);

		CarService carService2 = new CarService();
//		carService.setServiceID(1000L);
		carService2.setGarage(garage);
		carService2.setEmployee(employee);
		carService2.setClient(client);
		carService2.setCar(car);
		carService2.setQualification(qualification2);
		carService2.setDateOfService(new Date());
		carService2.setPrice(123);
		testEntityManager.persistAndFlush(carService2);

		assertThat(carServiceRepository.findAllQualifications().size()).isEqualTo(2);
	}

	@Test
	void countAllByCar_Model_CarBrand_BrandName() {
		LocalDate localdate = LocalDate.parse("1990-01-01");
		Person employee = new Person();
		employee.setPID("1234567");
		employee.setFirstName("First_Test1");
		employee.setLastName("Last_Test1");
		employee.setDateOfBirth(localdate);
		testEntityManager.persistAndFlush(employee);

		Garage garage = new Garage();
		garage.setUIC("654312897");
		garage.setName("Test_Garage");
		garage.setAddress("Test_address");
		testEntityManager.persistAndFlush(garage);

		Qualification qualification = new Qualification();
		qualification.setQualificationName("Test_Qualification");
		testEntityManager.persistAndFlush(qualification);

		String PID = "1231312423";
		Person client = new Person();
		client.setPID(PID);
		client.setFirstName("First_Test1");
		client.setLastName("Last_Test1");
		client.setDateOfBirth(localdate);
		testEntityManager.persistAndFlush(client);

		String brandName = "Test_Brand";
		CarBrand carBrand = new CarBrand();
		carBrand.setBrandName(brandName);
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


		CarModel carModel2 = new CarModel();
		carModel2.setCarModel("Test_Model2");
		carModel2.setCarBrand(carBrand);
		carModel2.setYear(2020);
		testEntityManager.persistAndFlush(carModel2);

		Car car2 = new Car();
		car2.setLicensePlate("ABC123");
		car2.setOwner(client);
		car2.setModel(carModel2);
		testEntityManager.persistAndFlush(car2);

		CarService carService = new CarService();
//		carService.setServiceID(1000L);
		carService.setGarage(garage);
		carService.setEmployee(employee);
		carService.setClient(client);
		carService.setCar(car);
		carService.setQualification(qualification);
		carService.setDateOfService(new Date());
		carService.setPrice(123);
		testEntityManager.persistAndFlush(carService);

		CarService carService2 = new CarService();
//		carService2.setServiceID(1000L);
		carService2.setGarage(garage);
		carService2.setEmployee(employee);
		carService2.setClient(client);
		carService2.setCar(car2);
		carService2.setQualification(qualification);
		carService2.setDateOfService(new Date());
		carService2.setPrice(123);
		testEntityManager.persistAndFlush(carService2);

		assertThat(carServiceRepository.countAllByCar_Model_CarBrand_BrandName(brandName)).isEqualTo(2);
	}

	@Test
	void countAllByWrongCar_Model_CarBrand_BrandName() {
		LocalDate localdate = LocalDate.parse("1990-01-01");
		Person employee = new Person();
		employee.setPID("1234567");
		employee.setFirstName("First_Test1");
		employee.setLastName("Last_Test1");
		employee.setDateOfBirth(localdate);
		testEntityManager.persistAndFlush(employee);

		Garage garage = new Garage();
		garage.setUIC("654312897");
		garage.setName("Test_Garage");
		garage.setAddress("Test_address");
		testEntityManager.persistAndFlush(garage);

		Qualification qualification = new Qualification();
		qualification.setQualificationName("Test_Qualification");
		testEntityManager.persistAndFlush(qualification);

		String PID = "1231312423";
		Person client = new Person();
		client.setPID(PID);
		client.setFirstName("First_Test1");
		client.setLastName("Last_Test1");
		client.setDateOfBirth(localdate);
		testEntityManager.persistAndFlush(client);

		String brandName = "Test_Brand";
		CarBrand carBrand = new CarBrand();
		carBrand.setBrandName(brandName);
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


		CarService carService = new CarService();
//		carService.setServiceID(1000L);
		carService.setGarage(garage);
		carService.setEmployee(employee);
		carService.setClient(client);
		carService.setCar(car);
		carService.setQualification(qualification);
		carService.setDateOfService(new Date());
		carService.setPrice(123);
		testEntityManager.persistAndFlush(carService);


		assertThat(carServiceRepository.countAllByCar_Model_CarBrand_BrandName("Brand")).isEqualTo(0);
	}

	@Test
	void countAllByCar_Model_Year() {
		LocalDate localdate = LocalDate.parse("1990-01-01");
		Person employee = new Person();
		employee.setPID("1234567");
		employee.setFirstName("First_Test1");
		employee.setLastName("Last_Test1");
		employee.setDateOfBirth(localdate);
		testEntityManager.persistAndFlush(employee);

		Garage garage = new Garage();
		garage.setUIC("654312897");
		garage.setName("Test_Garage");
		garage.setAddress("Test_address");
		testEntityManager.persistAndFlush(garage);

		Qualification qualification = new Qualification();
		qualification.setQualificationName("Test_Qualification");
		testEntityManager.persistAndFlush(qualification);

		String PID = "1231312423";
		Person client = new Person();
		client.setPID(PID);
		client.setFirstName("First_Test1");
		client.setLastName("Last_Test1");
		client.setDateOfBirth(localdate);
		testEntityManager.persistAndFlush(client);

		String brandName = "Test_Brand";
		CarBrand carBrand = new CarBrand();
		carBrand.setBrandName(brandName);
		testEntityManager.persistAndFlush(carBrand);

		Integer carYear = 2020;
		CarModel carModel = new CarModel();
		carModel.setCarModel("Test_Model");
		carModel.setCarBrand(carBrand);
		carModel.setYear(carYear);
		testEntityManager.persistAndFlush(carModel);

		Car car = new Car();
		car.setLicensePlate("123ABC");
		car.setOwner(client);
		car.setModel(carModel);
		testEntityManager.persistAndFlush(car);


		CarModel carModel2 = new CarModel();
		carModel2.setCarModel("Test_Model2");
		carModel2.setCarBrand(carBrand);
		carModel2.setYear(carYear);
		testEntityManager.persistAndFlush(carModel2);

		Car car2 = new Car();
		car2.setLicensePlate("ABC123");
		car2.setOwner(client);
		car2.setModel(carModel2);
		testEntityManager.persistAndFlush(car2);

		CarService carService = new CarService();
//		carService.setServiceID(1000L);
		carService.setGarage(garage);
		carService.setEmployee(employee);
		carService.setClient(client);
		carService.setCar(car);
		carService.setQualification(qualification);
		carService.setDateOfService(new Date());
		carService.setPrice(123);
		testEntityManager.persistAndFlush(carService);

		CarService carService2 = new CarService();
//		carService2.setServiceID(1000L);
		carService2.setGarage(garage);
		carService2.setEmployee(employee);
		carService2.setClient(client);
		carService2.setCar(car2);
		carService2.setQualification(qualification);
		carService2.setDateOfService(new Date());
		carService2.setPrice(123);
		testEntityManager.persistAndFlush(carService2);

		assertThat(carServiceRepository.countAllByCar_Model_Year(carYear)).isEqualTo(2);
	}

	@Test
	void countAllByWrongCar_Model_Year() {
		LocalDate localdate = LocalDate.parse("1990-01-01");
		Person employee = new Person();
		employee.setPID("1234567");
		employee.setFirstName("First_Test1");
		employee.setLastName("Last_Test1");
		employee.setDateOfBirth(localdate);
		testEntityManager.persistAndFlush(employee);

		Garage garage = new Garage();
		garage.setUIC("654312897");
		garage.setName("Test_Garage");
		garage.setAddress("Test_address");
		testEntityManager.persistAndFlush(garage);

		Qualification qualification = new Qualification();
		qualification.setQualificationName("Test_Qualification");
		testEntityManager.persistAndFlush(qualification);

		String PID = "1231312423";
		Person client = new Person();
		client.setPID(PID);
		client.setFirstName("First_Test1");
		client.setLastName("Last_Test1");
		client.setDateOfBirth(localdate);
		testEntityManager.persistAndFlush(client);

		String brandName = "Test_Brand";
		CarBrand carBrand = new CarBrand();
		carBrand.setBrandName(brandName);
		testEntityManager.persistAndFlush(carBrand);

		Integer carYear = 2020;
		CarModel carModel = new CarModel();
		carModel.setCarModel("Test_Model");
		carModel.setCarBrand(carBrand);
		carModel.setYear(carYear);
		testEntityManager.persistAndFlush(carModel);

		Car car = new Car();
		car.setLicensePlate("123ABC");
		car.setOwner(client);
		car.setModel(carModel);
		testEntityManager.persistAndFlush(car);


		CarModel carModel2 = new CarModel();
		carModel2.setCarModel("Test_Model2");
		carModel2.setCarBrand(carBrand);
		carModel2.setYear(carYear);
		testEntityManager.persistAndFlush(carModel2);

		Car car2 = new Car();
		car2.setLicensePlate("ABC123");
		car2.setOwner(client);
		car2.setModel(carModel2);
		testEntityManager.persistAndFlush(car2);

		CarService carService = new CarService();
//		carService.setServiceID(1000L);
		carService.setGarage(garage);
		carService.setEmployee(employee);
		carService.setClient(client);
		carService.setCar(car);
		carService.setQualification(qualification);
		carService.setDateOfService(new Date());
		carService.setPrice(123);
		testEntityManager.persistAndFlush(carService);

		CarService carService2 = new CarService();
//		carService2.setServiceID(1000L);
		carService2.setGarage(garage);
		carService2.setEmployee(employee);
		carService2.setClient(client);
		carService2.setCar(car2);
		carService2.setQualification(qualification);
		carService2.setDateOfService(new Date());
		carService2.setPrice(123);
		testEntityManager.persistAndFlush(carService);

		assertThat(carServiceRepository.countAllByCar_Model_Year(2010)).isEqualTo(0);
	}

	@Test
	void countAllByQualification_QualificationName() {
		LocalDate localdate = LocalDate.parse("1990-01-01");
		Person employee = new Person();
		employee.setPID("1234567");
		employee.setFirstName("First_Test1");
		employee.setLastName("Last_Test1");
		employee.setDateOfBirth(localdate);
		testEntityManager.persistAndFlush(employee);

		Garage garage = new Garage();
		garage.setUIC("654312897");
		garage.setName("Test_Garage");
		garage.setAddress("Test_address");
		testEntityManager.persistAndFlush(garage);

		String qualificationName = "Test_Qualification";
		Qualification qualification = new Qualification();
		qualification.setQualificationName(qualificationName);
		testEntityManager.persistAndFlush(qualification);


		String PID = "1231312423";
		Person client = new Person();
		client.setPID(PID);
		client.setFirstName("First_Test1");
		client.setLastName("Last_Test1");
		client.setDateOfBirth(localdate);
		testEntityManager.persistAndFlush(client);


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

		CarService carService = new CarService();
//		carService.setServiceID(1000L);
		carService.setGarage(garage);
		carService.setEmployee(employee);
		carService.setClient(client);
		carService.setCar(car);
		carService.setQualification(qualification);
		carService.setDateOfService(new Date());
		carService.setPrice(123);
		testEntityManager.persistAndFlush(carService);

		assertThat(carServiceRepository.countAllByQualification_QualificationName(qualificationName)).isEqualTo(1);
	}

	@Test
	void countAllByWrongQualification_QualificationName() {
		LocalDate localdate = LocalDate.parse("1990-01-01");
		Person employee = new Person();
		employee.setPID("1234567");
		employee.setFirstName("First_Test1");
		employee.setLastName("Last_Test1");
		employee.setDateOfBirth(localdate);
		testEntityManager.persistAndFlush(employee);

		Garage garage = new Garage();
		garage.setUIC("654312897");
		garage.setName("Test_Garage");
		garage.setAddress("Test_address");
		testEntityManager.persistAndFlush(garage);

		String qualificationName = "Test_Qualification";
		Qualification qualification = new Qualification();
		qualification.setQualificationName(qualificationName);
		testEntityManager.persistAndFlush(qualification);


		String PID = "1231312423";
		Person client = new Person();
		client.setPID(PID);
		client.setFirstName("First_Test1");
		client.setLastName("Last_Test1");
		client.setDateOfBirth(localdate);
		testEntityManager.persistAndFlush(client);


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

		CarService carService = new CarService();
//		carService.setServiceID(1000L);
		carService.setGarage(garage);
		carService.setEmployee(employee);
		carService.setClient(client);
		carService.setCar(car);
		carService.setQualification(qualification);
		carService.setDateOfService(new Date());
		carService.setPrice(123);
		testEntityManager.persistAndFlush(carService);

		assertThat(carServiceRepository.countAllByQualification_QualificationName("Qualify")).isEqualTo(0);
	}
}