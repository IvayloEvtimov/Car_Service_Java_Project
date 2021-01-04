package com.project.car_service.data.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User implements UserDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "username", nullable = false, unique = true)
	private String username;

	@Column(name = "password", nullable = false)
	private String password;

	@Column
	private boolean isAccountNonExpired;

	@Column
	private boolean isAccountNonLocked;

	@Column
	private boolean isCredentialsNonExpired;

	@Column
	private boolean isEnabled;

	@ManyToMany(fetch = FetchType.EAGER)
	private Set<Role> authorities;
}
