package com.project.car_service.config;

import com.project.car_service.data.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DbInit implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder encoder;

	public DbInit() {
	}

	@Override
	public void run(String... args) throws Exception {
//        this.userRepository.deleteAll();
//        User user = new User();
//        user.setUsername("user");
//        user.setPassword(encoder.encode("user_123"));
//        user.setAccountNonExpired(true);
//        user.setAccountNonLocked(true);
//        user.setEnabled(true);
//        user.setCredentialsNonExpired(true);
//
//        User user2 = new User();
//        user2.setUsername("teacher");
//        user2.setPassword(encoder.encode("teacher_123"));
//        user2.setAccountNonExpired(true);
//        user2.setAccountNonLocked(true);
//        user2.setEnabled(true);
//        user2.setCredentialsNonExpired(true);
//
//        List<User> users = Arrays.asList(user, user2);

        // Save to db
//        this.userRepository.saveAll(users);
	}
}