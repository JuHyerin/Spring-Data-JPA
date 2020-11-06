package com.innilabs.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.innilabs.board.entity.User;
import com.innilabs.board.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/users")
@Api
public class UserController {
	@Autowired
	private UserService userService;
	
	@ApiOperation(value = "")
	@GetMapping("/users")
	public List<User> getAllUsers(){
		List<User> userList = userService.getAllUsers();
		
		return userList;
	}
}
