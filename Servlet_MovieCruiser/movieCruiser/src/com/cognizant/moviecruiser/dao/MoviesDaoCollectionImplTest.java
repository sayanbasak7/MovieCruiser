package com.cognizant.moviecruiser.dao;

import java.util.List;

import com.cognizant.moviecruiser.model.Movies;
import com.cognizant.moviecruiser.util.DateUtil;

public class MoviesDaoCollectionImplTest {

	public static void testGetMoviesListAdmin() {
		System.out.println("Item list for Admin");
		MoviesDao moviesDao = new MoviesDaoCollectionImpl();
		List<Movies> moviesList = moviesDao.getMoviesListAdmin();
		for (Movies movies : moviesList) {
			System.out.println(movies);
		}
	}

	public static void testGetMoviesListCustomer() {
		System.out.println("\n\nItem List for Customer");
		MoviesDao moviesDao = new MoviesDaoCollectionImpl();
		List<Movies> movieList = moviesDao.getMoviesListCustomer();
		for (Movies movies : movieList) {
			System.out.println(movies);
		}
	}

	public static void testModifyMovies() {
		Movies item = new Movies(5L, "The GodFather", 3000000000L, true, new DateUtil().convertToDate("14/03/1972"),
				"Drama", false);
		MoviesDao moviesDao = new MoviesDaoCollectionImpl();
		moviesDao.modifyMovies(item);
		System.out.println("\n\n***Modified Movie List***");
		testGetMoviesListAdmin();
		Movies modified_list = moviesDao.getMovies(item.getId());
		System.out.println("\n\nModified movie list\n" + modified_list);
	}

	public static void main(String[] args) {
		testGetMoviesListAdmin();
		testGetMoviesListCustomer();
		testModifyMovies();
	}

}