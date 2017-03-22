package com.abe.learn.dao;

import com.abe.learn.model.Person;

public interface PersonsDao {

	public Person getPerson(int id);
	
	public Person addPerson(Person p);
}
