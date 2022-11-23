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
    
    @GetMapping("/api/movies/{number}")
    public ResponseEntity<MovieData> getMovie(@PathVariable("number") long number){
    	Optional<MovieData> movieData = movieService.getMovieById(number);
        if (movieData.isPresent()) {
        	return new ResponseEntity<>(movieData.get(), HttpStatus.OK);
         }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
    
    
    @PostMapping("/api/movies")
    public ResponseEntity<MovieData> addMovies(@RequestBody MovieData movieData){
    	MovieData movieDataNew = movieService.createMovie(movieData);
    	return new ResponseEntity<>(movieDataNew, HttpStatus.OK);
   }
    
    
    @DeleteMapping("/api/movies")
    public ResponseEntity<MovieData> deleteMovies(){
        return null;

   }
    
    @PutMapping("/api/movies")
    public ResponseEntity<MovieData> editMovies(){
        return null;
   }
}
