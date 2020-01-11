package com.cognizant.moviecruiser.model;

import java.util.List;

public class Favorites {
	
	private List<Movies> moviesList;
	private long total;

	public Favorites() {
		super();
	}

	public Favorites(List<Movies> movies, long total) {
		super();
		this.moviesList = movies;
		this.total = total;
	}

	public List<Movies> getMovies() {
		return moviesList;
	}

	public void setMovies(List<Movies> movies) {
		this.moviesList = movies;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "Favorites [movies=" + moviesList + ", total=" + total + "]";
	}

}