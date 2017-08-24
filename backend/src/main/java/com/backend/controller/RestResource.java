package com.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.entity.User;
import com.backend.repository.UserRepository;

@RestController
public class RestResource {
	
	@Autowired
	UserRepository userRepository;

	@RequestMapping("/signup")
	public void signUser(@RequestBody User user) {
		userRepository.save(user);
	}
}
