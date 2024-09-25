package com.electratech.bugTracker.DAO;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.electratech.bugTracker.entity.Bug;


public interface BugRepo extends JpaRepository<Bug, Long> {
	Page<Bug> findByDescriptionContaining(@Param("description")String description, Pageable pageable);
    List<Bug> findByIssueTypeContainingOrDescriptionContaining(String issueType,String description);
}
