package fr.greta95.cda.security;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.beans.factory.annotation.Autowired;

@Configuration
@EnableWebSecurity
public class SecuriteAPI {
	@Autowired
	private DetailService detailService;
	@Bean 
	protected SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf(autorize -> autorize.disable()).authorizeHttpRequests(autorize -> {
                    try {
                        autorize
                                .requestMatchers("/defaut").permitAll()
                                .requestMatchers("/common").authenticated()
                                .requestMatchers("/user").hasRole("USER")
                                .requestMatchers("/manager").hasRole("MANAGER")
                                .requestMatchers("/admin").hasRole("ADMIN")
                                .and().userDetailsService(detailService);
                    } catch (Exception e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
        ).httpBasic(withDefaults());
		return httpSecurity.build();
	}
	@Bean
	BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
