package com.skilldistillery.filmquery.entities;

import java.util.ArrayList;
import java.util.List;

public class Actor {
	
	private int actorID;
	private String actorFirstName;
	private String actorLastName;
	private List<Film> films;
	
	public Actor(int actorID, String actorFirstName, String actorLastName, List<Film> films) {
		super();
		this.actorID = actorID;
		this.actorFirstName = actorFirstName;
		this.actorLastName = actorLastName;
		this.films = new ArrayList<>(films);
	}

	

	public int getActorID() {
		return actorID;
	}



	public void setActorID(int actorID) {
		this.actorID = actorID;
	}



	public String getActorFirstName() {
		return actorFirstName;
	}



	public void setActorFirstName(String actorFirstName) {
		this.actorFirstName = actorFirstName;
	}



	public String getActorLastName() {
		return actorLastName;
	}



	public void setActorLastName(String actorLastName) {
		this.actorLastName = actorLastName;
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
		result = prime * result + ((actorFirstName == null) ? 0 : actorFirstName.hashCode());
		result = prime * result + actorID;
		result = prime * result + ((actorLastName == null) ? 0 : actorLastName.hashCode());
		result = prime * result + ((films == null) ? 0 : films.hashCode());
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
		if (actorFirstName == null) {
			if (other.actorFirstName != null)
				return false;
		} else if (!actorFirstName.equals(other.actorFirstName))
			return false;
		if (actorID != other.actorID)
			return false;
		if (actorLastName == null) {
			if (other.actorLastName != null)
				return false;
		} else if (!actorLastName.equals(other.actorLastName))
			return false;
		if (films == null) {
			if (other.films != null)
				return false;
		} else if (!films.equals(other.films))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "[Actor ID #: " + actorID + ", First Name: " + actorFirstName + ", Last Name: " + actorLastName
				+ "]";
	}
	
	
	
}
