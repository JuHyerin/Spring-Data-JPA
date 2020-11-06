package com.innilabs.inniboard.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.innilabs.board.entity.Post;
import com.innilabs.inniboard.repository.PostRepository;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;
    
    public List<Post> getAllPost(){ 
    	List<Post> postList = postRepository.findAll();
       
        return postList;
    }

	public Post getPostById(int id) {
		Optional<Post> post = postRepository.findById(id);
		return null;
	}

    public Post createPost(Post post) {
        Post createdPost = postRepository.save(post);
        return createdPost;
    }

	public Post editPost(Post post) {
		Post updatedPost = postRepository.save(post);
		return updatedPost;
	}

	public void deletePostById(int id) {
		postRepository.deleteById(id);
	}
}