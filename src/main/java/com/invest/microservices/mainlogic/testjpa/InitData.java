package com.invest.microservices.mainlogic.testjpa;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;


@Component
public class InitData implements ApplicationRunner {

	private PersonRepo personRepo;

	private static final DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

	@Autowired
	public InitData(PersonRepo personRepo) {
		this.personRepo = personRepo;
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		long count = personRepo.count();

		if (count == 0) {
			Person p1 = new Person();

			p1.setFullName("Nhut Pham");
			Date d1 = df.parse("1980-12-20");
			p1.setDateOfBirth(d1);
			
			Person p2 = new Person();
			p2.setFullName("Tan Nguyen");
			Date d2 = df.parse("1985-11-11");
			p2.setDateOfBirth(d2);

			personRepo.save(p1);
			personRepo.save(p2);
		}

	}

}