package com.project.car_service.web.view.controllers;

import com.project.car_service.dto.CreatePersonDTO;
import com.project.car_service.dto.PersonDTO;
import com.project.car_service.dto.UpdatePersonDTO;
import com.project.car_service.services.PersonService;
import com.project.car_service.web.view.model.CreatePersonViewModel;
import com.project.car_service.web.view.model.PersonViewModel;
import com.project.car_service.web.view.model.UpdatePersonViewModel;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@AllArgsConstructor
@RequestMapping("/persons")
public class PersonController {
	private final PersonService personService;
	private final ModelMapper modelMapper;

	@GetMapping
	public String getPersons(Model model) {
		final List<PersonViewModel> personViewModels = personService.getPersons()
				.stream()
				.map(this::convertToPersonViewModel)
				.collect(Collectors.toList());

		model.addAttribute("persons", personViewModels);
		return "/persons/persons";
	}

	@GetMapping("/createPerson")
	public String createPersonServiceForm(Model model) {
		model.addAttribute("person", new CreatePersonViewModel());
		return "/persons/createPerson";
	}


	@PostMapping("/create")
	public String createPerson(@Valid @ModelAttribute("person") CreatePersonViewModel createPersonViewModel, BindingResult bindingResult, Model model) {
		if ( bindingResult.hasErrors() ) {
			return "/persons/createPerson";
		}

		personService.createPerson(modelMapper.map(createPersonViewModel, CreatePersonDTO.class));
		return "redirect:/persons";
	}

	@GetMapping("/editPerson/{id}")
	public String showEditCarServiceForm(Model model, @PathVariable("id") String PID) {
		model.addAttribute("person", modelMapper.map(personService.findPersonByPID(PID), UpdatePersonViewModel.class));
		return "/persons/editPerson";
	}

	@PostMapping("/update/{id}")
	public String updatePerson(@PathVariable("id") String PID, @Valid @ModelAttribute("person") UpdatePersonViewModel updatePersonViewModel, BindingResult bindingResult) {
		if ( bindingResult.hasErrors() ) {
			return "/persons/editPerson";
		}

		personService.updatePerson(PID, modelMapper.map(updatePersonViewModel, UpdatePersonDTO.class));
		return "redirect:/persons";
	}

	@GetMapping("/delete/{id}")
	public String processProgramForm(@PathVariable("id") String PID) {
		personService.deletePerson(PID);
		return "redirect:/persons";
	}


	private PersonViewModel convertToPersonViewModel(PersonDTO personDTO) {
		return modelMapper.map(personDTO, PersonViewModel.class);
	}
}