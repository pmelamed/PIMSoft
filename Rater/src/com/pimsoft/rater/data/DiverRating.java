package com.pimsoft.rater.data;

public class DiverRating {
	private final DiverData diver;
	private final float rating;

	public DiverRating(DiverData diver, float rating) {
		this.diver = diver;
		this.rating = rating;
	}

	public DiverData getDiver() {
		return diver;
	}

	public float getRating() {
		return rating;
	}
}
