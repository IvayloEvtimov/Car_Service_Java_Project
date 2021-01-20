package com.project.car_service.web.view.controllers;

import com.project.car_service.dto.*;
import com.project.car_service.services.EmploymentService;
import com.project.car_service.services.GarageService;
import com.project.car_service.web.view.model.*;
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
@RequestMapping("/garages")
public class GarageController {
	private final GarageService garageService;
	private final EmploymentService employmentService;
	private final ModelMapper modelMapper;

	@GetMapping
	public String getGarages(Model model) {
		final List<GarageViewModel> garageViewModels = garageService.getGarages()
				.stream().map(this::convertToGarageViewModel).collect(Collectors.toList());

		model.addAttribute("garages", garageViewModels);
		return "/garages/garages";
	}

	@GetMapping("/createGarage")
	public String createGarageServiceForm(Model model) {
		model.addAttribute("garage", new GarageViewModel());
		return "/garages/createGarage";
	}


	@PostMapping("/create")
	public String createGarage(@Valid @ModelAttribute("garage") CreateGarageViewModel createGarageViewModel, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return "/garages/createGarage";
		}

		garageService.createGarage(modelMapper.map(createGarageViewModel, CreateGarageDTO.class));
		return "redirect:/garages";
	}

	@GetMapping("/editGarage/{id}")
	public String showEditGarageServiceForm(Model model, @PathVariable("id") String UIC) {
		model.addAttribute("garage", modelMapper.map(garageService.findByUIC(UIC),UpdateGarageViewModel.class));
		return "/garages/editGarage";
	}

	@PostMapping("/editGarage/{id}")
	public String updateGarage(@PathVariable("id") String UIC, @Valid @ModelAttribute("garage") UpdateGarageViewModel updateGarageViewModel, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "/garages/editGarage";
		}

		updateGarageViewModel.setUIC(UIC);
		garageService.updateGarage(UIC, modelMapper.map(updateGarageViewModel, UpdateGarageDTO.class));
		return "redirect:/garages";
	}

	@GetMapping("/delete/{id}")
	public String processProgramForm(@PathVariable("id") String UIC) {
		garageService.deleteGarage(UIC);
		return "redirect:/garages";
	}

	@GetMapping("/employmentRecord/{id}")
	public String showEmploymentByGarage(Model model, @PathVariable("id") String UIC) {
		final List<EmploymentViewModel> employmentViewModels = employmentService.findEmploymentByGarageUIC(UIC)
				.stream().map(this::convertToEmploymentViewModel).collect(Collectors.toList());

		model.addAttribute("employments", employmentViewModels);
		return "/garages/employmentRecord";
	}


	private GarageViewModel convertToGarageViewModel(GarageDTO garageDTO) {
		return modelMapper.map(garageDTO, GarageViewModel.class);
	}

	private EmploymentViewModel convertToEmploymentViewModel(EmploymentDTO employmentDTO) {
		return modelMapper.map(employmentDTO, EmploymentViewModel.class);
	}
}
