package com.project.car_service.web.view.model;

import com.project.car_service.data.entity.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class CarServiceViewModel {
	private Long serviceId;
	private Garage garage;
	private Person employee;
	private Person client;
	private Car car;
	private Qualification qualification;
	private Date dateOfService;
	private Integer price;
}
