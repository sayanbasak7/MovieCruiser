package com.cognizant.moviecruiser.dao;

import com.cognizant.moviecruiser.model.Favorites;

public interface FavoritesDao {

	public void addFavoriteMovies(long userId, long moviesId);

	public Favorites getAllFavoritesMovies(long userId) throws FavoritesEmptyExecption;

	public void removeFavouritemovies(long userId, long moviesId);

}
