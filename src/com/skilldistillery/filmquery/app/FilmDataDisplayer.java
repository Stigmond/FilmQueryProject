// THIS CLASS WAS CREATED PRIMARILY TO EXPERIMENT WITH STATIC METHODS AND TO REDUCE SOME CLUTTER FROM THE MAIN APP

package com.skilldistillery.filmquery.app;

import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;
import com.skilldistillery.filmquery.entities.Inventory;

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
		sb.append("Category: ").append(film.getCategory());
		sb.append("\n--------------------\n");
		sb.append("Language: ").append(film.getFilmLanguage());
		sb.append("\n--------------------\n");
		for (Inventory inventory: film.getInventoryData()) {
			sb.append("Inventory No." + inventory.getInventoryId()).append("\tCondition: " + inventory.getItemCondition());
			sb.append('\n');
		}
		System.out.println(sb.toString());
	}
}
