package com.nttflix.movie.micro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nttflix.movie.micro.entity.MovieData;

@Repository
public interface MovieRepository extends JpaRepository<MovieData, Long> {
	
}
