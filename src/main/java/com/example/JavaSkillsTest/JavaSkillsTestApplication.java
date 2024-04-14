package com.example.JavaSkillsTest;

import com.example.JavaSkillsTest.model.RoleApp;
import com.example.JavaSkillsTest.model.RoleEnum;
import com.example.JavaSkillsTest.model.UsuarioApp;
import com.example.JavaSkillsTest.repository.RoleRepository;
import com.example.JavaSkillsTest.repository.UserAppRepository;
import com.example.JavaSkillsTest.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class JavaSkillsTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaSkillsTestApplication.class, args);
	}

	@Bean
	CommandLineRunner init(RoleRepository roleRepository) {
		return args -> {
			// Create ROLES
			RoleApp roleAdmin = RoleApp.builder()
					.roleEnum(RoleEnum.ADMIN)
					.build();

			RoleApp roleUser = RoleApp.builder()
					.roleEnum(RoleEnum.USER)
					.build();

			RoleApp roleInvited = RoleApp.builder()
					.roleEnum(RoleEnum.INVITED)
					.build();

			RoleApp roleDeveloper = RoleApp.builder()
					.roleEnum(RoleEnum.DEVELOPER)
					.build();

			roleRepository.saveAll(Arrays.asList(roleAdmin, roleUser, roleInvited, roleDeveloper));
		};
	}
}

