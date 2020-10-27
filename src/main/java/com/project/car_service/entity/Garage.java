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
@Table(name = "garage")
public class Garage {

	@Id
	@Column(name = "Address", nullable = false)
	private String address;

	@ManyToMany()
	@JoinTable(
			name = "workingModels",
			joinColumns = @JoinColumn(name = "address"),
			inverseJoinColumns = @JoinColumn(name = "carBrand")
	)
	private Set<CarModel> workModels;

	@ManyToMany()
	@JoinTable(
			name = "employment",
			joinColumns = @JoinColumn(name = "address"),
			inverseJoinColumns = @JoinColumn(name = "PID")
	)
	private Set<Employee> employeeSet;

	@OneToMany(mappedBy = "garage")
	private Set<CarWork> carWorks;
}
