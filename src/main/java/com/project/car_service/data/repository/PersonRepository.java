package com.project.car_service.data.repository;

import com.project.car_service.data.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
