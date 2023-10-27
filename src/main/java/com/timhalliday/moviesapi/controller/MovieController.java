package com.timhalliday.moviesapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.timhalliday.moviesapi.model.Movie;
import com.timhalliday.moviesapi.service.MovieService;

@RestController // (Automatically serialises return objects into a HttpResponse)
public class MovieController {
		
	@Autowired
	private MovieService movieService; 
	
	// insert new movie into DB
	@PostMapping("/movie")
	public ResponseEntity<Movie> saveMovie(@RequestBody Movie movie){
		Movie savedMovie = movieService.saveMovie(movie);
		return new ResponseEntity<>(savedMovie, HttpStatus.CREATED);
	}
	
	// get a single product by ID
	public ResponseEntity<Movie> getMovie(@RequestParam(name="movieId") long movieId) {
		Movie movie = movieService.getMovie(movieId);
		return new ResponseEntity<>(movie, HttpStatus.OK);
	}
	
	// get all products
	public List<Movie> getMovies() {
		return movieService.getMovies();
	}
	
	// update existing item
	
	// delete item in database
	
	// get movie by using a raw SQL statement
}
