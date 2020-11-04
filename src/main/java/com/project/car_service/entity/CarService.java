package com.project.car_service.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "car_service")
public class CarService {

	@Id
	@Column(name = "service_id")
	private Long serviceID;

	@ManyToOne()
	@JoinColumn(name = "Garage")
	private Garage garage;

	@ManyToOne()
	@JoinColumn(name = "employee")
	private Person employee;

	@ManyToOne()
	@JoinColumn(name = "Client")
	private Person client;

	@ManyToOne()
	@JoinColumn(name = "Car")
	private Car car;

	@ManyToOne()
	@JoinColumn(name = "Car_Part")
	private CarPart carPart;

	@ManyToOne()
	@JoinColumn(name =  "needed_qualification")
	private Qualification neededQualification;

	@Column(name = "date_of_service")
	private Date dateOfService;

}
