package com.electratech.WebApp.security;



import static org.springframework.security.config.Customizer.withDefaults;

import java.util.function.Function;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;



@Configuration
public class SecurityConfiguration {
	//private UserRepository userRepo ;
	private final JpaUserDetailsService jpaUserDetailsSerivce;
	
	
	
	public SecurityConfiguration(JpaUserDetailsService jpaUserDetailsSerivce) {
		this. jpaUserDetailsSerivce =  jpaUserDetailsSerivce;
	}
	@Bean
	public InMemoryUserDetailsManager createUserDetailsManager() {
		UserDetails userDetails=createNewUser("Demo", "password");
		return new InMemoryUserDetailsManager(userDetails);
	}
	
	
	  @Bean public UserDetails createNewUser(String userName, String password) {
	  Function<String, String> passwordEncoder= input ->
	  passwordEncoder().encode(input); UserDetails userDetails
	  =User.builder().passwordEncoder(passwordEncoder)
	  .username(userName).password(password).roles("USER", "ADMIN").build(); return
	  userDetails; }
	 
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	@Bean
	public  SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(auth -> auth.anyRequest().authenticated())
				.userDetailsService( jpaUserDetailsSerivce);
		http.formLogin(withDefaults());
		
		http.csrf().disable();
		http.headers().frameOptions().sameOrigin();
		return http.build();
	}

}
