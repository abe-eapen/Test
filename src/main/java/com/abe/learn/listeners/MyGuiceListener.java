package com.abe.learn.listeners;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.abe.learn.dao.PersonsDao;
import com.abe.learn.dao.PersonsDaoImpl;
import com.abe.learn.services.PersonsServices;
import com.abe.learn.services.PersonsServicesImpl;
import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.servlet.GuiceServletContextListener;
import com.sun.jersey.guice.JerseyServletModule;
import com.sun.jersey.guice.spi.container.servlet.GuiceContainer;

public class MyGuiceListener extends GuiceServletContextListener {

	@Override
	protected Injector getInjector() {
		List<Module> modules = new ArrayList<>();

		modules.add(new JerseyServletModule() {

			@Override
			protected void configureServlets() {

				Map<String, String> params = new HashMap<>();
				params.put("com.sun.jersey.config.property.packages", "com.abe.learn.resouces");

				serve("/rest/*").with(GuiceContainer.class, params);

			}
		});

		modules.add(new AbstractModule() {

			@Override
			protected void configure() {
				bind(PersonsServices.class).to(PersonsServicesImpl.class);
				bind(PersonsDao.class).to(PersonsDaoImpl.class);

			}
		});

		Injector injector = Guice.createInjector(modules);
		return injector;
	}

}
