package com.project.car_service.web.view.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class UpdateGarageViewModel {
	private String UIC;
	private String name;
	private String address;
}
