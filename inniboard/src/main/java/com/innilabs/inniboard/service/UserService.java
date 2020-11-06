package com.innilabs.inniboard.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.innilabs.inniboard.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    public UserRepository userRepository;
}