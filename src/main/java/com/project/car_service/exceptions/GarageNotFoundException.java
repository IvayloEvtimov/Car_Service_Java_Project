package com.project.car_service.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus( value = HttpStatus.NOT_FOUND )
public class GarageNotFoundException extends RuntimeException{
	public GarageNotFoundException(String message) {
		super(message);
	}
}
