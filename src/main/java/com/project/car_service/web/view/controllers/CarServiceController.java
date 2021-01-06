package com.project.car_service.web.view.controllers;

import com.project.car_service.dto.CarServiceDTO;
import com.project.car_service.dto.CreateCarServiceDTO;
import com.project.car_service.dto.UpdateCarServiceDTO;
import com.project.car_service.services.*;
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
	private final CarServiceService carServiceService;
	private final GarageService garageService;
	private final EmploymentService employmentService;
	private final PersonService personService;
	private final CarService carService;
	private final QualificationService qualificationService;
	private final WorkBrandService workBrandService;
	private final ModelMapper modelMapper;

	@GetMapping
	public String getServices( Model model ) {
		final List<CarServiceViewModel> carServices = carServiceService.getServices()
				.stream()
				.map(this::convertToCarServiceViewModel)
				.collect(Collectors.toList());
		model.addAttribute("carServices", carServices);
		return "/carServices/carServices";
	}

	@GetMapping("/findByLicensePlate/")
	public String findByLicensePlateForm( Model model ) {
		model.addAttribute("cars", carService.getCars());
		model.addAttribute("license", "");

		return "/carServices/findByLicensePlate";
	}

	@GetMapping("/findByLicensePlate/{license}")
	public String findByLicensePlate( Model model, @PathVariable("license") String license ) {
		model.addAttribute("found", carServiceService.findCarServicesByCar_LicensePlate(license));

		return "/carServices/findByLicensePlate";
	}

	@GetMapping("/findByEmployee/")
	public String findCarServicesByEmployee_PIDForm( Model model ) {
		model.addAttribute("employees", employmentService.getEmployees());

		return "/carServices/findByEmployee";
	}

	@GetMapping("/findByEmployee/{PID}")
	public String findCarServicesByEmployee_PID( Model model, @PathVariable("PID") String PID ) {
		model.addAttribute("found", carServiceService.findCarServicesByEmployee_PID(PID));
//		model.addAttribute("employee", employmentService.)

		return "/carServices/findByEmployee";
	}

	@GetMapping("/findByClient")
	public String findByClientForm( Model model ) {
		model.addAttribute("clients", carServiceService.findAllClients());

		return "/carServices/findByClient";
	}

	@GetMapping("/findByClient/{PID}")
	public String findByClient( Model model, @PathVariable("PID") String PID ) {
		model.addAttribute("found", carServiceService.findCarServicesByClient_PID(PID));

		return "/carServices/findByClient";
	}

	@GetMapping("/summary")
	public String summary( Model model ) {
		model.addAttribute("models", carServiceService.countCarBrands());
		model.addAttribute("years", carServiceService.countCarYears());
		model.addAttribute("qualifications", carServiceService.countQualifications());

		return "/carServices/summary";
	}


	@GetMapping("/createCarService")
	public String showCreateCarServiceForm( Model model ) {
		model.addAttribute("garages", garageService.getGarages());
		model.addAttribute("employees", employmentService.getEmployees());
		model.addAttribute("clients", personService.getPersons());
		model.addAttribute("cars", carService.getCars());
		model.addAttribute("qualifications", qualificationService.getQualifications());
		model.addAttribute("carService", new CreateCarServiceViewModel());
		return "/carServices/createCarService";
	}


	@PostMapping("/create")
	public String createCarService( @Valid @ModelAttribute("carService") CreateCarServiceViewModel carServiceViewModel, BindingResult bindingResult, Model model ) {
		if (bindingResult.hasErrors() || (! carServiceViewModel.check(employmentService, workBrandService))) {
			return "/carServices/createCarService";
		}

		carServiceService.createService(modelMapper.map(carServiceViewModel, CreateCarServiceDTO.class));
		return "redirect:/carServices";
	}

	@GetMapping("/editCarService/{id}")
	public String showEditCarServiceForm( Model model, @PathVariable("id") Long serviceId ) {
		model.addAttribute("garages", garageService.getGarages());
		model.addAttribute("employees", employmentService.getEmployees());
		model.addAttribute("clients", personService.getPersons());
		model.addAttribute("cars", carService.getCars());
		model.addAttribute("qualifications", qualificationService.getQualifications());
		model.addAttribute("carService", modelMapper.map(carServiceService.getService(serviceId), UpdateCarServiceViewModel.class));
		return "/carServices/editCarService";
	}

	@PostMapping("/update/{id}")
	public String updateCarService( @PathVariable("id") Long serviceId, @Valid @ModelAttribute("carService") UpdateCarServiceViewModel carServiceViewModel,
	                                BindingResult bindingResult ) {
		if (bindingResult.hasErrors() || (! carServiceViewModel.check(employmentService, workBrandService))) {
			return "/carServices/editCarService";
		}

		carServiceService.updateService(serviceId, modelMapper.map(carServiceViewModel, UpdateCarServiceDTO.class));
		return "redirect:/carServices";
	}

	@GetMapping("/delete/{id}")
	public String processProgramForm( @PathVariable("id") Long serviceId ) {
		carServiceService.deleteService(serviceId);
		return "redirect:/carServices";
	}

	private CarServiceViewModel convertToCarServiceViewModel( CarServiceDTO carServiceDTO ) {
		return modelMapper.map(carServiceDTO, CarServiceViewModel.class);
	}
}
