package com.project.car_service.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class PersonDTO {
    private String PID;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
}
