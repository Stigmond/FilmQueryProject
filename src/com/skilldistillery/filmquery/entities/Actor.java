package com.skilldistillery.filmquery.entities;

import java.util.List;

public class Actor {

	private int IDNum;
	private String firstName;
	private String lastName;
	List<Film> films;
	
	public Actor(int iDNum, String firstName, String lastName, List<Film> films) {
		super();
		IDNum = iDNum;
		this.firstName = firstName;
		this.lastName = lastName;
		this.films = films;
	}
	
	public int getIDNum() {
		return IDNum;
	}
	public void setIDNum(int iDNum) {
		IDNum = iDNum;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public List<Film> getFilms() {
		return films;
	}
	public void setFilms(List<Film> films) {
		this.films = films;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + IDNum;
		result = prime * result + ((films == null) ? 0 : films.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Actor other = (Actor) obj;
		if (IDNum != other.IDNum)
			return false;
		if (films == null) {
			if (other.films != null)
				return false;
		} else if (!films.equals(other.films))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Actor ID: " + IDNum + ", First Name: " + firstName + ", Last Name: " + lastName + "]";
	}
	
	
}
