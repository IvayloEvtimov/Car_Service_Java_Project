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
@Table(name = "service")
public class Service {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "service_id", nullable = false, updatable = false)
	private Long serviceId;

	@Column(name = "service_date")
	private LocalDate serviceDate;

	@ManyToOne()
	private Client client;

	@ManyToOne()
	private CarPart carPart;

	@ManyToOne()
	private Garage garage;

	@ManyToOne()
	private Employee employee;

	@ManyToOne()
	private Car car;


}
