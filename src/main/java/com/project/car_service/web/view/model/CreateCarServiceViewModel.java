package com.project.car_service.web.view.model;

import com.project.car_service.data.entity.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
public class CreateCarServiceViewModel {
	@NotBlank
	private Garage garage;

	@NotBlank
	private Person employee;

	@NotBlank
	private Person client;

	@NotBlank
	private Car car;

	@NotBlank
	private CarPart carPart;

	@NotBlank
	private Qualification qualification;

	@NotNull
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Future(message = "Date must be in the future")
	private Date dateOfService;
}
