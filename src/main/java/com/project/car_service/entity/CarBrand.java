package com.project.car_service.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "car_brand")
public class CarBrand {

	@Id
	@Column(name = "Brand_Name")
	private String brandName;


	@OneToMany(mappedBy = "carBrand")
	private Set<CarModel> carModelSet;
}
