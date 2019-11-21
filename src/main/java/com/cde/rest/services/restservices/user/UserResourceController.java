package com.cde.rest.services.restservices.user;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserResourceController {
	
	@Autowired
	private UserService service;
	
	@GetMapping("/users")
	public List<User> retrieveAllUsers() {
		return service.findAll();		
	}
	
	@GetMapping("/users/{id}")
	public User retrieveUser(@PathVariable int id) {
		User user = service.findOne(id);
		if(user==null) {
			throw new UserNotFoundException("id-" + id);
		}
		return user;
	}
	
//	@GetMapping("/users-test/{id}")
//	public ResponseEntity<Object> retrieveUserTest(@PathVariable int id) {
//		User user = service.findOne(id);
//		if(user==null) {
//			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//		}	
//
//		return new ResponseEntity<Object>(user, HttpStatus.OK);
//	}
	
	@PostMapping("/users")
	public ResponseEntity<Object> createUSer(@RequestBody User user) {
		User savedUser = service.save(user);
		
		URI location = ServletUriComponentsBuilder
        .fromCurrentRequest()
        .path("/{id}")
        .buildAndExpand(savedUser.getId())
        .toUri();
		
		return ResponseEntity.created(location).build();
			
	}
}
