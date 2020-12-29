package com.project.car_service.dto;

import com.project.car_service.data.entity.CarBrand;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CarModelDTO {
    private String carModel;
    private CarBrand carBrand;
    private Integer year;
}
