package com.nicusa.ridbtips.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Tip implements Serializable {

	private Long id;
	private Long ridbId;
	private String description;
	private Integer rating;
	private Boolean userCreated;
	private RidbType ridbType;

	public Tip() {
	}

	public Tip(Long ridbId, String description, Integer rating, Boolean userCreated) {
		this.ridbId = ridbId;
		this.description = description;
		this.rating = rating;
		this.userCreated = userCreated;
	}

	public Tip(Long ridbId, String description, Integer rating, Boolean userCreated, RidbType ridbType) {
		this.ridbId = ridbId;
		this.description = description;
		this.rating = rating;
		this.userCreated = userCreated;
		this.ridbType = ridbType;
	}

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "ridb_id")
	public Long getRidbId() {
		return ridbId;
	}

	public void setRidbId(Long ridbId) {
		this.ridbId = ridbId;
	}

	@Column(name = "description")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "rating")
	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	@Column(name = "user_created")
	public void setUserCreated(Boolean userCreated) {
		this.userCreated = userCreated;
	}

	public Boolean isUserCreated() {
		return userCreated;
	}

	@Column(name = "ridb_type")
	@Enumerated(EnumType.STRING)
	public RidbType getRidbType() {
		return ridbType;
	}

	public void setRidbType(RidbType ridbType) {
		this.ridbType = ridbType;
	}
}
