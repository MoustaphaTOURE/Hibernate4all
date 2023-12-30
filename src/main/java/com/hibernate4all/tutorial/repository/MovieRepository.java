package com.hibernate4all.tutorial.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.hibernate4all.tutorial.domain.Movie;

@Repository
public class MovieRepository {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(MovieRepository.class);
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Transactional
	public void persist(final Movie movie) {
		LOGGER.trace("entityManager.contains(movie) : " + entityManager.contains(movie));
		entityManager.persist(movie);
		LOGGER.trace("entityManager.contains(movie) : " + entityManager.contains(movie));
	}
	
	public Movie find(final Long id) {
		return entityManager.find(Movie.class, id);
	}
	
	public List<Movie> getAll() {
		return entityManager.createQuery("From Movie", Movie.class).getResultList();
	}
	
	@Transactional
	public void merge(final Movie movie) {
		 entityManager.merge(movie);
	}
}
