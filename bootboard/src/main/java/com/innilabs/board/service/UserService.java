package com.innilabs.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.innilabs.board.entity.User;
import com.innilabs.board.repo.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepo;

		public List<User> getAllUsers() {
			List<User> userList = userRepo.findAll();
			for(User user : userList){
				System.out.println(user);
			}
			return userList;
		}
	
	
}
