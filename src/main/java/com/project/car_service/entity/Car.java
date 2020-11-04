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
	@Column(name = "License_Plate")
	private String licensePlate;

	@ManyToOne()
	@JoinColumn(name = "Owner")
	private Person owner;

	@ManyToOne
	@JoinColumn(name = "Model")
	private CarModel carModel;

	public CarModel getCarModel() {
		return carModel;
	}

	public void setCarModel(CarModel carModel) {
		this.carModel = carModel;
	}

	@OneToMany(mappedBy = "car")
	private Set<CarService> carServiceSet;

}
