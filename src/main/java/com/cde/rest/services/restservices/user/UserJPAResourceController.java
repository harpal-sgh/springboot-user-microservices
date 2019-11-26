package com.cde.rest.services.restservices.user;
import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserJPAResourceController {
	
	@Autowired
	private UserService service;
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private PostRepo postRepo;
	
	@GetMapping("/jpa/users")
	public List<User> retrieveAllUsers() {
		return userRepo.findAll();		
	}
	
	@GetMapping("/jpa/users/{id}")
	public Optional<User> retrieveUser(@PathVariable int id) {
		Optional<User> user = userRepo.findById(id);
		
		if(!user.isPresent()) {
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
	
	@PostMapping("/jpa/users")
	public ResponseEntity<Object> createUSer(@Valid @RequestBody User user) {
		User savedUser = userRepo.save(user);
		
		URI location = ServletUriComponentsBuilder
        .fromCurrentRequest()
        .path("/{id}")
        .buildAndExpand(savedUser.getId())
        .toUri();		
		
		return ResponseEntity.created(location).build();
			
	}
	
	@DeleteMapping("/jpa/users/{id}")
	public void deleteUser(@PathVariable int id) {
    	userRepo.deleteById(id);	
	}
	
	@GetMapping("/jpa/users/{id}/posts")
	public List<Post> retrieveUserPosts(@PathVariable int id) {
		Optional<User> user = userRepo.findById(id);
		
		if(!user.isPresent()) {
			throw new UserNotFoundException("id-" + id);
		}
		
		return user.get().getPosts();
		
		
	}
	
	@PostMapping("/jpa/users/{id}/posts")
	public ResponseEntity<Object> createUserPost(@PathVariable int id,@Valid @RequestBody Post post) {
        Optional<User> userOptional = userRepo.findById(id);
		
		if(!userOptional.isPresent()) {
			throw new UserNotFoundException("id-" + id);
		}
		
		User user = userOptional.get();
		post.setUser(user);
		postRepo.save(post);
		
		URI location = ServletUriComponentsBuilder
        .fromCurrentRequest()
        .path("/{id}")
        .buildAndExpand(post.getId())
        .toUri();		
		
		return ResponseEntity.created(location).build();
			
	}
}
