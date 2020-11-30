package com.project.car_service.data.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "employment")
public class Employment implements Serializable {
	@Id
	@ManyToOne()
	@JoinColumn(name = "Garage")
	@MapsId
	private Garage garage;

	@Id
	@ManyToOne()
	@JoinColumn(name = "Employee")
	@MapsId
	private Person employee;

	@Column(name = "Date_Of_Hire")
	private LocalDate dateOfHire;

	@ManyToOne()
	@JoinColumn(name = "Qualification")
	private Qualification qualification;

	@Column(name = "Salary")
	private Integer salary;


}
