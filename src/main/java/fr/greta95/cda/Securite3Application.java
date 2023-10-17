package fr.greta95.cda;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import fr.greta95.cda.dao.AppRoleRepository;
import fr.greta95.cda.dao.AppUserRepository;
import fr.greta95.cda.model.AppRole;
import fr.greta95.cda.model.AppUser;

@SpringBootApplication
public class Securite3Application {
	@Autowired
	AppUserRepository appUserRepository;
	@Autowired
	AppRoleRepository appRoleRepository ;
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	public static void main(String[] args) {
		SpringApplication.run(Securite3Application.class, args);
	}
	
	@Bean
	CommandLineRunner commandLineRunner() {
		return args->{
		AppUser u1 = AppUser.builder().username("user1").password(bCryptPasswordEncoder.encode("1234")).email("user1@gmail.com").build();
		AppUser u2 = AppUser.builder().username("user2").password(bCryptPasswordEncoder.encode("1234")).email("user2@gmail.com").build();
		AppUser u3 = AppUser.builder().username("user3").password(bCryptPasswordEncoder.encode("1234")).email("user3@gmail.com").build();
		AppUser u4 = AppUser.builder().username("manager").password(bCryptPasswordEncoder.encode("1234")).email("manager@gmail.com").build();
		AppUser u5 = AppUser.builder().username("admin").password(bCryptPasswordEncoder.encode("1234")).email("admin@gmail.com").build();
		AppRole r1= AppRole.builder().rolename("USER").build();
		AppRole r2= AppRole.builder().rolename("ADMIN").build();
		AppRole r3= AppRole.builder().rolename("MANAGER").build();
		appRoleRepository.save(r1);
		appRoleRepository.save(r2);
		appRoleRepository.save(r3);
		
		List<AppRole> lesroles = Arrays.asList(r1);
 		u1.setLesroles(lesroles);
 		u2.setLesroles(lesroles);
 		u3.setLesroles(lesroles);
 		lesroles = Arrays.asList(r1,r3);
 		u4.setLesroles(lesroles);
 		lesroles = Arrays.asList(r1,r2,r3);
 		u5.setLesroles(lesroles);
 		appUserRepository.save(u1);
		appUserRepository.save(u2);
		appUserRepository.save(u3);
		appUserRepository.save(u4);
		appUserRepository.save(u5);
		};
	}
}
