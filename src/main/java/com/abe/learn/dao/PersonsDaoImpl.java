package com.abe.learn.dao;

import java.util.HashMap;

import com.abe.learn.model.Person;

public class PersonsDaoImpl implements PersonsDao {

	public static HashMap<Integer, Person> personMap = new HashMap<>();

	{
		Person p = new Person();
		p.setId(1);
		p.setName("John");
		personMap.put(p.getId(), p);
	}

	public Person getPerson(int id) {
		return personMap.get(id);

	}

	public Person addPerson(Person p) {
		personMap.put(p.getId(), p);
		return p;
	}
}
