package com.innilabs.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.innilabs.board.entity.Post;
import com.innilabs.board.repo.PostRepository;

@Service
public class PostService {
	@Autowired
	private PostRepository postRepo;

	public List<Post> getAllPosts() {
		List<Post> postList = postRepo.findAll();
		return postList;
	}
}
