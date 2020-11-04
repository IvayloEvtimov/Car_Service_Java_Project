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
@Table(name = "car_part")
public class CarPart {
	@Id
	@Column(name = "Part_Name")
	private String partName;

	@OneToMany(mappedBy = "carPart")
	private Set<CarService> carServices;

}
