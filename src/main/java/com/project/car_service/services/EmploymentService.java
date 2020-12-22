package com.project.car_service.services;


import com.project.car_service.dto.EmploymentDTO;
import com.project.car_service.dto.PersonDTO;

import java.util.List;

public interface EmploymentService {
	List<EmploymentDTO> getEmployees();
}
