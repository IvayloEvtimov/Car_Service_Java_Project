package com.project.car_service.services;


import com.project.car_service.data.entity.Employment;
import com.project.car_service.data.entity.Garage;
import com.project.car_service.data.entity.Person;
import com.project.car_service.data.entity.Qualification;
import com.project.car_service.dto.EmploymentDTO;
import com.project.car_service.dto.PersonDTO;

import java.util.List;

public interface EmploymentService {
	List<EmploymentDTO> getEmployees();

	List<EmploymentDTO> findEmploymentByEmployeeAndGarage( Person employee, Garage garage );

	Employment getEmploymentByEmployee_PIDAndQualification( String PID, Qualification qualification );
}
