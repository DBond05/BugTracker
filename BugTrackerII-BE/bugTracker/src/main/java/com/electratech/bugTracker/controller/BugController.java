package com.electratech.bugTracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.electratech.bugTracker.entity.Bug;
import com.electratech.bugTracker.service.BugService;

@RestController

@RequestMapping(path="/api")
public class BugController {
	
	
	
	private BugService service;
	
	public BugController(BugService service) {
		this.service = service;
	}
	@PostMapping(value="/bugs")
	public @ResponseBody Bug addBug(@RequestBody Bug bug) {
		return service.saveBug(bug);
		}
	@GetMapping("/bugs")
	public List<Bug> findAllBugs(){
		return service.getAllBugs();
		}
	@GetMapping("/bugs/{id}")
	public Bug findBugById(@PathVariable long id) {
		return service.getBugById(id);
	}
	@PutMapping("/bugs")
	public Bug updateBug(@RequestBody Bug bug) {
		return service.updateBug(bug);
	}
	@DeleteMapping("/bugs/{id}")
	public String deleteBug(@PathVariable long id) {
		return service.deleteBug(id);
		
	}
}
