package com.project.car_service.services.implementations;

import com.project.car_service.data.entity.Employment;
import com.project.car_service.data.entity.Garage;
import com.project.car_service.data.entity.Person;
import com.project.car_service.data.entity.Qualification;
import com.project.car_service.data.repository.EmploymentRepository;
import com.project.car_service.dto.EmploymentDTO;
import com.project.car_service.services.EmploymentService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Validated
public class EmploymentServiceImpl implements EmploymentService {
	public final EmploymentRepository employmentRepository;

	public final ModelMapper modelMapper;

	@Override
	public List<EmploymentDTO> getEmployees() {
		return employmentRepository.findAll().stream()
				.map(this::convertToEmploymentDTO)
				.collect(Collectors.toList());
	}

	@Override
	public List<EmploymentDTO> findEmploymentByEmployee_PIDAndGarage_UIC( String PID, String UIC ) {
		return employmentRepository.findEmploymentByEmployee_PIDAndGarage_UIC(PID, UIC).stream().map(this::convertToEmploymentDTO).collect(Collectors.toList());
	}

	@Override
	public List<EmploymentDTO> findEmploymentByGarageUIC(String UIC) {
		return employmentRepository.findAllByGarage_UIC(UIC).stream().map(this::convertToEmploymentDTO).collect(Collectors.toList());
	}

	@Override
	public Employment getEmploymentByEmployee_PIDAndQualification( String PID, Qualification qualification ) {
		return employmentRepository.getEmploymentByEmployee_PIDAndQualification(PID, qualification);
	}

	private EmploymentDTO convertToEmploymentDTO( Employment employment ) {
		return modelMapper.map(employment, EmploymentDTO.class);
	}
}
