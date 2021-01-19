package com.project.car_service.services;


import com.project.car_service.data.entity.Employment;
import com.project.car_service.data.entity.Qualification;
import com.project.car_service.dto.EmploymentDTO;

import java.util.List;

public interface EmploymentService {
	List<EmploymentDTO> getEmployees();

	List<EmploymentDTO> findEmploymentByEmployee_PIDAndGarage_UIC( String PID, String UIC );

	List<EmploymentDTO> findEmploymentByGarageUIC(String UIC);

	Employment getEmploymentByEmployee_PIDAndQualification( String PID, Qualification qualification );

}
