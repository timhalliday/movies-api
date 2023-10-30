package com.timhalliday.moviesapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
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
	
	// get a single movie by ID
	@GetMapping("/movie")
	public ResponseEntity<Movie> getMovie(@RequestParam(name="movieId") long movieId) {
		Movie movie = movieService.getMovie(movieId);
		return new ResponseEntity<>(movie, HttpStatus.OK);
	}
	
	// get all movies
	@GetMapping("/movies")
	public List<Movie> getMovies() {
		return movieService.getMovies();
	}
	
	// update existing item
	@PatchMapping("/movie")
	public ResponseEntity<Movie> updateMovie(@RequestParam(name = "movieId") long movieId, @RequestBody Movie movie) {
		Movie updatedMovie = movieService.updateMovie(movieId, movie);
		return new ResponseEntity<>(updatedMovie, HttpStatus.OK);
	}
	
	// delete item in database
	@DeleteMapping("/movie")
	public ResponseEntity<Movie> deleteMovie(@RequestParam(name = "movieId") long movieId) { 
		Movie deletedMovie = movieService.deleteMovie(movieId);
		return new ResponseEntity<>(deletedMovie, HttpStatus.OK);
	}
	
	// get movie by name using a raw SQL statement
	@GetMapping("/movies-by-name")
	public List<Movie> getMoviesByName(@RequestParam(name="movieName") String movieName){
		return movieService.getMoviesByName(movieName);
	} 
	
}
