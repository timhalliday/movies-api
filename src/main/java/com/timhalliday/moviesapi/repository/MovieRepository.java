package com.timhalliday.moviesapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.timhalliday.moviesapi.model.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long>  {
	
	@Query(value = "SELECT * FROM movie WHERE title = ?1", nativeQuery = true)
	List<Movie> getMoviesByName(String movieName);
}
 