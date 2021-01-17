package com.project.car_service.services;

import com.project.car_service.data.entity.Employment;
import com.project.car_service.data.entity.Garage;
import com.project.car_service.data.entity.Person;
import com.project.car_service.data.entity.Qualification;
import com.project.car_service.data.repository.EmploymentRepository;
import com.project.car_service.dto.EmploymentDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class EmploymentServiceTest {
	@MockBean
	private EmploymentRepository employmentRepository;

	@Autowired
	private EmploymentService service;


	@Test
	void findEmploymentByEmployee_PIDAndGarage_UIC() {
		String PID = "1234567";
		LocalDate localdate = LocalDate.parse("1900-01-01");
		Person employee = new Person();
		employee.setPID(PID);
		employee.setFirstName("First_Test1");
		employee.setLastName("Last_Test1");
		employee.setDateOfBirth(localdate);

		String UIC = "654312897";
		Garage garage = new Garage();
		garage.setUIC(UIC);
		garage.setName("Test_Garage");
		garage.setAddress("Test_address");

		Qualification qualification = new Qualification();
		qualification.setQualificationName("Test_Qualification");

		LocalDate dateOfHire = LocalDate.parse("2020-01-01");
		Employment employment = new Employment();
		employment.setGarage(garage);
		employment.setEmployee(employee);
		employment.setDateOfHire(dateOfHire);
		employment.setQualification(qualification);
		employment.setSalary(1234);

		List<Employment> employmentList = new ArrayList<>();
		employmentList.add(employment);

		Mockito.when(employmentRepository.findEmploymentByEmployee_PIDAndGarage_UIC(PID,UIC)).thenReturn(employmentList);

		List<EmploymentDTO> result = service.findEmploymentByEmployee_PIDAndGarage_UIC(PID,UIC);
		assertThat(result.size()).isEqualTo(employmentList.size());
	}
}