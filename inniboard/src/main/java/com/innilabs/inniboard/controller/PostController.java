package com.innilabs.inniboard.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.annotation.PostConstruct;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.innilabs.board.entity.Post;
import com.innilabs.inniboard.repository.PostRepository;
import com.innilabs.inniboard.service.PostService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
@DependsOn("testapi")
@RestController
@RequestMapping("/api/board")
public class PostController {
    ObjectMapper om;
    @PostConstruct
    void init(){
        om = new ObjectMapper(); 
    }

    @Autowired
    private PostService postService;
    private PostRepository postRepository;
     
    @ApiOperation(value = "Get All Posts", notes = "모든 게시물 조회") 
    @GetMapping(value="/posts")
    public ResponseEntity<?> getAllPost(){ 
    	List<Post> postList = postService.getAllPost();
    	return new ResponseEntity<List<Post>>(postList, HttpStatus.OK);

    }

    
    @GetMapping(value = "/posts/{id}")
    public ResponseEntity<?> getPostById(@ApiParam(value = "조회할 post id", defaultValue = "1")@PathVariable(value = "id", required = true) int id){
        Post post = postService.getPostById(id);
    	return new ResponseEntity<Post>(post, HttpStatus.OK);
    }

   
    @ApiOperation(value = "Insert New Post", notes = "게시물 등록")
    @ApiResponses({
        @ApiResponse(code = 200, message = "(C)Createed !!"),
        @ApiResponse(code = 201, message = "(C)Createed !!"),
        @ApiResponse(code = 500, message = "(C)Internal Server Error !!"),
        @ApiResponse(code = 405, message = "(C)Alreadt Exist !!")
    })
    @PostMapping(value = "/posts")
    public ResponseEntity<Post> createPost(@ApiParam(value = "등록할 게시물") @RequestBody Post post){
    	Post createdPost = postService.createPost(post);
        return new ResponseEntity<Post>(createdPost, HttpStatus.CREATED);
    }

    @ApiOperation(value = "Update Post", notes = "게시물 수정")
    @PutMapping(value = "/posts")
    public ResponseEntity<Post> editPost(@ApiParam(value = "수정할 게시물의 post id", required = true, defaultValue = "1") @RequestParam int id, 
                                        @ApiParam(value = "수정된 게시물") @RequestBody Post post){  
                      
        Post updatedPost = postService.editPost(post);     
        return new ResponseEntity<Post>(updatedPost, HttpStatus.OK);
    }

    @ApiOperation(value = "Delete Post by PostID", notes = "寃뚯떆臾� �궘�젣")
    @DeleteMapping(value = "/posts/{id}")
    public ResponseEntity deletePostById(@ApiParam(value="�궘�젣�븷 寃뚯떆臾� �븘�씠�뵒", defaultValue = "1")@PathVariable int id){
    
        postService.deletePostById(id);
        
        return new ResponseEntity(HttpStatus.OK);
    }
}