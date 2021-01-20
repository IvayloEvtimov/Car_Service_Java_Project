package com.project.car_service.web.view.model;

import com.project.car_service.data.entity.CarModel;
import com.project.car_service.data.entity.Person;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CarViewModel {
	private String licensePlate;
	private Person owner;
	private CarModel model;
}
