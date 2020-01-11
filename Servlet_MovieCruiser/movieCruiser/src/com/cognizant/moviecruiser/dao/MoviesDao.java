package com.cognizant.moviecruiser.dao;

import com.cognizant.moviecruiser.model.Movies;
import java.util.List;

public interface MoviesDao {

	public List<Movies> getMoviesListAdmin();

	public List<Movies> getMoviesListCustomer();

	public void modifyMovies(Movies movies);

	public Movies getMovies(Long moviesId);

}
