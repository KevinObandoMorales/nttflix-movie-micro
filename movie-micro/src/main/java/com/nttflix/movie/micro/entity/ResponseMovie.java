package com.nttflix.movie.micro.entity;

public class ResponseMovie {
	private String message;
	private Object movieData;
	
	public ResponseMovie() {
		super();
	}
	
	
	public ResponseMovie(Object movieData) {
		super();
		this.movieData = movieData;
	}


	public ResponseMovie(String message, Object movieData) {
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
	public Object getMovieData() {
		return movieData;
	}
	public void setMovieData(Object movieData) {
		this.movieData = movieData;
	}
	
}
