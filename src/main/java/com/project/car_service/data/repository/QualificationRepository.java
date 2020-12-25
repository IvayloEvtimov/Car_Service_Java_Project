package com.project.car_service.data.repository;

import com.project.car_service.data.entity.Qualification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QualificationRepository extends JpaRepository<Qualification, String> {

}
