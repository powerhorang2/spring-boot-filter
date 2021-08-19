package com.example.filter.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.filter.dto.User;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/temp")
public class ApiController {

	@PostMapping("")
	public User user(@RequestBody User user) {
		log.info("Temp : {}", user);
		return user;
	}
}
