package com.electratech.bugTracker.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import org.springframework.data.domain.Pageable;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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

	 //method to sort bugs
	 public List<Bug> sortBasedOnField(String field, boolean direction){
		if (direction) {
		 return repo.findAll(Sort.by(Sort.Direction.ASC, field));
		}
		return repo.findAll(Sort.by(Sort.Direction.DESC, field));
	 }


	//method to sort with pagination

	public Page<Bug> getSortedPagedBugs(int offset, int pageSize, String field, boolean direction){
	if(direction) {
	return repo.findAll(PageRequest.of(offset, pageSize).withSort(Sort.by(Sort.Direction.ASC, field)));
	}
	return repo.findAll(PageRequest.of(offset, pageSize).withSort(Sort.by(Sort.Direction.DESC, field)));
	}
	
	public Page<Bug> getFilteredSortedPagedBugs(String description, int offset, int pageSize, String field, boolean direction) {
	    Pageable pageable = PageRequest.of(offset, pageSize, direction ? Sort.by(Sort.Direction.ASC, field) : Sort.by(Sort.Direction.DESC, field));
	    return repo.findByDescriptionContaining(description, pageable);
	}
	//method to search  with pagination
	public Page<Bug> searchBugs(String keyword, int page, int size, String sortField, boolean ascending) {
	    Pageable pageable = PageRequest.of(
	        page, 
	        size, 
	        ascending ? Sort.by(sortField).ascending() : Sort.by(sortField).descending()
	    );
	    return repo.findByDescriptionContaining(keyword, pageable);
	}
	
}
