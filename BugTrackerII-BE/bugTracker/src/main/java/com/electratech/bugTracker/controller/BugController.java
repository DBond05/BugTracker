package com.electratech.bugTracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.electratech.bugTracker.entity.Bug;
import com.electratech.bugTracker.service.BugService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
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
//	@GetMapping("/bugs")
//	public List<Bug> findAllBugs(){
//		return service.getAllBugs();
//		}
//	
	
	@GetMapping("/bugs")
	public Page<Bug> findAllBugs(
	    @RequestParam(defaultValue = "0") int page, 
	    @RequestParam(defaultValue = "10") int size,
	    @RequestParam(defaultValue = "id") String sortField, 
	    @RequestParam(defaultValue = "true") boolean asc) {

	    return service.getSortedPagedBugs(page, size, sortField, asc);
	}
	
	
	@GetMapping("/bugs/{field}/{direction}")
	public List<Bug> sortedBugs(@PathVariable String field, @PathVariable boolean direction ){
		return service.sortBasedOnField(field, direction);
		} 
	
	@GetMapping("/bugs/{field}/{direction}/{offset}/{pageSize}")
	public Page<Bug> pagedBugs(@PathVariable String field, @PathVariable boolean direction,@PathVariable int offset,@PathVariable int pageSize ){
		return service.getSortedPagedBugs(offset, pageSize, field, direction);
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
	@GetMapping("/bugs/search")
	public Page<Bug> searchBugs(
	    @RequestParam("keyword") String keyword,
	    @RequestParam(defaultValue = "0") int page,  
	    @RequestParam(defaultValue = "10") int size,
	    @RequestParam(defaultValue = "id") String sortField, 
	    @RequestParam(defaultValue = "true") boolean ascending 
	) {
	    return service.searchBugs(keyword, page, size, sortField, ascending);
	}

}
