package com.electratech.WebApp.bugTrackerRepo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.electratech.WebApp.bugTrackerModel.User;

public interface UserRepository extends JpaRepository <User,Integer> {

	Optional<User> findByUsername(String username);
	

}
