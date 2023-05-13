package com.electratech.WebApp.bugTrackerController;

import java.time.LocalDate;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.electratech.WebApp.bugTrackerModel.Bug;
import com.electratech.WebApp.bugTrackerModel.User;
import com.electratech.WebApp.bugTrackerRepo.BugRepository;
import com.electratech.WebApp.bugTrackerRepo.UserRepository;

import jakarta.validation.Valid;

@Controller
@SessionAttributes("name")
@SuppressWarnings("unused")
public class BugControllerJPA {
 

private BugRepository bugRepository;
private UserRepository userRepository;
	
	public BugControllerJPA( BugRepository bugRepository, UserRepository userRepository) {
	super();
	this.userRepository = userRepository;
	this.bugRepository = bugRepository;
}

	

	@RequestMapping("bugsList")
	public String listAllbugs(ModelMap model) {
		User user= getLoggedInUserByUsername(model); 
		List<Bug> bugs =bugRepository.findByUser(user);
		model.put("bugs", bugs);
		return "bugsList";
	}



	
	@GetMapping("/add-bug")
	public String addBugsPage(ModelMap model) {
		User user= getLoggedInUserByUsername(model);
		Bug bug = new Bug(0, user," " , LocalDate.now(), false, " ");
		model.put("bug", bug);
			return "add-bug";
	}
	@PostMapping( value ="/add-bug")
	public String addNewBug( ModelMap model, @Valid  Bug bug, @Valid User user, BindingResult result) {
		if (result.hasErrors()) {
			return "add-bug";
		}
		user= getLoggedInUserByUsername(model);
		
		bugRepository.save(bug);
			return "redirect:bugsList";
	}
	
	@DeleteMapping("/delete-bug")
	public String deleteBug(@RequestParam int id) {
		bugRepository.deleteById(id);		
		return"redirect:bugsList";
	}
	
	@GetMapping("/modify-bug")
	public String showModifyBugPage(@RequestParam int id, ModelMap model) {
		Bug bug = bugRepository.findById(id).get();
		model.addAttribute("bug",bug);		
		return"add-bug";
	}
	@PostMapping("/modify-bug")
	public String modifyBug( ModelMap model, @Valid  Bug bug, @Valid User user, BindingResult result) {
		
		if (result.hasErrors()) {
			return "add-bug";
		}
		user= getLoggedInUserByUsername(model);
		bugRepository.save(bug);
		return "redirect:bugsList";
	}
	
	@PostMapping( "/resolve-bug")
	public String resolveBug( ModelMap model, @Valid  Bug bug,@Valid User user, BindingResult result) {
		
		if (result.hasErrors()) {
			return "add-bug";
		}
		user= getLoggedInUserByUsername(model);
		bugRepository.save(bug);
			return "redirect:bugsList";
	}
	
	private User getLoggedInUserByUsername(ModelMap model) {
		Authentication auth=
				SecurityContextHolder.getContext().getAuthentication();
		User user = userRepository.findByUsername( auth.getName()).get();
		return user;
	}
	
	
}
