package com.project.car_service.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "person")
public class Person {

	@Id
	@Column(name = "PID", nullable = false, updatable = false)
	private String PID;

	@Column(name = "First_Name", nullable = false)
	private String First_Name;

	@Column(name = "Last_Name", nullable = false)
	private String Last_Name;

	@Column(name = "Date_of_Birth", nullable = false)
	private LocalDate dateOfBirth;

	@OneToOne(mappedBy = "employee")
	private Employee employee;

	@OneToOne(mappedBy = "client")
	private Client client;
}
