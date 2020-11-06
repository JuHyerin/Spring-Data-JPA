package com.innilabs.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.innilabs.board.entity.Post;
import com.innilabs.board.service.PostService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/posts")
@Api
public class PostController {

	@Autowired
	private PostService postService;
	
	@ApiOperation(value = "")
	@GetMapping("/posts")
	public ResponseEntity<List<Post>> getAllPosts(){
		List<Post> postList = postService.getAllPosts();
		
		return new ResponseEntity<List<Post>>(postList, HttpStatus.OK);
	}
}
