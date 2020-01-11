package com.cognizant.moviecruiser.dao;

import com.cognizant.moviecruiser.model.Favorites;
import com.cognizant.moviecruiser.model.Movies;

public class FavoritesDaoCollectionImplTest {

	public static void testAddFavorites() throws FavoritesEmptyExecption {
		FavoritesDao favoriteDao = new FavoritesDaoCollectionImpl();
		favoriteDao.addFavoriteMovies(1, 2L);
		favoriteDao.addFavoriteMovies(1, 4L);
		favoriteDao.addFavoriteMovies(1, 3L);
		favoriteDao.addFavoriteMovies(2, 1L);
		favoriteDao.addFavoriteMovies(2, 5L);
		Favorites favorites = favoriteDao.getAllFavoritesMovies(1);
		System.out.println("User Added Favorite List for Checkout\n");
		for (Movies movies : favorites.getMovies()) {
			System.out.println(movies);
		}
		System.out.print("\nTotal favorites\t");
		// System.out.println(movieListCustomer.size());
	}

	public static void testRemoveFavorite() throws FavoritesEmptyExecption {
		FavoritesDao favoriteDao = new FavoritesDaoCollectionImpl();
		try {
			favoriteDao.removeFavouritemovies(1, 2L);
			favoriteDao.removeFavouritemovies(1, 4L);
			favoriteDao.removeFavouritemovies(2, 1L);

			Favorites favorites = favoriteDao.getAllFavoritesMovies(1);
			System.out.println("\n\nItems Afer deleting\n");
			for (Movies movies : favorites.getMovies()) {
				System.out.println(movies);
			}
			System.out.print("\nTotal favorites\t");
			// System.out.println(movieListCustomer.size());
		} catch (FavoritesEmptyExecption e) {
			System.out.println(e.getMessage());
		}
	}

	public static void testGetAllFavoriteItem() {

	}

	public static void main(String[] args) throws FavoritesEmptyExecption {
		testAddFavorites();
		testRemoveFavorite();
	}

}
