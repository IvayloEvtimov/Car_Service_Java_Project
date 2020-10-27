package com.project.car_service.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "employee")
public class Employee {

	@Id
	@OneToOne()
	@JoinColumn(name = "PID")
	@MapsId
	private Person employee;

	@Column(name = "Date_of_Hire", nullable = false)
	private LocalDate dateOfHire;

	@ManyToOne()
	private Qualification qualification;

	@ManyToMany(mappedBy = "employeeSet")
	private Set<Garage> garageSet;

	@OneToMany(mappedBy = "employee")
	private Set<CarWork> carWorks;

}
