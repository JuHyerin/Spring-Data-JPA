package com.innilabs.board.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.innilabs.board.entity.Post;

public interface PostRepository extends JpaRepository<Post, Integer>{
  Post findByTitleOrderByTitleAsc();
}
