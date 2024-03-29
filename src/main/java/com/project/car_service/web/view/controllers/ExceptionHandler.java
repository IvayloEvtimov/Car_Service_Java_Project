package com.project.car_service.web.view.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionHandler {

	@org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
	protected String handleException(Exception exception, Model model) {
		model.addAttribute("message", exception.getMessage());
		return "/errors/errors";
	}
}
