package com.project.car_service.dto;

import com.project.car_service.data.entity.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class CreateCarServiceDTO {
	@NotNull
	private Garage garage;

	@NotNull
	private Person employee;

	@NotNull
	private Person client;

	@NotNull
	private Car car;


	@NotNull
	private Qualification qualification;

	@NotNull
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Future(message = "Date has to be in the future")
	private Date dateOfService;

	private Integer price;
}
