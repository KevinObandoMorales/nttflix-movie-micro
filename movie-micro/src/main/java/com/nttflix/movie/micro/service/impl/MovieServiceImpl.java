package com.nttflix.movie.micro.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttflix.movie.micro.entity.MovieData;
import com.nttflix.movie.micro.repository.MovieRepository;
import com.nttflix.movie.micro.service.MovieService;

@Service
public class MovieServiceImpl implements MovieService{
	
	@Autowired
	private MovieRepository movieRepository;
	
	@Override
	public MovieData createMovie(MovieData movie) {
		return movieRepository.save(movie);
	}

	@Override
	public Optional<MovieData> getMovieById(long number) {
		return movieRepository.findById(number);
	}

	@Override
	public MovieData updateMovie(MovieData movie) {
		return movieRepository.save(movie);
	}

	@Override
	public void deleteMovie(Long id) {		
		movieRepository.deleteById(id);	
		// TODO Auto-generated method stub	
	}

	@Override
	public List<MovieData> getAllMovies() {
		return movieRepository.findAll();
	}
	
	@Override
	public List<MovieData> getMoviesByMAC(String mac){
		return movieRepository.getMoviesMAC(mac);
	}
	
}
