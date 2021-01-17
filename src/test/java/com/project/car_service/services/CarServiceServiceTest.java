package com.project.car_service.services;

import com.project.car_service.data.entity.*;
import com.project.car_service.data.entity.CarService;
import com.project.car_service.data.repository.CarServiceRepository;
import com.project.car_service.dto.CarServiceDTO;
import com.project.car_service.dto.PersonDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
@ExtendWith(MockitoExtension.class)
class CarServiceServiceTest {

	@MockBean
	private CarServiceRepository carServiceRepository;

	@Autowired
	private CarServiceService service;

	@Test
	void getService() {
		long serviceId = 1;

		CarService carService = new CarService();
		carService.setServiceID(serviceId);

		Mockito.when(carServiceRepository.findById(serviceId)).thenReturn(Optional.of(carService));

		CarServiceDTO carServiceDTO = service.getService(serviceId);

		assertThat(carServiceDTO.getServiceID()).isEqualTo(carService.getServiceID());
	}


	@Test
	void findCarServicesByCar_LicensePlate() {

		CarBrand carBrand = new CarBrand();
		carBrand.setBrandName("Test_Brand");

		CarModel carModel = new CarModel();
		carModel.setCarModel("Test_Model");
		carModel.setCarBrand(carBrand);
		carModel.setYear(2020);

		String licensePlate = "123ABC";
		Car car = new Car();
		car.setLicensePlate(licensePlate);
		car.setModel(carModel);

		CarService carService = new CarService();
		carService.setServiceID(Long.valueOf(1000));
		carService.setCar(car);

		List<CarService> carServiceList = new ArrayList<>();
		carServiceList.add(carService);

		Mockito.when(carServiceRepository.findCarServicesByCar_LicensePlate(licensePlate)).thenReturn(carServiceList);

		List<CarServiceDTO> result = service.findCarServicesByCar_LicensePlate(licensePlate);
		assertThat(result.size()).isEqualTo(carServiceList.size());

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

		CarService carService = new CarService();
		carService.setEmployee(employee);

		List<CarService> carServiceList = new ArrayList<>();
		carServiceList.add(carService);

		Mockito.when(carServiceRepository.findCarServicesByEmployee_PID(PID)).thenReturn(carServiceList);

		List<CarServiceDTO> result = service.findCarServicesByEmployee_PID(PID);
		assertThat(result.size()).isEqualTo(carServiceList.size());
	}

	@Test
	void findCarServicesByClient_PID() {
		String PID = "1231312423";
		LocalDate localdate = LocalDate.parse("1990-01-01");
		Person client = new Person();
		client.setPID(PID);
		client.setFirstName("First_Test1");
		client.setLastName("Last_Test1");
		client.setDateOfBirth(localdate);

		CarService carService = new CarService();
		carService.setClient(client);

		List<CarService> carServiceList = new ArrayList<>();
		carServiceList.add(carService);

		Mockito.when(carServiceRepository.findCarServicesByClient_PID(PID)).thenReturn(carServiceList);

		List<CarServiceDTO> result = service.findCarServicesByClient_PID(PID);
		assertThat(result.size()).isEqualTo(carServiceList.size());
	}

	@Test
	void findAllClients() {
		String PID = "1231312423";
		LocalDate localdate = LocalDate.parse("1990-01-01");
		Person client = new Person();
		client.setPID(PID);
		client.setFirstName("First_Test1");
		client.setLastName("Last_Test1");
		client.setDateOfBirth(localdate);

		List<Person> personList = new ArrayList<>();
		personList.add(client);

		Mockito.when(carServiceRepository.findAllClients()).thenReturn(personList);

		List<PersonDTO> result = service.findAllClients();
		assertThat(result.size()).isEqualTo(personList.size());
	}

	@Test
	void findAllBrands() {

		CarBrand carBrand = new CarBrand();
		carBrand.setBrandName("Test_Brand");

		CarBrand carBrand2 = new CarBrand();
		carBrand.setBrandName("Test_Brand2");

		List<String> carBrandList = new ArrayList<>();
		carBrandList.add(carBrand.getBrandName());
		carBrandList.add(carBrand2.getBrandName());

		Mockito.when(carServiceRepository.findAllBrands()).thenReturn(carBrandList);

		List<String> result = service.findAllBrands();
		assertThat(result).isEqualTo(carBrandList);
	}

	@Test
	void findAllCarYears() {
		CarBrand carBrand = new CarBrand();
		carBrand.setBrandName("Test_Brand");

		CarModel carModel = new CarModel();
		carModel.setCarModel("Test_Model");
		carModel.setCarBrand(carBrand);
		carModel.setYear(2020);

		CarBrand carBrand2 = new CarBrand();
		carBrand.setBrandName("Test_Brand2");

		CarModel carModel2 = new CarModel();
		carModel.setCarModel("Test_Model2");
		carModel.setCarBrand(carBrand);
		carModel.setYear(2019);

		List<Integer> yearList = new ArrayList<>();
		yearList.add(carModel.getYear());
		yearList.add(carModel2.getYear());

		Mockito.when(carServiceRepository.findAllCarYears()).thenReturn(yearList);

		List<Integer> result = service.findAllCarYears();
		assertThat(result).isEqualTo(yearList);
	}

	@Test
	void findAllQualifications() {
		Qualification qualification = new Qualification();
		qualification.setQualificationName("Test_Qualification");

		Qualification qualification2 = new Qualification();
		qualification.setQualificationName("Test_Qualification2");

		List<String> qualificationList = new ArrayList<>();
		qualificationList.add(qualification.getQualificationName());
		qualificationList.add(qualification2.getQualificationName());

		Mockito.when(carServiceRepository.findAllQualifications()).thenReturn(qualificationList);

		List<String> result = service.findAllQualifications();
		assertThat(result).isEqualTo(qualificationList);
	}
}