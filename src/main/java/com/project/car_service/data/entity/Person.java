package com.project.car_service.data.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "person")
public class Person {

	@Id
	@Column(name = "PID", nullable = false)
	private String PID;

	@Column(name = "First_Name", nullable = false)
	private String firstName;

	@Column(name = "Last_Name", nullable = false)
	private String lastName;

	@Column(name = "Date_of_Birth", nullable = false)
	private LocalDate dateOfBirth;

	@OneToMany(mappedBy = "owner")
	private Set<Car> cars;

	@OneToMany(mappedBy = "employee")
	private Set<Employment> employmentSet;

	@OneToMany(mappedBy = "client")
	private Set<CarService> carServicesClient;

	@OneToMany(mappedBy = "employee")
	private Set<CarService> carServicesEmployee;

}
