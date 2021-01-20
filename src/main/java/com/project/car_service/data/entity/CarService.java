package com.project.car_service.data.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Future;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "car_service")
public class CarService {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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
	@JoinColumn(name =  "qualification")
	private Qualification qualification;

	@Column(name = "date_of_service")
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'hh:mm")
	@Future(message = "Date must be in the future")
	private Date dateOfService;

	@Column(name = "price")
	private Integer price;

}
