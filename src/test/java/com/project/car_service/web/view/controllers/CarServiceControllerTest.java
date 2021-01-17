package com.project.car_service.web.view.controllers;

import com.project.car_service.services.CarServiceService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;


@ExtendWith(SpringExtension.class)
@WebMvcTest(CarServiceController.class)
//@ActiveProfiles(value = "dev")
//@WithMockUser(username = "user", password = "user_123", roles = {"ADMIN"})
//@WithUserDetails("user")
@EnableAutoConfiguration(exclude = { SecurityAutoConfiguration.class})
public class CarServiceControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private CarServiceService service;

	@MockBean
	private ModelMapper modelMapper;


	@Test
	void getServices() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/carServices/carServices")
				.with(user("user").password("user_123").roles("ADMIN")))
				.andExpect(status().isOk())
				.andExpect(view().name("/carServices/carServices"));
	}

	@Test
	void findByLicensePlateForm() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/carServices/findByLicensePlate"))
				.andExpect(status().isOk())
				.andExpect(view().name("/carServices/findByLicensePlate"));
	}

}