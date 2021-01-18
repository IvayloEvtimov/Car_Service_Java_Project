package com.project.car_service.services.implementations;

import com.project.car_service.data.entity.Person;
import com.project.car_service.data.repository.PersonRepository;
import com.project.car_service.dto.CreatePersonDTO;
import com.project.car_service.dto.PersonDTO;
import com.project.car_service.dto.UpdatePersonDTO;
import com.project.car_service.exceptions.PersonNotFoundException;
import com.project.car_service.services.PersonService;
import com.project.car_service.web.view.model.CreatePersonViewModel;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
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

	@Override
	public Person createPerson( @Valid CreatePersonDTO createPersonDTO ) {
		return personRepository.save( modelMapper.map( createPersonDTO, Person.class ) );
	}

	@Override
	public Person updatePerson( String PID, UpdatePersonDTO updatePersonDTO ) {
		return personRepository.save( modelMapper.map( updatePersonDTO, Person.class ) );
	}

	@Override
	public void deletePerson( String PID ) {
		personRepository.deleteById( PID );
	}

	@Override
	public PersonDTO findPersonByPID( String PID ) {
		return modelMapper.map( personRepository.findById( PID )
		.orElseThrow(() -> new PersonNotFoundException( "Invalid Person PID: " + PID ) ), PersonDTO.class);
	}

	private PersonDTO convertToDTO( Person person ) {
		return modelMapper.map(person, PersonDTO.class);
	}

}
