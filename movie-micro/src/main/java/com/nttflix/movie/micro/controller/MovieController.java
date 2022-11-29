package com.nttflix.movie.micro.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nttflix.movie.micro.entity.MovieData;
import com.nttflix.movie.micro.entity.RequestMovie;
import com.nttflix.movie.micro.entity.ResponseMovie;
import com.nttflix.movie.micro.service.MovieService;

@RestController
public class MovieController {
	
	@Autowired
	private MovieService movieService;
	

	@GetMapping("/api/movies")
    public ResponseMovie getMovies(){	
		List<MovieData> listMovies = movieService.getAllMovies();
		String msg = "Movies found";
		return new ResponseMovie(msg, listMovies);
   }
    
    @GetMapping("/api/movies/number")
    public ResponseMovie getMovie(@RequestBody RequestMovie requestScreen){
    	String macNumber = requestScreen.getMovieData().getMac();
    	List<MovieData> listMovies = movieService.getMoviesByMAC(macNumber);
    	String msg = "Movies by MAC: " + macNumber;
    	
        return new ResponseMovie(msg, listMovies);
    }
    
    
    @PostMapping("/api/movies")
    public ResponseMovie addMovies(@RequestBody RequestMovie requestScreen){
    	MovieData movieDataNew = movieService.createMovie(requestScreen.getMovieData());
    	String msg = "Se ha añadido correctamente";
    	return new ResponseMovie(msg, movieDataNew);
   }
    
    
    @DeleteMapping("/api/movies")
    public ResponseMovie deleteMovies(@RequestBody RequestMovie requestScreen){	
    	Long id = requestScreen.getMovieData().getId();
    	Optional<MovieData> movieData = movieService.getMovieById(id);
    	String msg = "Not found";
        
    	if (movieData.isPresent()) {
        	msg = "Movie deleted";
        	movieService.deleteMovie(id);
        	return new ResponseMovie(msg, movieData.get());
        }
        return new ResponseMovie(msg, null);
   }
    
    @PutMapping("/api/movies")
    public ResponseMovie editMovies(@RequestBody RequestMovie requestScreen){
    	Long id = requestScreen.getMovieData().getId();
    	Optional<MovieData> movieData = movieService.getMovieById(id);
    	String msg = "Movie not found";
    	
    	if (movieData.isPresent()) {
    		msg = "Movie updated";
    		MovieData movieUpdated = movieService.updateMovie(requestScreen.getMovieData());
    		return new ResponseMovie(msg, movieUpdated);
    	}
    	return new ResponseMovie(msg, null);
   }
}
