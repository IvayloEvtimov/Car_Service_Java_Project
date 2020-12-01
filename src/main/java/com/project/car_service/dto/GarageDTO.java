package com.project.car_service.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class GarageDTO {
    private String UIC;
    private String name;
    private String address;
}
