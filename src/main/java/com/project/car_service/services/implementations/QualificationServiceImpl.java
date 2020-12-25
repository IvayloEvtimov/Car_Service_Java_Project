package com.project.car_service.services.implementations;

import com.project.car_service.data.entity.Qualification;
import com.project.car_service.data.repository.QualificationRepository;
import com.project.car_service.dto.QualificationDTO;
import com.project.car_service.services.QualificationService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Validated
public class QualificationServiceImpl implements QualificationService {
	private final QualificationRepository qualificationRepository;

	private final ModelMapper modelMapper;

	@Override
	public List<QualificationDTO> getQualifications() {
		return qualificationRepository.findAll().stream()
				.map(this::convertToQualificationDTO)
				.collect(Collectors.toList());
	}

	private QualificationDTO convertToQualificationDTO( Qualification qualification ){
		return modelMapper.map(qualification, QualificationDTO.class);
	}
}
