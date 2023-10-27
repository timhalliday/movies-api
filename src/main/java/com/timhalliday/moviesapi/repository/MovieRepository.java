package com.timhalliday.moviesapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.timhalliday.moviesapi.model.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long>  {

}
