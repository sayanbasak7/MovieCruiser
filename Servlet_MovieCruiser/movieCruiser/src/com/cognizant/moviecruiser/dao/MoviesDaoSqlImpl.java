package com.cognizant.moviecruiser.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cognizant.moviecruiser.model.Movies;
import com.cognizant.moviecruiser.util.DateUtil;

public class MoviesDaoSqlImpl implements MoviesDao {

	public static final String MOVIE_DETAILS = "select  mo_id, mo_title, mo_box_office,mo_active, mo_date_of_launch, mo_genre, mo_has_teaser from movies";
	public static final String MOVIE_LIST_CUSTOMER="select  mo_id, mo_title, mo_box_office,mo_active, mo_date_of_launch, mo_genre, mo_has_teaser from movies where mo_active='1' and mo_date_of_launch>(select curdate())";
	public static final String SELECT_MOVIES = "select  mo_id, mo_title, mo_box_office,mo_active, mo_date_of_launch, mo_genre, mo_has_teaser from movies where mo_id=?";
	public static final String UPDATE_MOVIES = "update movies set mo_title=?,mo_box_office=?,mo_active=?,mo_date_of_launch=?,mo_genre=?,mo_has_teaser=? where mo_id=?";

	@Override
	public ArrayList<Movies> getMoviesListAdmin() {
		ArrayList<Movies> movieList = new ArrayList<>();
		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement preparedstatement = null;
		ResultSet resultSet = null;
		try {
			preparedstatement = connection.prepareStatement(MOVIE_DETAILS);
			resultSet = preparedstatement.executeQuery();
			while (resultSet.next()) {
				Movies movies = new Movies();
				movies.setId(resultSet.getLong("mo_id"));
				movies.setTitle(resultSet.getString("mo_title"));
				movies.setGross(resultSet.getLong("mo_box_office"));
				movies.setActive(resultSet.getString("mo_active").equals("1"));
				movies.setDateOfLaunch(resultSet.getDate("mo_date_of_launch"));
				movies.setGenre(resultSet.getString("mo_genre"));
				movies.setHasTeaser(resultSet.getString("mo_has_teaser").equals("1"));
				movieList.add(movies);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
				if (preparedstatement != null)
					preparedstatement.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {

			}
		}
		return movieList;
	}

	@Override
	public List<Movies> getMoviesListCustomer() {
		ArrayList<Movies> movieList = new ArrayList<>();
		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement preparedstatement = null;
		ResultSet resultSet = null;
		try {
			preparedstatement = connection.prepareStatement(MOVIE_LIST_CUSTOMER);
			resultSet = preparedstatement.executeQuery();
			while (resultSet.next()) {
				Movies movies = new Movies();
				movies.setId(resultSet.getLong("mo_id"));
				movies.setTitle(resultSet.getString("mo_title"));
				movies.setGross(resultSet.getLong("mo_box_office"));
				movies.setActive(resultSet.getString("mo_active").equals("1"));
				movies.setDateOfLaunch(resultSet.getDate("mo_date_of_launch"));
				movies.setGenre(resultSet.getString("mo_genre"));
				movies.setHasTeaser(resultSet.getString("mo_has_teaser").equals("1"));
				movieList.add(movies);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
				if (preparedstatement != null)
					preparedstatement.close();
				if (connection != null)
					connection.close();

			} catch (SQLException e) {

			}
		}
		return movieList;
	}

	@Override
	public void modifyMovies(Movies movies) {
		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement preparedstatement = null;
		try {
			preparedstatement = connection.prepareStatement(UPDATE_MOVIES);
			preparedstatement.setString(1, movies.getTitle());
			preparedstatement.setLong(2, movies.getGross());
			preparedstatement.setBoolean(3, movies.getActive());
			preparedstatement.setDate(4, DateUtil.convertToSqlDate(movies.getDateOfLaunch()));
			preparedstatement.setString(5, movies.getGenre());
			preparedstatement.setBoolean(6, movies.getHasTeaser());
			preparedstatement.setLong(7, movies.getId());
			int noOfRows = preparedstatement.executeUpdate();
			if (noOfRows > 0) {
				System.out.println("\n\nUpdate Successfully!!");

			} else {
				System.out.println("\n\nNOT Updated");
			}
		} catch (SQLException e) {
			System.out.println("\n\nUpdate Not Done");

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
	public Movies getMovies(Long moviesId) {
		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement preparedstatement = null;
		ResultSet resultSet = null;
		Movies movies = null;
		try {
			preparedstatement = connection.prepareStatement(SELECT_MOVIES);
			preparedstatement.setLong(1, moviesId);
			resultSet = preparedstatement.executeQuery();
			while (resultSet.next()) {
				movies = new Movies();
				movies.setId(resultSet.getLong("mo_id"));
				movies.setTitle(resultSet.getString("mo_title"));
				movies.setGross(resultSet.getLong("mo_box_office"));
				movies.setActive(resultSet.getString("mo_active").equals("1"));
				movies.setDateOfLaunch(resultSet.getDate("mo_date_of_launch"));
				movies.setGenre(resultSet.getString("mo_genre"));
				movies.setHasTeaser(resultSet.getString("mo_has_teaser").equals("1"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
				if (preparedstatement != null)
					preparedstatement.close();
				if (connection != null)
					connection.close();

			} catch (SQLException e) {

			}
		}
		return movies;
	}
}