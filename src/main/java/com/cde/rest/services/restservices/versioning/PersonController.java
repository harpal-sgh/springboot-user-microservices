package com.cde.rest.services.restservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {
	
	@GetMapping("v1/person")
	public PersonV1 personV1() {
		 return new PersonV1("Harpal Singh");
	}

	@GetMapping("v2/person")
	public PersonV2 personV2() {
		 return new PersonV2(new Name("Harpal", "Singh"));
	}
	
	
	@GetMapping(value = "/person/produces", produces="application/cde.company.app-v1+json")
	public PersonV1 producesV1() {
		 return new PersonV1("Harpal Singh");
	}

	@GetMapping(value = "/person/produces", produces="application/cde.company.app-v2")
	public PersonV2 producesV2() {
		 return new PersonV2(new Name("Harpal", "Singh"));
	}
}
