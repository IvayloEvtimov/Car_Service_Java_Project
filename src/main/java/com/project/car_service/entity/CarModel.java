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
@Table(name = "car_model")
public class CarModel {

	@Id
	@ManyToOne()
	@JoinColumn(name = "Brand_Name")
	@MapsId
	private CarBrand carBrand;

	@Id
	@Column(name = "Car_Model")
	private String carModelName;

	@Column(name = "Year_of_Manufacture")
	private Integer year;

	@OneToMany(mappedBy = "model")
	private Set<Car> cars;

	@ManyToMany(mappedBy = "workModels")
	private Set<Garage> garageSet;

}
