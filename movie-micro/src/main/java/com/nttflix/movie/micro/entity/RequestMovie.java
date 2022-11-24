package com.nttflix.movie.micro.entity;

public class RequestMovie {
	
	private MovieData movieData;

	public RequestMovie() {
		super();
	}

	public RequestMovie(MovieData movieData) {
		super();
		this.movieData = movieData;
	}

	public MovieData getMovieData() {
		return movieData;
	}

	public void setMovieData(MovieData movieData) {
		this.movieData = movieData;
	}
	
}
