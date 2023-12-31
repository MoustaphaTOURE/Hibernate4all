package com.hibernate4all.tutorial.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.hibernate.LazyInitializationException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
public class RepositoryTest {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(RepositoryTest.class);
	
	@Autowired
	private MovieRepository repository;
	
	@Test
	public void save_casNominal() {
		final Movie movie = new Movie();
		movie.setName("Inception");
		repository.persist(movie);
	}
	
	@Test
	public void find_casNominal() {
		final Movie foundedEntity = repository.find(-2L);
		assertEquals("bad retrieved film", foundedEntity.getName(), "Film 2");
	}
	
	@Test
	public void getAll_casNominal() {
		final List<Movie> foundedEntities = repository.getAll();
		assertEquals(foundedEntities.size(), 2, "bad size of all entities");
	}
	
	@Test
	public void merge_casNominal() {
		final Movie movie = new Movie();
		movie.setId(-2L);
		movie.setName("Inception 2");
		
		// send select request to DB then comparing old&DB data for updating 
		repository.merge(movie);
	}
	
	@Test
	public void getReference_casNominal() {
		assertThrows(LazyInitializationException.class, ()->{
			final Movie reference = repository.getReference(-2L);
			
			// Send select request to DB while session is closed
			LOGGER.trace("id={} - name={}", reference.getId(), reference.getName()); 
		});
	}

}
