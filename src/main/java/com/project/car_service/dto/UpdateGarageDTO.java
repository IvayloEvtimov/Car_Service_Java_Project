package com.project.car_service.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class UpdateGarageDTO {
	private String UIC;
	private String name;
	private String address;
}
