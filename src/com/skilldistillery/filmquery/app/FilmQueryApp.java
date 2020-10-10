package com.skilldistillery.filmquery.app;

import java.sql.SQLException;
import java.util.Scanner;

import com.skilldistillery.filmquery.database.DatabaseAccessor;
import com.skilldistillery.filmquery.database.DatabaseAccessorObject;
import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;

public class FilmQueryApp {

	DatabaseAccessor db = new DatabaseAccessorObject();

	public static void main(String[] args) {
		FilmQueryApp app = new FilmQueryApp();

//		app.test();

		app.launch();
	}

//  private void test() {
//    Film film = new Film();
////	  Actor actor = new Actor();
//	try {
//		film = db.findFilmById((int)(Math.random() * (1000 - 1)) + 1);
////		actor = db.findActorById(0);
//	} catch (SQLException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//	if (film == null) {
////	if (actor == null) {
//		System.out.println("No Film Located!");
////		System.out.println("No Actor Located!");
//	} else {
//    System.out.println(film);
////		System.out.println(actor);
//	}
//  }

	private void launch() {
		
		Scanner input = new Scanner(System.in);

		startUserInterface(input);

		input.close();
	}

	private void startUserInterface(Scanner input) {

		boolean keepGoing = true;
		String menuSelection = null;

		System.out.println("   Skill Distillery Movie DataBase");

		while (keepGoing) {
			displayMenu();
			
			System.out.print("\nPlease Enter Your Selection: ");
			menuSelection = input.nextLine();
			switch (menuSelection) {
			
			case "1":
				filmById(input, db);
				break;
			
			case "2":
				System.out.println("Option 2\n");
				break;
			case "0":
				System.out.println("Goodbye!\n");
				keepGoing = false;
				break;
			default:
				System.out.println("Invalid Entry\n");
				break;
			}
		}

	}

	public void displayMenu() {
		System.out.println("");
		System.out.println(" [][][] [][][] []    [][][][] [][][] ");
		System.out.println("[]      []   [][][][][][]   [][]   []");
		System.out.println(" [][][] []   [][] [] [][]   [][] []] ");
		System.out.println("      [][]   [][]    [][]   [][]   []");
		System.out.println(" [][][] [][][] []    [][][][] [][][] ");
		System.out.println("*************************************");
		System.out.println("*************************************");
		System.out.println("***                               ***");
		System.out.println("***   1. Look Up Film by ID       ***");
		System.out.println("***   2. Look Up Film by Keyword  ***");
		System.out.println("***                               ***");
		System.out.println("***                               ***");
		System.out.println("***                               ***");
		System.out.println("***                               ***");
		System.out.println("***                               ***");
		System.out.println("***   0. Exit                     ***");
		System.out.println("***                               ***");
		System.out.println("*************************************");
		System.out.println("*************************************");
	}

	public void filmById(Scanner input, DatabaseAccessor db) {
		
		Film tempFilm = null;
		int filmId;
		
		System.out.print("\nPlease Enter Film ID#: ");
		filmId = input.nextInt();
		
		try {
		tempFilm = db.findFilmById(filmId);
		input.nextLine();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (tempFilm == null) {
			System.out.println("Film Not Located!");
		} else {
			StringBuilder sb = new StringBuilder("\n");
			sb.append("*------>>  ").append(tempFilm.getFilmTitle()).append("  <<------*");
			sb.append("\n\nStarring:\n\n");
			for (Actor actor : tempFilm.getActorsInFilm()) {
				sb.append(actor);
				sb.append("\n");
			}
			sb.append("\n-------------------\n");
			sb.append(tempFilm.getFilmReleaseYear()).append("\t").append("Rated: ").append(tempFilm.getFilmRating());
			sb.append("\n-------------------\n");
			sb.append(tempFilm.getFilmDescription());
			sb.append("\n-------------------\n");
			sb.append("Language: ").append(tempFilm.getFilmLanguage());		
			
			System.out.println(sb.toString());
			
		}
	}
	
	public void filmByKeyword() {
		
	}
}
