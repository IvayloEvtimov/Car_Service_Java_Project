package com.project.car_service.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "employment")
public class Employment {
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
	private Date dateOfHire;

	@ManyToOne()
	private Qualification qualification;

	@Column(name = "Salary")
	private Integer salary;

	@OneToMany(mappedBy = "employee")
	private Set<CarService> carServiceSet;
}
