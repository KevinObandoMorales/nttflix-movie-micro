package com.nttflix.movie.micro.service;

import java.util.List;
import java.util.Optional;

import com.nttflix.movie.micro.entity.MovieData;


public interface MovieService {
	
	public MovieData createMovie(MovieData movie);

	public Optional<MovieData> getMovieById(long movieId);

	public MovieData updateMovie(MovieData movie);

	public void deleteMovie(Long nombre);

	public List<MovieData> getAllMovies();

	public List<MovieData> getMoviesByMAC(String mac);
}
