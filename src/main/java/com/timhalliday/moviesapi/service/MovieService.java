package com.timhalliday.moviesapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.timhalliday.moviesapi.model.Movie;
import com.timhalliday.moviesapi.repository.MovieRepository;

public class MovieService {
	
	@Autowired 
	private MovieRepository movieRepository;
	
	 
	public Movie saveMovie(Movie movie) {
		return movieRepository.save(movie);
	}
	
	public Movie getMovie(long movieId) {
		return movieRepository.findById(movieId).orElseThrow(() -> new RuntimeException("Movie not found"));
	}

	public List<Movie> getMovies() {
		return movieRepository.findAll();
	}
}
