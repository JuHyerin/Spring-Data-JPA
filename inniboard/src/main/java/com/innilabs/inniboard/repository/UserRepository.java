package com.innilabs.inniboard.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.innilabs.inniboard.dto.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	public User findByUserId(String userId);
	
}
