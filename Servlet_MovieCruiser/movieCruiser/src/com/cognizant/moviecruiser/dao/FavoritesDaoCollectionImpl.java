package com.cognizant.moviecruiser.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.cognizant.moviecruiser.model.Favorites;
import com.cognizant.moviecruiser.model.Movies;

public class FavoritesDaoCollectionImpl implements FavoritesDao {

	private static HashMap<Long, Favorites> userFavorites;

	public FavoritesDaoCollectionImpl() {
		super();
		if (userFavorites == null) {
			userFavorites = new HashMap<>();
		}
	}

	@Override
	public void addFavoriteMovies(long userId, long moviesId) {
		MoviesDao moviesDao = new MoviesDaoCollectionImpl();
		Movies movies = moviesDao.getMovies(moviesId);
		if (userFavorites.containsKey(userId)) {
			userFavorites.get(userId).getMovies().add(movies);

		} else {
			Favorites favorites = new Favorites();
			ArrayList<Movies> moviesList = new ArrayList<>();
			moviesList.add(movies);
			favorites.setMovies(moviesList);
			userFavorites.put(userId, favorites);
		}

	}

	@Override
	public Favorites getAllFavoritesMovies(long userId) throws FavoritesEmptyExecption {
		Favorites favorites = userFavorites.get(userId);
		if (favorites == null || favorites.getMovies().isEmpty()) {
			throw new FavoritesEmptyExecption();
		}
		favorites.setTotal(favorites.getMovies().size());
		return favorites;
	}

	@Override
	public void removeFavouritemovies(long userId, long moviesId) {
		List<Movies> moviesList = userFavorites.get(userId).getMovies();
		for (int i = 0; i < moviesList.size(); i++) {
			if (moviesList.get(i).getId() == moviesId) {
				moviesList.remove(i);
				return;
			}
		}
	}

}
