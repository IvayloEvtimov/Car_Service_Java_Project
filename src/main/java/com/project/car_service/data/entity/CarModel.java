package com.project.car_service.data.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
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

//	@Id
	@ManyToOne()
	@JoinColumn(name = "Car_Brand")
//	@MapsId
	private CarBrand carBrand;

	@OneToMany(mappedBy = "model")
	private Set<Car> cars;
}
