package com.electratech.bugTracker.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import com.electratech.bugTracker.DAO.BugRepo;
import com.electratech.bugTracker.entity.Bug;
import com.electratech.bugTracker.exception.BadRequestException;

@Service
public class BugService {
	 
	 private BugRepo repo;
	 //@Autowired - unnecessary when using only one constructor for DI
	 public BugService(BugRepo repo) {
		 this.repo = repo;
	 }
	 //post method to save bug to database
	 public Bug saveBug(Bug bug) {
		 return repo.save(bug);
	 }
	 
	 //get methods
	 // load all bugs
	 public List<Bug> getAllBugs(){
		 return repo.findAll();
	 }
	// find one bug
	 public Bug getBugById(long id){
		try {
			return repo.findById(id).get();
		}catch(NoSuchElementException ex) {
			return null;
		}
	 }
	 // method to delete bug
	 public String deleteBug(long id){
		 try {
		 long rowsbeforeDelete = repo.count();
		 repo.deleteById(id);
		 long rowsAfterDelete = repo.count();
		 if (rowsbeforeDelete < rowsAfterDelete) {
		 return "Bug deleted";
		 } else {
			 return "";
		 }
		 } catch (EmptyResultDataAccessException ex){
			 return "";
		 }
		 
	 }
	 // method to get bug to update;
	 public Bug updateBug(Bug bug) {
		Optional<Bug> exBug = repo.findById(bug.getId());
		 if(exBug.isPresent()) {
			 exBug.get().setDescription(bug.getDescription());;
			 exBug.get().setIssueType(bug.getIssueType());
			 exBug.get().setProjectName(bug.getProjectName());
			 exBug.get().setResolution(bug.getResolution());
			 exBug.get().setResolved(bug.isResolved());
			 exBug.get().setTroubleShooting(bug.getTroubleShooting());
			 return repo.save(exBug.get()); 
		 }else {
			 throw new BadRequestException("Bug Not Found");
			 
		 }
		 
		 
		 
	 }

}
