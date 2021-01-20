package com.project.car_service.web.view.model;

import com.project.car_service.data.entity.*;
import com.project.car_service.services.EmploymentService;
import com.project.car_service.services.WorkBrandService;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class UpdateCarServiceViewModel {
//	@NotBlank
	private Long serviceID;

//	@NotBlank
	private Garage garage;

//	@NotBlank
	private Person employee;

//	@NotBlank
	private Person client;

//	@NotBlank
	private Car car;

//	@NotBlank
	private Qualification qualification;

	@NotNull
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'hh:mm")
	@Future(message = "Date must be in the future")
	private Date dateOfService;

	private Integer price;


	public boolean check( EmploymentService employmentService, WorkBrandService workBrandService ) {
		if (car.getOwner() != client)
			return false;

		if (employmentService.findEmploymentByEmployee_PIDAndGarage_UIC(employee.getPID(), garage.getUIC()).isEmpty())
			return false;

		if (employmentService.getEmploymentByEmployee_PIDAndQualification(employee.getPID(), qualification) == null)
			return false;

		if (workBrandService.getWorkBrandByCarBrand_BrandNameAndGarage_UIC(car.getModel().getCarBrand().getBrandName(), garage.getUIC()) == null)
			return false;


		return true;
	}
}
