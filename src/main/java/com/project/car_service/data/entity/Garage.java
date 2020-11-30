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
@Table(name = "garage")
public class Garage {
	@Id
	@Column(name = "UIC", nullable = false, updatable = false)
	private String UIC;

	@Column(name = "Name")
	private String name;

	@Column(name = "Address")
	private String address;

	@OneToMany(mappedBy = "garage")
	private Set<Employment> employmentSet;

	@OneToMany(mappedBy = "garage")
	private Set<WorkBrand> workBrands;

	@OneToMany(mappedBy = "garage")
	private Set<CarService> carServices;
}
