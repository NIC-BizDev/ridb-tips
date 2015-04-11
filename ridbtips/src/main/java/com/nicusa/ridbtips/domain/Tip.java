package com.nicusa.ridbtips.domain;

public class Tip {

	private Long id;
	private Long ridbId;
	private String description;
	private Integer rating;
	private Boolean userCreated;

	public Tip(Long ridbId, String description, Integer rating, Boolean userCreated) {
		this.ridbId = ridbId;
		this.description = description;
		this.rating = rating;
		this.userCreated = userCreated;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getRidbId() {
		return ridbId;
	}

	public void setRidbId(Long ridbId) {
		this.ridbId = ridbId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public void setUserCreated(Boolean userCreated) {
		this.userCreated = userCreated;
	}

	public Boolean isUserCreated() {
		return userCreated;
	}
}
