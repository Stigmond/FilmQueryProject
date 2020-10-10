package com.skilldistillery.filmquery.app;

import java.sql.SQLException;
import java.util.Scanner;

import com.skilldistillery.filmquery.database.DatabaseAccessor;
import com.skilldistillery.filmquery.database.DatabaseAccessorObject;
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
//		film = db.findFilmById(0);
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
    
  }

}
