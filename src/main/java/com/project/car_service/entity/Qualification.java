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
@Table(name = "qualification")
public class Qualification {
	@Id
	@Column(name = "Qualification_Name", nullable = false, updatable = false)
	private String qualificationName;

	@OneToMany(mappedBy = "qualification")
	private Set<Employment> employmentSet;

	@OneToMany(mappedBy = "neededQualification")
	private Set<CarService> carServices;
}
