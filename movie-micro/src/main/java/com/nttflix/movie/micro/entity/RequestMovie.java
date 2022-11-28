package com.nttflix.movie.micro.entity;

public class RequestMovie {
	
	private MovieData movieData;

	public RequestMovie() {
	}

	public RequestMovie(MovieData movieData) {
		this.movieData = movieData;
	}

	public MovieData getMovieData() {
		return movieData;
	}

	public void setMovieData(MovieData movieData) {
		this.movieData = movieData;
	}
	
}
