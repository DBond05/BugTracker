package com.electratech.WebApp.bugTrackerController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.electratech.WebApp.bugTrackerRepo.BugRepository;
import com.electratech.WebApp.bugTrackerRepo.UserRepository;

@Controller
@SessionAttributes("name")
@SuppressWarnings("unused")
public class UserController {
	private BugRepository bugRepository;
	private UserRepository userRepository;
	
	public UserController(BugRepository bugRepository, UserRepository userRepository) {
		super();
		this.bugRepository = bugRepository;
		this.userRepository = userRepository;
	}
	
	
	

}
