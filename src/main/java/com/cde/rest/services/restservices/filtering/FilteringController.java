package com.cde.rest.services.restservices.filtering;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilteringController {

	@GetMapping("/filtering")
	public TestBean retrieveBean() {
		return new TestBean("val 1", "val 2", "val 3");
	}
}
