package com.project.car_service.dto;

import com.project.car_service.data.entity.Garage;
import com.project.car_service.data.entity.Person;
import com.project.car_service.data.entity.Qualification;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class EmploymentDTO {
	public Garage garage;
	public Person employee;
	public LocalDate dateOfHire;
	public Qualification qualification;
	private Integer salary;
}
