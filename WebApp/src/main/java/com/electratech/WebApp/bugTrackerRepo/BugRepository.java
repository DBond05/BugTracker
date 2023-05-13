package com.electratech.WebApp.bugTrackerRepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.electratech.WebApp.bugTrackerModel.Bug;
import com.electratech.WebApp.bugTrackerModel.User;

public interface BugRepository extends JpaRepository <Bug, Integer>{
	
	public List<Bug> findByUser(User user);
}
