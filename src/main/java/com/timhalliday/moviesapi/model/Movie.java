package com.timhalliday.moviesapi.model;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Entity
@Table(name="movie")
@Data public class Movie {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "title", nullable = false)
	@NotEmpty(message = "Movie must have a title")
	private String title;
	
	@Column(name = "genre")
	private String genre;
	
	@Column(name = "director")
	private String director;
	
	@Column(name = "lengthMins")
	private long lengthMins;
	
	@Min(value=1, message="Rating must be an integer between 1-10")
	@Max(value=10, message="Rating must be an integer between 1-10")
	@Column(name = "myRating")
	private int myRating;
	
	@Column(name = "year")
	@Digits(integer=4, fraction=0, message="Must be a valid 4 digit year")
	@Min(value=1900, message="Year must be after 1900")
	private int year;

	
}
