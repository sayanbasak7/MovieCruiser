package com.cognizant.moviecruiser.dao;

public class FavoritesEmptyExecption extends Exception {

	private static final long serialVersionUID = 1L;

	public FavoritesEmptyExecption() {
		super("Favorites is empty");

	}

}
