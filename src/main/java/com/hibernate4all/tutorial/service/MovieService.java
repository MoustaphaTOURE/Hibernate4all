package com.hibernate4all.tutorial.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hibernate4all.tutorial.domain.Movie;
import com.hibernate4all.tutorial.repository.MovieRepository;

@Service
public class MovieService {
	
	@Autowired
	private MovieRepository repository;
	
	@Transactional
	public Movie updateDescription(final Long id,final String description) {
		final Movie findedEntity = repository.find(id);
		findedEntity.setDescription(description);
		return findedEntity;
	}

}
