package com.innilabs.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.innilabs.board.dto.RequestPost;
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
	@GetMapping("/list")
	public ResponseEntity<List<Post>> getAllPosts(){
		System.out.println("Controller 요청");
		List<Post> postList = postService.getAllPosts();		
		System.out.println("Controller 응답");

		return new ResponseEntity<List<Post>>(postList, HttpStatus.OK);
	}

	@ApiOperation(value = "")
	@PostMapping("/save")
	public ResponseEntity<Post> createPost(@RequestBody RequestPost reqPost){
		System.out.println("Controller 요청");
		Post createdPost =  postService.createPost(reqPost);
		System.out.println("Controller 응답");

		return new ResponseEntity<Post>(createdPost, HttpStatus.OK);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Post>	editPost(@PathVariable int id, @RequestBody RequestPost reqPost){
		Post editedPost = postService.editPost(id, reqPost);
		return new ResponseEntity<Post>(editedPost, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Post>	deletePost(@PathVariable int id){
		postService.deletePost(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
