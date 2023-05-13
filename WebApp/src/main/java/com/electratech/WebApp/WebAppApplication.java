package com.electratech.WebApp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.electratech.WebApp.bugTrackerModel.User;
import com.electratech.WebApp.bugTrackerRepo.BugRepository;
import com.electratech.WebApp.bugTrackerRepo.UserRepository;

@SpringBootApplication
public class WebAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebAppApplication.class, args);
	}
	
	CommandLineRunner clr(UserRepository users, BugRepository bugs, PasswordEncoder encoder) {
	User user =new User(200, "Demo", "Demo", "nstration", encoder.encode("password"), encoder.encode("password"),"ROLE_USER, ROLE_ADMIN" );
	return args ->{
		users.save(user);
		//bugs.save(new Bug(1000, user,"Error creating bean with name dataSourceScriptDatabaseInitializer",LocalDate.now(), true, "problem occurred in BugController.addNewBug() method"));
	};
	}

}
