package com.abe.learn.services;

import com.abe.learn.model.Person;

public interface PersonsServices {

	public Person getPerson(int id);
	
	public Person addPerson(Person p);
}
