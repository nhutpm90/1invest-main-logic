package com.invest.microservices.mainlogic.testjpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class PersonApi {

	@Autowired
	private PersonRepo personRepo;

	@ResponseBody
	@RequestMapping("/persons")
	public String persons() {
		Iterable<Person> all = personRepo.findAll();

		StringBuilder sb = new StringBuilder();

		all.forEach(p -> sb.append(p.getFullName() + "<br>"));

		return sb.toString();
	}
}
