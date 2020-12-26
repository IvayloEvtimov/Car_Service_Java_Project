package com.project.car_service.data.repository;

import com.project.car_service.data.entity.Employment;
import com.project.car_service.data.entity.Garage;
import com.project.car_service.data.entity.Person;
import com.project.car_service.data.entity.Qualification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmploymentRepository extends JpaRepository<Employment, String> {
	List<Employment> findEmploymentByEmployeeAndGarage( Person employee, Garage garage );

	Employment getEmploymentByEmployee_PIDAndQualification( String PID, Qualification qualification );
}
