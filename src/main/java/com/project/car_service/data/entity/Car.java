package com.project.car_service.data.entity;

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
	@Column(name = "License_Plate")
	private String licensePlate;

	@ManyToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name = "Owner")
	private Person owner;

	@ManyToOne
	@JoinColumn(name = "Model")
	private CarModel Model;

	@OneToMany(mappedBy = "car")
	private Set<CarService> carServiceSet;

}
