package com.project.car_service.web.view.controllers;

import com.project.car_service.dto.CarServiceDTO;
import com.project.car_service.dto.CreateCarServiceDTO;
import com.project.car_service.dto.UpdateCarServiceDTO;
import com.project.car_service.services.CarServiceService;
import com.project.car_service.services.EmploymentService;
import com.project.car_service.services.GarageService;
import com.project.car_service.services.PersonService;
import com.project.car_service.web.view.model.CarServiceViewModel;
import com.project.car_service.web.view.model.CreateCarServiceViewModel;
import com.project.car_service.web.view.model.UpdateCarServiceViewModel;
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
@RequestMapping("/carServices")
public class CarServiceController {
	private final CarServiceService carService;
	private final GarageService garageService;
	private final EmploymentService employmentService;
	private final PersonService personService;

	private final ModelMapper modelMapper;

	@GetMapping
	public String getServices( Model model ) {
		final List<CarServiceViewModel> carServices = carService.getServices()
				.stream()
				.map(this::convertToCarServiceViewModel)
				.collect(Collectors.toList());
		model.addAttribute("carServices", carServices);
		return "/carServices/carServices";
	}

	@GetMapping("/createCarService")
	public String showCreateCarServiceForm( Model model ) {
		model.addAttribute("garage", garageService.getGarages());
		model.addAttribute("employee", employmentService.getEmployees());
		model.addAttribute("client", personService.getPersons());
		model.addAttribute("car", )
		model.addAttribute("carService", new CreateCarServiceViewModel());
		return "/carServices/createCarService";
	}

	@PostMapping("/create")
	public String createCarService( @Valid @ModelAttribute("carService") CreateCarServiceViewModel carServiceViewModel, BindingResult bindingResult ) {
		if (bindingResult.hasErrors()) {
			return "/carServices/createCarService";
		}

		carService.createService(modelMapper.map(carServiceViewModel, CreateCarServiceDTO.class));
		return "redirect:/carServices";
	}

	@GetMapping("/editCarService/{id}")
	public String showEditCarServiceForm( Model model, @PathVariable("id") Long serviceId ) {
		model.addAttribute("carService", modelMapper.map(carService.getService(serviceId), UpdateCarServiceViewModel.class));
		return "/carServices/editCarService";
	}

	@PostMapping("/update/{id}")
	public String updateCarService( @PathVariable("id") Long serviceId, @Valid @ModelAttribute("carService") UpdateCarServiceViewModel carServiceViewModel,
	                                BindingResult bindingResult ) {
		if (bindingResult.hasErrors()) {
			return "/carServices/editCarService";
		}

		carService.updateService(serviceId, modelMapper.map(carServiceViewModel, UpdateCarServiceDTO.class));
		return "redirect:/carServices";
	}

	@GetMapping("/delete/{id}")
	public String processProgramForm( @PathVariable("id") Long serviceId ) {
		carService.deleteService(serviceId);
		return "redirect:/carServices";
	}

	private CarServiceViewModel convertToCarServiceViewModel( CarServiceDTO carServiceDTO ) {
		return modelMapper.map(carServiceDTO, CarServiceViewModel.class);
	}
}
