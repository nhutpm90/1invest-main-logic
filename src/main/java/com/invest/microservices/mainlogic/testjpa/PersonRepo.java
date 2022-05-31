package com.invest.microservices.mainlogic.testjpa;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PersonRepo extends CrudRepository<Person, Long> {

	public List<Person> findByFullNameLike(String name);

	public List<Person> findByDateOfBirthGreaterThan(Date date);

}