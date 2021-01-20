package com.project.car_service.web.view.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class CreatePersonViewModel {
	@NotNull
	private String PID;

	@NotNull
	private String firstName;

	@NotNull
	private String lastName;

	@NotNull
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Future(message = "Date must be in the future")
	private LocalDate dateOfBirth;
}