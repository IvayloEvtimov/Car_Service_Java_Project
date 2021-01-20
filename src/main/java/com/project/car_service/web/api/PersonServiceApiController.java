package com.project.car_service.web.api;

import com.project.car_service.data.entity.Person;
import com.project.car_service.dto.CreatePersonDTO;
import com.project.car_service.dto.GarageDTO;
import com.project.car_service.dto.PersonDTO;
import com.project.car_service.dto.UpdatePersonDTO;
import com.project.car_service.services.PersonService;
import com.project.car_service.web.view.model.UpdatePersonViewModel;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/persons")
@AllArgsConstructor
public class PersonServiceApiController {
	private final PersonService personService;

	private final ModelMapper modelMapper;

	@GetMapping
	public List<PersonDTO> getPersons() {
		return personService.getPersons();
	}

	@PostMapping
	public Person createPerson(@RequestBody @Valid Person person) {
		return personService.createPerson(modelMapper.map(person, CreatePersonDTO.class));
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/{id}")
	public Person updatePerson(@PathVariable("id") String PID, @RequestBody UpdatePersonViewModel updatePersonViewModel) {
		return personService.updatePerson(PID, modelMapper.map(updatePersonViewModel, UpdatePersonDTO.class));
	}


	@DeleteMapping(value = "/{id}")
	public void deletePerson(@PathVariable("id") String PID) {
		personService.deletePerson(PID);
	}

	@GetMapping("/findPersonByPID")
	public PersonDTO findPersonByPID( String PID ) {
		return personService.findPersonByPID(PID);
	}
}
