package com.cognizant.moviecruiser.dao;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import com.cognizant.moviecruiser.model.Movies;
import com.cognizant.moviecruiser.util.DateUtil;

public class MoviesDaoSqlImplTest {

	/*ADMIN LIST*/
	public static void testGetMoviesListAdmin() {
		String active,hasTeaser;
		System.out.println("MOVIE LIST FOR ADMIN");
		MoviesDao moviesDao=new MoviesDaoSqlImpl();
		List<Movies> movieList=moviesDao.getMoviesListAdmin();
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
		System.out.format("\n%15s%15s%15s%15s%15s%15s%15s","ID","TITLE","GROSS","ACTIVE",
							"DATE OF LAUNCH","GENRE","HAS TEASER");
		for (Movies movies : movieList) {
			if(movies.getActive()==true) {
				active="YES";
			}else {
				active="NO";
			}
			if (movies.getHasTeaser()==true) {
				hasTeaser="YES";
			}else {
				hasTeaser="NO";
			}
			System.out.format("\n%15s%15s%15s%15s%15s%15s%15s",movies.getId(),movies.getTitle(),
								movies.getGross(),active,sdf.format(movies.getDateOfLaunch()),movies.getGenre(),hasTeaser);
		}
	}
	
	/*MODIFY MOVIES*/
	public static void testModifyMenuItem() {
		Movies movies=new Movies(5L, "The GodFatherII", 3000000000L, true, new DateUtil().convertToDate("14/03/1972"),
				"Drama", false);
		MoviesDaoSqlImpl moviesSqlImpl=new MoviesDaoSqlImpl();
		
		moviesSqlImpl.modifyMovies(movies);
	}
	
	/*ALL MOVIES*/
	public static void testGetMovies() {
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
		DecimalFormat df=new DecimalFormat("####.00");
		
		MoviesDaoSqlImpl moviesDaoSqlImpl=new MoviesDaoSqlImpl();
		long moviesId=3;
		Movies movies=moviesDaoSqlImpl.getMovies(moviesId);
		System.out.format("\n%15s%15s%15s%15s%15s%15s%15s", "ID", "NAME", "PRICE", "ACTIVE", "DATE OF LAUNCH",
				"CATEGORY", "FREE DELIVERY");
		@SuppressWarnings("unused")
		String date=sdf.format(DateUtil.convertToSqlDate(movies.getDateOfLaunch()));
		@SuppressWarnings("unused")
		String price=df.format(movies.getGross());
	}
	
	/*CustomerLIST*/
	public static void testGetMovieListCustomer(){
		String active,hasTeaser;
		System.out.println("MOVIE LIST FOR CUSTOMER");
		MoviesDao moviesDao=new MoviesDaoSqlImpl();
		List<Movies> movieList=moviesDao.getMoviesListCustomer();
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
		System.out.format("\n%15s%15s%15s%15s%15s%15s%15s","ID","TITLE","GROSS","ACTIVE","DATE OF LAUNCH","GENRE","HAS TEASER");
		for (Movies movies : movieList) {
			System.out.println("--------");
			if(movies.getActive()==true) {
				active="YES";
			}else {
				active="NO";
			}
			if (movies.getHasTeaser()==true) {
				hasTeaser="YES";
			}else {
				hasTeaser="NO";
			}
			System.out.format("\n%15s%15s%15s%15s%15s%15s%15s",movies.getId(),movies.getTitle(),
					movies.getGross(),active,sdf.format(movies.getDateOfLaunch()),movies.getGenre(),hasTeaser);
		}
	}

	public static void main(String[] args) {
//		testGetMoviesListAdmin();//Admin
//		testModifyMenuItem();//Modify
		testGetMovieListCustomer();
		// Connection connection=ConnectionHandler.getConnection();
		// System.out.println(connection);
	}

}
