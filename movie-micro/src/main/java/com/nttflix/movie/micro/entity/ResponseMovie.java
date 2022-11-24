package com.nttflix.movie.micro.entity;

public class ResponseMovie {
	private String message;
	private MovieData movieData;
	public ResponseMovie() {
		super();
	}
	public ResponseMovie(String message, MovieData movieData) {
		super();
		this.message = message;
		this.movieData = movieData;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public MovieData getMovieData() {
		return movieData;
	}
	public void setMovieData(MovieData movieData) {
		this.movieData = movieData;
	}
	
	
}
