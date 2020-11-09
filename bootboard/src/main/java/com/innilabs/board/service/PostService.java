package com.innilabs.board.service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.innilabs.board.dto.RequestPost;
import com.innilabs.board.entity.Post;
import com.innilabs.board.entity.User;
import com.innilabs.board.repo.PostRepository;
import com.innilabs.board.repo.UserRepository;

@Service

public class PostService {
	@Autowired
	private PostRepository postRepo;
	@Autowired
	private UserRepository userRepo;

	public List<Post> getAllPosts() {
		List<Post> postList = postRepo.findAll();
		return postList;
	}

	public Post createPost(RequestPost reqPost) {
		System.out.println("서비스 요청");

		Post reqEntity = new Post();
		reqEntity.setTitle(reqPost.getTitle());
		reqEntity.setContents(reqPost.getContents());

		User existUser = userRepo.findAll().get(0);
		System.out.println("user:"+ existUser);
		reqEntity.setWriter(existUser);

		reqEntity.setCreatedAt(Timestamp.valueOf(LocalDateTime.now()));
		reqEntity.setUpdatedAt(null);
		reqEntity.setDeletedAt(null);
		reqEntity.setDeleted(false);
		
		System.out.println("생성 전");
		Post createdPost = postRepo.saveAndFlush(reqEntity);
		System.out.println("생성 후");
		return createdPost;
	}

	public Post editPost(int id, RequestPost reqPost) {
		Post reqEntity = new Post();
		reqEntity.setPostId(id);
		reqEntity.setTitle(reqPost.getTitle());
		reqEntity.setContents(reqPost.getContents());
		reqEntity.setUpdatedAt(Timestamp.valueOf(LocalDateTime.now()));

		reqEntity.setWriter(new User("id000", "000", "혜린"));
		
		Post updatedPost = postRepo.saveAndFlush(reqEntity);
		return updatedPost;
	}

	public void deletePost(int id) {
		Optional<Post> deletedPost = postRepo.findById(id);
		deletedPost.get().setWriter(null);
		postRepo.delete(deletedPost.get());
		return;
	} 

	
}