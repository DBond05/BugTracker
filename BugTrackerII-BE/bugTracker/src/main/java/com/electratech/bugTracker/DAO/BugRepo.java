package com.electratech.bugTracker.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.electratech.bugTracker.entity.Bug;


public interface BugRepo extends JpaRepository<Bug, Long> {
	

}
