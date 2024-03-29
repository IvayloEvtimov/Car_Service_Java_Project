package com.project.car_service.data.repository;


import com.project.car_service.data.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {
	User findByUsername(String username);
}