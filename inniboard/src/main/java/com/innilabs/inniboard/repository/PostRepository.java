package com.innilabs.inniboard.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.innilabs.board.entity.Post;

public interface PostRepository extends JpaRepository<Post, Integer>{
	
	//public List<Post> findAllOrderByCreatedAtDesc();
	
}
