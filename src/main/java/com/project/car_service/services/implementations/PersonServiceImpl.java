package com.project.car_service.services.implementations;

import com.project.car_service.data.entity.Person;
import com.project.car_service.data.repository.PersonRepository;
import com.project.car_service.dto.PersonDTO;
import com.project.car_service.services.PersonService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Validated
public class PersonServiceImpl implements PersonService {
	private final PersonRepository personRepository;

	private final ModelMapper modelMapper;

	@Override
	public List<PersonDTO> getPersons() {
		return personRepository.findAll().stream()
				.map(this::convertToDTO)
				.collect(Collectors.toList());
	}

	private PersonDTO convertToDTO( Person person ) {
		return modelMapper.map(person, PersonDTO.class);
	}

}
