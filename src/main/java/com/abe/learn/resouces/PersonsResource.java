package com.abe.learn.resouces;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.abe.learn.model.Person;
import com.abe.learn.services.PersonsServices;
import com.google.inject.Inject;

@Path("/persons")
public class PersonsResource {
	
	@Inject
	PersonsServices service;

	@GET
	@Path("/{param}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Person getPerson(@PathParam("param") int id){
		return service.getPerson(id);
		
	}
	
	@POST
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Person savePerson(Person p){
		return service.addPerson(p);
		
	}
}
