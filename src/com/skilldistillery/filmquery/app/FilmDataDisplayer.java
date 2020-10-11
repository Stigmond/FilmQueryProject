package com.skilldistillery.filmquery.app;

import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;

public class FilmDataDisplayer {
	
	FilmDataDisplayer() {
	
	}
	
	public static void showFilmInfo(Film film) {
		
		StringBuilder sb = new StringBuilder("\n");
		sb.append("*------>>  ").append(film.getFilmTitle()).append("  <<------*");
		sb.append("\n\nStarring:\n\n");
		for (Actor actor : film.getActorsInFilm()) {
			sb.append(actor);
			sb.append("\n");
		}
		sb.append("\n--------------------\n");
		sb.append(film.getFilmReleaseYear()).append("\t").append(" Rated: ")
				.append(film.getFilmRating());
		sb.append("\n--------------------\n");
		sb.append("Running Time: " + film.getFilmLength() + " min.");
		sb.append("\n--------------------\n");
		sb.append(film.getFilmDescription());
		sb.append("\n--------------------\n");
		sb.append("Language: ").append(film.getFilmLanguage());

		System.out.println(sb.toString());
	}
}
