package com.hibernate4all.tutoriel.repository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.hibernate4all.tutorial.domain.Movie;
import com.hibernate4all.tutorial.repository.MovieRepository;
import com.hibernate4all.tutoriel.config.PersistenceConfig;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {PersistenceConfig.class})
public class RepositoryTest {
	
	
	@Autowired
	private MovieRepository repository;
	
	@Test
	public void save_casNominal() {
		final Movie movie = new Movie();
		movie.setName("Inception");
		repository.persist(movie);
	}

}
