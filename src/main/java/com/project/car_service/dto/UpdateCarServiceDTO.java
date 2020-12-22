package com.project.car_service.dto;

import com.project.car_service.data.entity.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class UpdateCarServiceDTO {
	private Garage garage;
	private Person employee;
	private Person client;
	private Car car;
	private CarPart carPart;
	private Qualification qualification;
	private Date date;
}
