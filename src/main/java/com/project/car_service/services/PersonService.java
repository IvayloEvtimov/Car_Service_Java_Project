package com.project.car_service.services;

import com.project.car_service.data.entity.Person;
import com.project.car_service.dto.CreatePersonDTO;
import com.project.car_service.dto.PersonDTO;
import com.project.car_service.dto.UpdatePersonDTO;

import javax.validation.Valid;
import java.util.List;

public interface PersonService {
	List<PersonDTO> getPersons();

	Person createPerson( @Valid CreatePersonDTO createPersonDTO );

	Person updatePerson( String PID, UpdatePersonDTO updatePersonDTO );

	void deletePerson( String PID );

	PersonDTO findPersonByPID( String PID );
}
