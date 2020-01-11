package com.cognizant.moviecruiser.dao;

import com.cognizant.moviecruiser.model.Favorites;

public class FavoritesDaoSqlImplTest {

     public static void testAddFavoriteMovies() throws FavoritesEmptyExecption {
          FavoritesDaoSqlImpl favoritesDaoSqlImpl = new FavoritesDaoSqlImpl();
          favoritesDaoSqlImpl.addFavoriteMovies(1L, 5);
          System.out.println("\n\nMovies added to Favorites successfully\n\n");
     }

     public static void testRemoveFavoriteMovies() {
          FavoritesDaoSqlImpl favoritesDaoSqlImpl = new FavoritesDaoSqlImpl();
          favoritesDaoSqlImpl.removeFavouritemovies(1L, 5);
          System.out.println("\n\nMovie removed from favorites");
     }

     public static void testGetAllFavoriteMovies() throws FavoritesEmptyExecption {
          FavoritesDaoSqlImpl favoriteDaoSqlImpl = new FavoritesDaoSqlImpl();
          Favorites favorites = favoriteDaoSqlImpl.getAllFavoritesMovies(1L);
          System.out.println(favorites.getMovies());
          System.out.println("\n\nTotal number of movies= " + favorites.getTotal());
     }

     public static void main(String args[]) throws FavoritesEmptyExecption {
          testAddFavoriteMovies();
          testRemoveFavoriteMovies();
          testGetAllFavoriteMovies();
     }
}