package com.nicusa.ridbtips.domain;

public class LeaveTipRequest {

	private Long ridbId;
	private String description;

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
}
