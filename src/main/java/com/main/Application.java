package com.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@SpringBootApplication
public class Application {

	
	  @Bean
	    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	        http
	            .csrf(csrf -> csrf.disable()) // Disable CSRF (Only if needed)
	            .authorizeHttpRequests(auth -> auth
	                .antMatchers("/employees/register").permitAll() 
	                .antMatchers("/employees/admin").authenticated() 
	                .anyRequest().authenticated())
	            .formLogin() // Enable login form
	            .and()
	            .httpBasic(); // Enable basic authentication
	        
	        return http.build();
	    }
	
	
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	
		
		
	}

}
