## Film Query Project

### Overview

This is the Week 7 assignment for the Skill Distillery Java Bootcamp.  This assignment is a program which utilizes Java and MySQL to simulate access to a mock film database, and allows a user to search and retrieve data from the database.

### How to Run

1.  This program will require the use of multiple files to ensure performance.  Please verify that all files, including interfaces and necessary MySQL databases, have been downloaded.

2.  Compile and/or run this Project in a compatible IDE or Java Runtime Environment of your choice.  This Project was programmed and compiled in Eclipse under Java SE 8 [1.8.0_261], and tested on a local MySQL server.  

3.  Upon loading, User will be taken to a Main Menu.  This Menu gives User one of three options:

  * Access a specific film based on its ID Number;
  * Browse the entire database based on a keyword; or
  * Access a random film from the database.

4. Browsing a film by keyword will return a list of all films in the database that have a title or film description that contain the keyword.  This list will include all of the films' ID numbers should User wish to obtain more information on a particular film.

5. Accessing a specific film by ID number will pull up basic film information including title and description.  User will then be given the option to obtain additional data about the film, or return to the main menu.  The additional data includes the film's running time, cast, language, and rental store availability.

6. Should User feel a little adventurous, the program offers the option of having a random film selected from the database.  Upon retrieving a random film, User will again be given the option of retrieving further details or returning to the main menu.

7. Upon finishing use of the program, User may enter "0" at the Main Menu to Exit.

8. Have fun, and enjoy your movie!

### Topics Addressed

* MAMP
* MySQL, with focus on 'SELECT', 'JOIN', 'WHERE' commands, as well as Logical Operators, Predicates, and Pattern Matching
* Java Database Connectivity Model ("JDBM")
* Dependency Management / Maven

### Lesson(s) Learned

* This project gave a hands-on application of the fundamentals of database/Java communication and how data can be retrieved and manipulated.
* This project stressed the importance of third-party code, and understanding how to import and utilize third-party code not provided in the JDK.
* This project helped better demonstrate checked exceptions, and the methods to address them in foreign code.
* This project provided opportunities to better understand SQL language basics, and the nuances of syntax and structure to effectively and accurately link tables.
