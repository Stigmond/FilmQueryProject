package com.skilldistillery.filmquery.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;

public class DatabaseAccessorObject implements DatabaseAccessor {

	public static final String URL = "jdbc:mysql://localhost:3306/sdvid?useSSL=false";


	public DatabaseAccessorObject() {

	}

	
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	
	@Override
	public Film findFilmById(int filmId) throws SQLException {

		Film tempFilm = new Film();
		String user = "student";
		String pw = "student";
		String sqltxt = "SELECT film.id, film.title, film.description, film.release_year, film.length, film.rating, film.special_features FROM  film JOIN language ON film.id = language.id WHERE film.id = ?";
		
		Connection conn = DriverManager.getConnection(URL, user, pw);
		PreparedStatement stmt = conn.prepareStatement(sqltxt);
		stmt.setInt(1, filmId);
		ResultSet filmResult = stmt.executeQuery();
		if(filmResult.next()) {
			tempFilm.setFilmID(filmResult.getInt("film.id"));
			tempFilm.setFilmTitle(filmResult.getString("film.title"));
			tempFilm.setFilmDescription(filmResult.getString("film.description"));
			tempFilm.setFilmReleaseYear(filmResult.getInt("film.release_year"));
			tempFilm.setFilmLength(filmResult.getInt("film.length"));
			tempFilm.setFilmRating(filmResult.getString("film.rating"));
			tempFilm.setFilmFeatures(filmResult.getString("film.special_features"));
		}
		else {
			System.out.println("No Film Located!");
			return null;
		}
		
		stmt.close();
		conn.close();
		return tempFilm;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Override
	public Actor findActorById(int actorId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Actor> findActorsByFilmId(int filmId) {
		// TODO Auto-generated method stub
		return null;
	}

}
