package com.project.car_service.repository;

import com.project.car_service.data.entity.Car;
import com.project.car_service.data.entity.CarService;
import com.project.car_service.data.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CarServiceRepository extends JpaRepository<CarService, Long> {

//	List<CarService> findById();


	List<CarService> findAllByCar(Car car);

	List<CarService> findCarServicesByCar_LicensePlate(String licensePlate);

	List<CarService> findCarServicesByEmployee_PID(String PID);

	List<CarService> findCarServicesByCar_LicensePlateAndEmployee_PID(String licensePlate, String PID);

	List<CarService> findCarServicesByClient_PID(String PID);

	@Query("SELECT DISTINCT cs.client FROM CarService cs")
	List<Person> findAllClients();
}
