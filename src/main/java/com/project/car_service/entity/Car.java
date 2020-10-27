package com.project.car_service.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "car")
public class Car {
	@Id
	@Column(name = "license_plate")
	private String licensePlate;

	@ManyToOne()
	private CarModel model;

	@ManyToOne()
	private Client owner;

	@OneToMany(mappedBy = "car")
	private Set<CarWork> carWorks;

}
