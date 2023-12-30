package com.hibernate4all.tutorial.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.hibernate4all.tutorial.config.PersistenceConfig;
import com.hibernate4all.tutorial.domain.Movie;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {PersistenceConfig.class})
@SqlConfig
@Sql(scripts = {"/datas/datas-test.sql"})
public class MovieServiceTest {
	
	@Autowired
	private MovieService toTest;
	
	@Test
	public void updateDescription_casNominal() {
		final Movie updateDescription = toTest.updateDescription(-2L, "updated Film name");
		assertEquals("updated Film name", updateDescription.getDescription(),"Entity description is not updated");
	}

}
