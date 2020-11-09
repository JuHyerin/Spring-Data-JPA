package com.innilabs.board.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.innilabs.board.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
