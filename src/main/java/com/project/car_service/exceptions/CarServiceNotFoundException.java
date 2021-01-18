package com.project.car_service.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus( value = HttpStatus.NOT_FOUND )
public class CarServiceNotFoundException extends RuntimeException{
    public CarServiceNotFoundException(String message) { super(message); }
}
