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
@Table(name = "client")
public class Client {
	@Id
	@OneToOne()
	@JoinColumn(name = "PID")
	@MapsId
	private Person client;


	@OneToMany(mappedBy = "owner")
	private Set<Car> carSet;

	@OneToMany(mappedBy = "client")
	private Set<Service> services;

}
