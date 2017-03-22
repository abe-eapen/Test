package com.abe.learn.services;

import com.abe.learn.dao.PersonsDao;
import com.abe.learn.model.Person;
import com.google.inject.Inject;

//test comment
public class PersonsServicesImpl implements PersonsServices {

	@Inject
	private PersonsDao dao;

	public Person getPerson(int id) {
		return dao.getPerson(id);

	}

	public Person addPerson(Person p) {
		return dao.addPerson(p);
	}
}
