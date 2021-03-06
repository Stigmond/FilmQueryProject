package com.skilldistillery.filmquery.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;
import com.skilldistillery.filmquery.entities.Inventory;

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
		String sqltxt = "SELECT film.id, film.title, film.description, film.release_year, film.length, film.rating, film.special_features, language.name, category.name FROM film JOIN film_category ON film.id = film_category.film_id JOIN category ON category.id = film_category.category_id JOIN language ON film.language_id = language.id WHERE film.id = ?";

		Connection conn = DriverManager.getConnection(URL, user, pw);
		PreparedStatement stmt = conn.prepareStatement(sqltxt);
		stmt.setInt(1, filmId);
		ResultSet filmResult = stmt.executeQuery();
		if (filmResult.next()) {
			tempFilm.setFilmID(filmResult.getInt("film.id"));
			tempFilm.setFilmTitle(filmResult.getString("film.title"));
			tempFilm.setFilmDescription(filmResult.getString("film.description"));
			tempFilm.setFilmReleaseYear(filmResult.getInt("film.release_year"));
			tempFilm.setFilmLength(filmResult.getInt("film.length"));
			tempFilm.setFilmRating(filmResult.getString("film.rating"));
			tempFilm.setFilmLanguage(filmResult.getString("language.name"));
			tempFilm.setFilmFeatures(filmResult.getString("film.special_features"));
			tempFilm.setCategory(filmResult.getString("category.name"));
			tempFilm.setInventoryData(findCopiesOfFilm(filmId));
			tempFilm.setActorsInFilm(findActorsByFilmId(filmId));
		} else {
			return null;
		}

		stmt.close();
		conn.close();
		return tempFilm;
	}

	public List<Film> findFilmsByKeyword(String keyword) throws SQLException {

		List<Film> filmList = new ArrayList<>();
		String user = "student";
		String pw = "student";
		String sqltxt = "SELECT film.id, film.title, film.description, film.release_year, film.length, film.rating, language.name, film.special_features FROM film JOIN language ON film.language_id = language.id WHERE (film.description LIKE ?) OR (film.title LIKE ?)";

		Connection conn = DriverManager.getConnection(URL, user, pw);
		PreparedStatement stmt = conn.prepareStatement(sqltxt);
		stmt.setString(1, "%" + keyword + "%");
		stmt.setString(2, "%" + keyword + "%");
		ResultSet filmResult = stmt.executeQuery();
		while (filmResult.next()) {
			Film tempFilm = new Film();
			tempFilm.setFilmID(filmResult.getInt("film.id"));
			tempFilm.setFilmTitle(filmResult.getString("film.title"));
			tempFilm.setFilmDescription(filmResult.getString("film.description"));
			tempFilm.setFilmReleaseYear(filmResult.getInt("film.release_year"));
			tempFilm.setFilmRating(filmResult.getString("film.rating"));
//			tempFilm.setFilmLength(filmResult.getInt("film.length"));
//			tempFilm.setFilmLanguage(filmResult.getString("language.name"));
//			tempFilm.setFilmFeatures(filmResult.getString("film.special_features"));
//			tempFilm.setActorsInFilm(findActorsByFilmId(tempFilm.getFilmID()));
			filmList.add(tempFilm);
		}
		stmt.close();
		conn.close();
		return filmList;

	}

	@Override
	public Actor findActorById(int actorId) throws SQLException {

		Actor tempActor = new Actor();
		String user = "student";
		String pw = "student";
		String sqltxt = "SELECT * FROM actor WHERE actor.id = ?";

		Connection conn = DriverManager.getConnection(URL, user, pw);
		PreparedStatement stmt = conn.prepareStatement(sqltxt);
		stmt.setInt(1, actorId);
		ResultSet actorResult = stmt.executeQuery();
		if (actorResult.next()) {
			tempActor.setActorID(actorResult.getInt("actor.id"));
			tempActor.setActorFirstName(actorResult.getString("actor.first_name"));
			tempActor.setActorLastName(actorResult.getString("actor.last_name"));
		} else {
			return null;
		}

		stmt.close();
		conn.close();
		return tempActor;
	}

	@Override
	public List<Actor> findActorsByFilmId(int filmId) throws SQLException {

		List<Actor> tempList = new ArrayList<>();
		Actor tempActor;
		String user = "student";
		String pw = "student";
		String sqltxt = "SELECT actor.id, actor.first_name, actor.last_name FROM actor JOIN film_actor ON actor.id = film_actor.actor_id JOIN film ON film.id = film_actor.film_id WHERE film.id = ?";

		Connection conn = DriverManager.getConnection(URL, user, pw);
		PreparedStatement stmt = conn.prepareStatement(sqltxt);
		stmt.setInt(1, filmId);
		ResultSet resultList = stmt.executeQuery();
		if (resultList == null) {
			return null;
		} else {
			while (resultList.next()) {
				tempActor = new Actor();
				tempActor.setActorID(resultList.getInt("actor.id"));
				tempActor.setActorFirstName(resultList.getString("actor.first_name"));
				tempActor.setActorLastName(resultList.getString("actor.last_name"));
				tempList.add(tempActor);
			}
			stmt.close();
			conn.close();
			return tempList;
		}

	}

	public List<Inventory> findCopiesOfFilm(int filmId) throws SQLException {

		List<Inventory> tempList = new ArrayList<>();
		Inventory tempInventory;
		String user = "student";
		String pw = "student";
		//ONLY OBTAINS KNOWN WORKING COPIES.  ALL DAMAGED, LOST OR NULL CONDITIONS EXCLUDED
		String sqltxt = "SELECT film.title, inventory_item.id, inventory_item.media_condition FROM inventory_item JOIN film ON film.id = inventory_item.film_id  WHERE (media_condition != 'damaged' AND  media_condition != 'lost') AND inventory_item.film_id = ?";

		Connection conn = DriverManager.getConnection(URL, user, pw);
		PreparedStatement stmt = conn.prepareStatement(sqltxt);
		stmt.setInt(1, filmId);
		ResultSet resultList = stmt.executeQuery();
		if (resultList == null) {
			return null;
		} else {
			while (resultList.next()) {
				tempInventory = new Inventory();
				tempInventory.setItemName(resultList.getString("film.title"));
				tempInventory.setInventoryId(resultList.getInt("inventory_item.id"));
				tempInventory.setItemCondition(resultList.getString("inventory_item.media_condition"));
				tempList.add(tempInventory);
			}
			stmt.close();
			conn.close();
			return tempList;
		}
	}

}
