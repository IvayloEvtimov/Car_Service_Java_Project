package com.project.car_service.data.repository;

import com.project.car_service.data.entity.Employment;
import com.project.car_service.data.entity.Garage;
import com.project.car_service.data.entity.Person;
import com.project.car_service.data.entity.Qualification;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class EmploymentRepositoryTest {

	@Autowired
	private TestEntityManager testEntityManager;

	@Autowired
	private EmploymentRepository employmentRepository;

	@Test
	void findEmploymentByEmployee_PIDAndGarage_UIC() {
		String PID = "1234567";
		LocalDate localdate = LocalDate.parse("1990-01-01");

		Person employee = new Person();
		employee.setPID(PID);
		employee.setFirstName("First_Test1");
		employee.setLastName("Last_Test1");
		employee.setDateOfBirth(localdate);
		testEntityManager.persistAndFlush(employee);

		String UIC = "654312897";
		Garage garage = new Garage();
		garage.setUIC(UIC);
		garage.setName("Test_Garage");
		garage.setAddress("Test_address");
		testEntityManager.persistAndFlush(garage);

		Qualification qualification = new Qualification();
		qualification.setQualificationName("Test_Qualification");
		testEntityManager.persistAndFlush(qualification);

		LocalDate dateOfHire = LocalDate.parse("2020-01-01");
		Employment employment = new Employment();
		employment.setGarage(garage);
		employment.setEmployee(employee);
		employment.setDateOfHire(dateOfHire);
		employment.setQualification(qualification);
		employment.setSalary(1234);
		testEntityManager.persistAndFlush(employment);

		assertThat(employmentRepository.findEmploymentByEmployee_PIDAndGarage_UIC(PID, UIC).size()).isEqualTo(1);
	}

	@Test
	void findEmploymentByWrongEmployee_PIDAndGarage_UIC() {
		String PID = "1234567";
		LocalDate localdate = LocalDate.parse("1990-01-01");
		Person employee = new Person();
		employee.setPID(PID);
		employee.setFirstName("First_Test1");
		employee.setLastName("Last_Test1");
		employee.setDateOfBirth(localdate);
		testEntityManager.persistAndFlush(employee);

		String UIC = "654312897";
		Garage garage = new Garage();
		garage.setUIC(UIC);
		garage.setName("Test_Garage");
		garage.setAddress("Test_address");
		testEntityManager.persistAndFlush(garage);

		Qualification qualification = new Qualification();
		qualification.setQualificationName("Test_Qualification");
		testEntityManager.persistAndFlush(qualification);

		LocalDate dateOfHire = LocalDate.parse("2020-01-01");
		Employment employment = new Employment();
		employment.setGarage(garage);
		employment.setEmployee(employee);
		employment.setDateOfHire(dateOfHire);
		employment.setQualification(qualification);
		employment.setSalary(1234);
		testEntityManager.persistAndFlush(employment);

		PID = "123";
		assertThat(employmentRepository.findEmploymentByEmployee_PIDAndGarage_UIC(PID,UIC).size()).isEqualTo(0);
	}

	@Test
	void findEmploymentByEmployee_PIDAndWrongGarage_UIC(){
		String PID = "1234567";
		LocalDate localdate = LocalDate.parse("1990-01-01");
		Person employee = new Person();
		employee.setPID(PID);
		employee.setFirstName("First_Test1");
		employee.setLastName("Last_Test1");
		employee.setDateOfBirth(localdate);
		testEntityManager.persistAndFlush(employee);

		String UIC = "654312897";
		Garage garage = new Garage();
		garage.setUIC(UIC);
		garage.setName("Test_Garage");
		garage.setAddress("Test_address");
		testEntityManager.persistAndFlush(garage);

		Qualification qualification = new Qualification();
		qualification.setQualificationName("Test_Qualification");
		testEntityManager.persistAndFlush(qualification);

		LocalDate dateOfHire = LocalDate.parse("2020-01-01");
		Employment employment = new Employment();
		employment.setGarage(garage);
		employment.setEmployee(employee);
		employment.setDateOfHire(dateOfHire);
		employment.setQualification(qualification);
		employment.setSalary(1234);
		testEntityManager.persistAndFlush(employment);

		UIC = "654";
		assertThat(employmentRepository.findEmploymentByEmployee_PIDAndGarage_UIC(PID,UIC).size()).isEqualTo(0);
	}

	@Test
	void findEmploymentByWrongEmployee_PIDAndWrongGarage_UIC(){
		String PID = "1234567";
		LocalDate localdate = LocalDate.parse("1990-01-01");
		Person employee = new Person();
		employee.setPID(PID);
		employee.setFirstName("First_Test1");
		employee.setLastName("Last_Test1");
		employee.setDateOfBirth(localdate);
		testEntityManager.persistAndFlush(employee);

		String UIC = "654312897";
		Garage garage = new Garage();
		garage.setUIC(UIC);
		garage.setName("Test_Garage");
		garage.setAddress("Test_address");
		testEntityManager.persistAndFlush(garage);

		Qualification qualification = new Qualification();
		qualification.setQualificationName("Test_Qualification");
		testEntityManager.persistAndFlush(qualification);

		LocalDate dateOfHire = LocalDate.parse("2020-01-01");
		Employment employment = new Employment();
		employment.setGarage(garage);
		employment.setEmployee(employee);
		employment.setDateOfHire(dateOfHire);
		employment.setQualification(qualification);
		employment.setSalary(1234);
		testEntityManager.persistAndFlush(employment);

		PID = "1234";
		UIC = "654";
		assertThat(employmentRepository.findEmploymentByEmployee_PIDAndGarage_UIC(PID,UIC).size()).isEqualTo(0);
	}

	@Test
	void getEmploymentByEmployee_PIDAndQualification() {
		String PID = "1234567";
		LocalDate localdate = LocalDate.parse("1990-01-01");
		Person employee = new Person();
		employee.setPID(PID);
		employee.setFirstName("First_Test1");
		employee.setLastName("Last_Test1");
		employee.setDateOfBirth(localdate);
		testEntityManager.persistAndFlush(employee);

		Qualification qualification = new Qualification();
		qualification.setQualificationName("Test_Qualification");
		testEntityManager.persistAndFlush(qualification);

		String UIC = "654312897";
		Garage garage = new Garage();
		garage.setUIC(UIC);
		garage.setName("Test_Garage");
		garage.setAddress("Test_address");
		testEntityManager.persistAndFlush(garage);

		LocalDate dateOfHire = LocalDate.parse("2020-01-01");
		Employment employment = new Employment();
		employment.setGarage(garage);
		employment.setEmployee(employee);
		employment.setDateOfHire(dateOfHire);
		employment.setQualification(qualification);
		employment.setSalary(1234);
		testEntityManager.persistAndFlush(employment);

		assertThat(employmentRepository.getEmploymentByEmployee_PIDAndQualification(PID, qualification)).isNotEqualTo(null);
	}
}
