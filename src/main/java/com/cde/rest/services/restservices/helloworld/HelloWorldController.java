package com.cde.rest.services.restservices.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	//@RequestMapping(method= RequestMethod.GET, path="/hello-world")
	@GetMapping(path= "/hello-world")
	public String helloWorld() {
	 return "hello world";
	}
	
	@GetMapping(path= "/hello-world-bean")
	public HelloWorldBean helloWorldBean() {
	 return new HelloWorldBean("hello world");
	}
	
	@GetMapping(path= "/hello-world-bean/path-variable/{name}")
	public HelloWorldBean helloWorldPath(@PathVariable String name) {
	 return new HelloWorldBean(String.format("hello %s", name)) ;
	}
}
