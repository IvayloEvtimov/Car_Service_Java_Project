package com.project.car_service.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "car_model")
public class CarModel implements Serializable {
	@Id
	@Column(name = "Car_Model")
	private String carModel;

	@Id
	@ManyToOne(optional = false)
	@MapsId
	private CarBrand carBrand;

	@OneToMany(mappedBy = "carModel")
	private Set<Car> cars;
}
