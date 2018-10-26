package com.example.demo.controller;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.model.User;

@RestController
public class UserRestController {

	@Resource(name="restTemplate")
	private RestTemplate restTemplate;
	
	private static final Logger log = LoggerFactory.getLogger(UserRestController.class);

	@GetMapping(value="/retrieveUser/{ID}", produces=MediaType.APPLICATION_JSON_VALUE)
	public User retrieveSingleUser(@PathVariable("ID") String id) {
		User user = restTemplate.getForObject("https://jsonplaceholder.typicode.com/users/" + id , User.class);
		log.info(user.toString());
		return user;
	}
	
	@GetMapping(value="/retrieveAllUsers", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<User> retrieveAllUsers() {
		ResponseEntity<User[]> responseEntity = restTemplate.getForEntity("https://jsonplaceholder.typicode.com/users", User[].class);
		User[] users = responseEntity.getBody();
		log.info(users.toString());
		return Arrays.asList(users);
	}
}
