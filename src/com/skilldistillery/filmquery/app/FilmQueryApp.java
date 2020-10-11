package com.skilldistillery.filmquery.app;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.skilldistillery.filmquery.database.DatabaseAccessor;
import com.skilldistillery.filmquery.database.DatabaseAccessorObject;
import com.skilldistillery.filmquery.entities.Film;

public class FilmQueryApp {

	DatabaseAccessor db = new DatabaseAccessorObject();

	public static void main(String[] args) {
		FilmQueryApp app = new FilmQueryApp();

		app.launch();
	}

//		film = db.findFilmById((int)(Math.random() * (1000 - 1)) + 1);


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
				filmByKeyword(input, db);
				
				break;
			
			case "3":
				try {
					System.out.println("\nMay We Suggest:\n");
					Film suggestion = db.findFilmById((int)(Math.random() * (1000 - 1)) + 1);
					System.out.println(suggestion);
					boolean exitSub = false;
					do {
						System.out.print("\n(1) View All Film Details | (2) Return to Main Menu: ");
						String subMenu = input.nextLine();
						switch (subMenu) {
						case "1":
							FilmDataDisplayer.showFilmInfo(suggestion);
							break;
						case "2":
							System.out.println("\nReturning to Main Menu...");
							exitSub = true;
							break;
						default:
							System.out.print("Please Select 1 or 2: ");
						}
					} while (!exitSub);
					break;
				
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
			case "0":
				System.out.println("\nGoodbye!");
				keepGoing = false;
				break;
			default:
				System.out.println("\nInvalid Entry\n");
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
		System.out.println("***                               ***");
		System.out.println("***   2. Look Up Film by Keyword  ***");
		System.out.println("***                               ***");
		System.out.println("***   3. Surprise Me!             ***");
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
		boolean badInput = false;
		boolean exitSub = false;

		do {
		
			try {
				System.out.print("\nPlease Enter Film ID#: ");
				filmId = input.nextInt();
				badInput = false;
				System.out.println("");
				tempFilm = db.findFilmById(filmId);
				input.nextLine();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (InputMismatchException e) {
				System.out.println("\nInvalid Entry");
				input.nextLine();
				badInput = true;
			}

			if (tempFilm == null) {
				System.out.println("\n<< Film Not Located! >>");
				badInput = true;		
			} else {
				System.out.println(tempFilm);
				
				do {
					System.out.print("\n(1) View All Film Details | (2) Return to Main Menu: ");
					String subMenu = input.nextLine();
					switch (subMenu) {
					case "1":
						FilmDataDisplayer.showFilmInfo(tempFilm);
						break;
					case "2":
						System.out.println("\nReturning to Main Menu...");
						exitSub = true;
						break;
					default:
						System.out.print("Please Select 1 or 2: ");
					}
				} while (!exitSub);
			}
		} while (badInput);
	}
	
	public void filmByKeyword(Scanner input, DatabaseAccessor db) {
		
		List<Film> filmList = new ArrayList<>();
		String keyword;
		boolean badInput = false;

		do {
		
			try {
				System.out.print("\nPlease Enter a Keyword: ");
				keyword = input.nextLine();
				badInput = false;
				System.out.println("");
				filmList = db.findFilmsByKeyword(keyword);
//				input.nextLine();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (InputMismatchException e) {
				System.out.println("\nInvalid Entry");
				input.nextLine();
				badInput = true;
			}
			if (filmList.isEmpty()) {
				System.out.println("<< No Film(s) Located! >>");
				badInput = true;		
			} else {
				for (Film film : filmList) {
					System.out.println(film);
				}

			}
		} while (badInput);
	}

	
}
