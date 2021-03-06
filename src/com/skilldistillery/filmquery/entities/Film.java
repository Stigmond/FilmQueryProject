package com.skilldistillery.filmquery.entities;

import java.util.List;

public class Film {

	private int filmID;
	private String filmTitle;
	private String filmDescription;
	private Integer filmReleaseYear;
	private String filmLanguage;
	private Integer filmLength;
	private String filmRating;
	private String filmFeatures;
	private String category;
	private List<Actor> actorsInFilm;
	private List<Inventory> inventoryData;
	
	public Film() {
		
	}
	
	public Film(int filmID, String filmTitle, String filmDescription, Integer filmReleaseYear, String filmLanguage,
			Integer filmLength, String filmRating, String filmFeatures, String category, List<Actor> actorsInFilm,
			List<Inventory> inventoryData) {
		super();
		this.filmID = filmID;
		this.filmTitle = filmTitle;
		this.filmDescription = filmDescription;
		this.filmReleaseYear = filmReleaseYear;
		this.filmLanguage = filmLanguage;
		this.filmLength = filmLength;
		this.filmRating = filmRating;
		this.filmFeatures = filmFeatures;
		this.category = category;
		this.actorsInFilm = actorsInFilm;
		this.inventoryData = inventoryData;
	}

	public int getFilmID() {
		return filmID;
	}

	public void setFilmID(int filmID) {
		this.filmID = filmID;
	}

	public String getFilmTitle() {
		return filmTitle;
	}

	public void setFilmTitle(String filmTitle) {
		this.filmTitle = filmTitle;
	}

	public String getFilmDescription() {
		return filmDescription;
	}

	public void setFilmDescription(String filmDescription) {
		this.filmDescription = filmDescription;
	}

	public Integer getFilmReleaseYear() {
		return filmReleaseYear;
	}

	public void setFilmReleaseYear(Integer filmReleaseYear) {
		this.filmReleaseYear = filmReleaseYear;
	}

	public String getFilmLanguage() {
		return filmLanguage;
	}

	public void setFilmLanguage(String filmLanguage) {
		this.filmLanguage = filmLanguage;
	}

	public Integer getFilmLength() {
		return filmLength;
	}

	public void setFilmLength(Integer filmLength) {
		this.filmLength = filmLength;
	}

	public String getFilmRating() {
		return filmRating;
	}

	public void setFilmRating(String filmRating) {
		this.filmRating = filmRating;
	}

	public String getFilmFeatures() {
		return filmFeatures;
	}

	public void setFilmFeatures(String filmFeatures) {
		this.filmFeatures = filmFeatures;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public List<Actor> getActorsInFilm() {
		return actorsInFilm;
	}

	public void setActorsInFilm(List<Actor> actorsInFilm) {
		this.actorsInFilm = actorsInFilm;
	}

	public List<Inventory> getInventoryData() {
		return inventoryData;
	}

	public void setInventoryData(List<Inventory> inventoryData) {
		this.inventoryData = inventoryData;
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((actorsInFilm == null) ? 0 : actorsInFilm.hashCode());
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((filmDescription == null) ? 0 : filmDescription.hashCode());
		result = prime * result + ((filmFeatures == null) ? 0 : filmFeatures.hashCode());
		result = prime * result + filmID;
		result = prime * result + ((filmLanguage == null) ? 0 : filmLanguage.hashCode());
		result = prime * result + ((filmLength == null) ? 0 : filmLength.hashCode());
		result = prime * result + ((filmRating == null) ? 0 : filmRating.hashCode());
		result = prime * result + ((filmReleaseYear == null) ? 0 : filmReleaseYear.hashCode());
		result = prime * result + ((filmTitle == null) ? 0 : filmTitle.hashCode());
		result = prime * result + ((inventoryData == null) ? 0 : inventoryData.hashCode());
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
		if (actorsInFilm == null) {
			if (other.actorsInFilm != null)
				return false;
		} else if (!actorsInFilm.equals(other.actorsInFilm))
			return false;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (filmDescription == null) {
			if (other.filmDescription != null)
				return false;
		} else if (!filmDescription.equals(other.filmDescription))
			return false;
		if (filmFeatures == null) {
			if (other.filmFeatures != null)
				return false;
		} else if (!filmFeatures.equals(other.filmFeatures))
			return false;
		if (filmID != other.filmID)
			return false;
		if (filmLanguage == null) {
			if (other.filmLanguage != null)
				return false;
		} else if (!filmLanguage.equals(other.filmLanguage))
			return false;
		if (filmLength == null) {
			if (other.filmLength != null)
				return false;
		} else if (!filmLength.equals(other.filmLength))
			return false;
		if (filmRating == null) {
			if (other.filmRating != null)
				return false;
		} else if (!filmRating.equals(other.filmRating))
			return false;
		if (filmReleaseYear == null) {
			if (other.filmReleaseYear != null)
				return false;
		} else if (!filmReleaseYear.equals(other.filmReleaseYear))
			return false;
		if (filmTitle == null) {
			if (other.filmTitle != null)
				return false;
		} else if (!filmTitle.equals(other.filmTitle))
			return false;
		if (inventoryData == null) {
			if (other.inventoryData != null)
				return false;
		} else if (!inventoryData.equals(other.inventoryData))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Film #: " + filmID + " - Title: " + filmTitle + " - Year: " + filmReleaseYear + " - Rating: " + filmRating + " - Description: " + filmDescription;

	}	

}
