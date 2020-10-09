package com.skilldistillery.filmquery.entities;

import java.util.List;

public class Film {

	private int filmID;
	private String title;
	private String description;
	private Integer year;
	private String language;
	private Integer length;
	private String rating;
	private String special_features;
	List<Actor> actors;



	public int getFilmID() {
		return filmID;
	}


	public void setFilmID(int filmID) {
		this.filmID = filmID;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Integer getYear() {
		return year;
	}


	public void setYear(Integer year) {
		this.year = year;
	}


	public String getLanguage() {
		return language;
	}


	public void setLanguage(String language) {
		this.language = language;
	}


	public Integer getLength() {
		return length;
	}


	public void setLength(Integer length) {
		this.length = length;
	}


	public String getRating() {
		return rating;
	}


	public void setRating(String rating) {
		this.rating = rating;
	}


	public String getSpecial_features() {
		return special_features;
	}


	public void setSpecial_features(String special_features) {
		this.special_features = special_features;
	}


	public List<Actor> getActors() {
		return actors;
	}


	public void setActors(List<Actor> actors) {
		this.actors = actors;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((actors == null) ? 0 : actors.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + filmID;
		result = prime * result + ((language == null) ? 0 : language.hashCode());
		result = prime * result + ((length == null) ? 0 : length.hashCode());
		result = prime * result + ((rating == null) ? 0 : rating.hashCode());
		result = prime * result + ((special_features == null) ? 0 : special_features.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((year == null) ? 0 : year.hashCode());
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
		Film other = (Film) obj;
		if (actors == null) {
			if (other.actors != null)
				return false;
		} else if (!actors.equals(other.actors))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (filmID != other.filmID)
			return false;
		if (language == null) {
			if (other.language != null)
				return false;
		} else if (!language.equals(other.language))
			return false;
		if (length == null) {
			if (other.length != null)
				return false;
		} else if (!length.equals(other.length))
			return false;
		if (rating == null) {
			if (other.rating != null)
				return false;
		} else if (!rating.equals(other.rating))
			return false;
		if (special_features == null) {
			if (other.special_features != null)
				return false;
		} else if (!special_features.equals(other.special_features))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (year == null) {
			if (other.year != null)
				return false;
		} else if (!year.equals(other.year))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "[Film ID #: " + filmID + ", Title: " + title + ", Year: " + year + ", Length: " + length + ", Rating: "
				+ rating + "]";
	}
	
}
