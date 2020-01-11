package com.cognizant.moviecruiser.dao;

import com.cognizant.moviecruiser.model.Favorites;

public class FavoritesDaoImplTest {


	public static void testAddFavorites() throws FavoritesEmptyExecption {

		FavoritesDaoSqlImpl favaritesDaoSqlImpl = new FavoritesDaoSqlImpl();
		favaritesDaoSqlImpl .addFavoriteMovies(2L, 4L);
		// Cart cart=cartDaoSqlImpl.getAllCartItems(1);
		System.out.println("User Added  Cart List for Check");
	}

	public static void testGetAllCartItems() throws FavoritesEmptyExecption {
		long userId =2L;
		FavoritesDaoSqlImpl favoritesDaoSqlImpl = new FavoritesDaoSqlImpl();
		Favorites obj = favoritesDaoSqlImpl.getAllFavoritesMovies(userId);
		System.out.println(obj.getMovies());
		System.out.println("total favorites :"+obj.getTotal());

	}
	
	public static void testRemoveFavorites() {
		FavoritesDaoSqlImpl favoritesDaoSqlImpl = new FavoritesDaoSqlImpl();
		favoritesDaoSqlImpl.removeFavouritemovies(2L, 4L);
		System.out.println("---------");
	}

	public static void main(String[] args) throws FavoritesEmptyExecption {
		testAddFavorites();
		testGetAllCartItems();
		testRemoveFavorites();
	}

}
