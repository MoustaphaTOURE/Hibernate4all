package com.hibernate4all.tutorial.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

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
public class RepositoryTest {
	
	
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
		repository.merge(movie);
	}

}
