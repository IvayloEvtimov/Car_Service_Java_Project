package com.project.car_service.data.repository;

import com.project.car_service.data.entity.Employment;
import com.project.car_service.data.entity.Qualification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmploymentRepository extends JpaRepository<Employment, String> {
	List<Employment> findEmploymentByEmployee_PIDAndGarage_UIC(String PID, String UIC);

	Employment getEmploymentByEmployee_PIDAndQualification(String PID, Qualification qualification);

	List<Employment> findAllByGarage_UIC(String UIC);
}
