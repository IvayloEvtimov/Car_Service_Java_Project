package com.project.car_service.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "work_brand")
public class WorkBrand implements Serializable {
	@Id
	@ManyToOne()
	@JoinColumn(name = "Garage")
	@MapsId
	private Garage garage;

	@Id
	@ManyToOne()
	@JoinColumn(name = "Brand")
	@MapsId
	private CarBrand carBrand;

}