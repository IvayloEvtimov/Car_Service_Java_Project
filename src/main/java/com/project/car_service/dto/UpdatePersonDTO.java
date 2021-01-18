package com.project.car_service.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class UpdatePersonDTO {
	@NotNull
	public String PID;

	@NotNull
	public String firstName;

	@NotNull
	public String lastName;

	@NotNull
	public LocalDate dateOfBirth;
}
