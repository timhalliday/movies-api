package com.timhalliday.moviesapi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="movie")
@Data
public class Movie {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "title", nullable = false)
	private String title;
	
	@Column(name = "genre")
	private String genre;
	
	@Column(name = "director")
	private String director;
	
	@Column(name = "lengthMins")
	private long lengthMins;
	
	@Column(name = "myRating")
	private int myRating;
	
	@Column(name = "year")
	private int year;

	
}
