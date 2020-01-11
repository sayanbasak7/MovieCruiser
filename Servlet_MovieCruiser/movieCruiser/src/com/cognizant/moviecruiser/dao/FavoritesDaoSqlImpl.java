package com.cognizant.moviecruiser.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.cognizant.moviecruiser.model.Favorites;
import com.cognizant.moviecruiser.model.Movies;

public class FavoritesDaoSqlImpl implements FavoritesDao {

	public static final String ADD_MOVIES_TO_FAVORITES = "insert into favorites(ft_us_id,ft_mo_id) values (?,?)";
	public static final String REMOVE_FAVORITES = "delete from  favorites where ft_us_id=? and ft_mo_id=? limit 1";
	public static final String GET_ALL_FAVORITES = "select mo_id, mo_title, mo_box_office,mo_active, mo_date_of_launch, mo_genre, mo_has_teaser from movies inner join favorites as Favorites on ft_mo_id=mo_id where ft_us_id=?";
	public static final String GET_TOTAL_FAVORITES = "select count(mo_id) as Total_favorites from movies inner join favorites on ft_mo_id=mo_id where ft_us_id=?";

	@Override
	public void addFavoriteMovies(long userId, long moviesId) {

		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement preparedstatement = null;
		try {
			preparedstatement = connection.prepareStatement(ADD_MOVIES_TO_FAVORITES);
			preparedstatement.setLong(1, userId);
			preparedstatement.setLong(2, moviesId);
			preparedstatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (preparedstatement != null)
					preparedstatement.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {

			}
		}
	}

	@Override
	public Favorites getAllFavoritesMovies(long userId) throws FavoritesEmptyExecption {

		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement preparedstatement = null;
		ArrayList<Movies> movieList = new ArrayList<Movies>();
		PreparedStatement preparedStatementTotal = null;
		ResultSet resultSetList = null;
		ResultSet resultSetTotal = null;
		Favorites favorites = new Favorites();
		try {
			preparedstatement = connection.prepareStatement(GET_ALL_FAVORITES);
			preparedstatement.setLong(1, userId);
			resultSetList = preparedstatement.executeQuery();
			while (resultSetList.next()) {
				Movies movies = new Movies();
				movies.setId(resultSetList.getLong("mo_id"));
				movies.setTitle(resultSetList.getString("mo_title"));
				movies.setGross(resultSetList.getLong("mo_box_office"));
				movies.setActive(resultSetList.getString("mo_active").equals("1"));
				movies.setDateOfLaunch(resultSetList.getDate("mo_date_of_launch"));
				movies.setGenre(resultSetList.getString("mo_genre"));
				movies.setHasTeaser(resultSetList.getString("mo_has_teaser").equals("1"));
				movieList.add(movies);
			}
			preparedStatementTotal = connection.prepareStatement(GET_TOTAL_FAVORITES);
			preparedStatementTotal.setLong(1, userId);
			resultSetTotal = preparedStatementTotal.executeQuery();
			while (resultSetTotal.next()) {
				favorites.setTotal((resultSetTotal.getInt("Total_favorites")));
			}

			if (movieList.size() == 0) {
				throw new FavoritesEmptyExecption();
			}
			favorites.setMovies(movieList);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (preparedstatement != null)
					preparedstatement.close();
				if (preparedStatementTotal != null)
					preparedStatementTotal.close();
				if (resultSetList != null)
					resultSetList.close();
				if (resultSetTotal != null)
					resultSetList.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {

			}
		}
		return favorites;

	}

	@Override
	public void removeFavouritemovies(long userId, long moviesId) {
		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement preparedstatement = null;
		try {
			preparedstatement = connection.prepareStatement(REMOVE_FAVORITES);
			preparedstatement.setLong(1, userId);
			preparedstatement.setLong(2, moviesId);
			int noOfRows = preparedstatement.executeUpdate();
			System.out.println("rows affected\t" + noOfRows);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (preparedstatement != null)
					preparedstatement.close();
				if (connection != null)
					connection.close();

			} catch (SQLException e) {

			}

		}
	}

}
