package com.nttflix.movie.micro.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    public ResponseEntity<List<MovieData>> getMovies(){
		List<MovieData> listMovies = movieService.getAllMovies();
		return new ResponseEntity<>(listMovies, HttpStatus.OK);
   }
    
    @GetMapping("/api/movies/number")
    public ResponseMovie getMovie(@RequestBody RequestMovie requestScreen){
    	Long id = requestScreen.getMovieData().getId();
    	Optional<MovieData> movieData = movieService.getMovieById(id);
    	String msg = "Not found";
        if (movieData.isPresent()) {
        	msg = "Found";
        	return new ResponseMovie(msg, movieData.get());
        }
        return new ResponseMovie(msg, null);
    }
    
    
    @PostMapping("/api/movies")
    public ResponseMovie addMovies(@RequestBody RequestMovie requestScreen){
    	
    	MovieData movieDataNew = movieService.createMovie(requestScreen.getMovieData());
    	return new ResponseMovie("Se ha añadido correctamente", movieDataNew);
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
    	if (movieData.isPresent()) {
    		MovieData movieUpdated = movieService.updateMovie(requestScreen.getMovieData());
    		return new ResponseMovie("Movie updated", movieUpdated);
    	}
    	return new ResponseMovie("Movie not found", null);
   }
}
