package com.pimsoft.rater.data;

import java.util.Date;

public class DiverData {
	private long id;
	private transient CountryData country;
	private long countryId;
	private String name1;
	private String name2;
	private String name3;
	private Date birthdate;
	private float initialRating;

	public void setup(Rating rating) {
		country = rating.getCountry(countryId);
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setCountry(CountryData country) {
		this.country = country;
	}

	public void setName1(String name1) {
		this.name1 = name1;
	}

	public void setName2(String name2) {
		this.name2 = name2;
	}

	public void setName3(String name3) {
		this.name3 = name3;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public void setInitialRating(float initialRating) {
		this.initialRating = initialRating;
	}

	public long getId() {
		return id;
	}

	public CountryData getCountry() {
		return country;
	}

	public String getName1() {
		return name1;
	}

	public String getName2() {
		return name2;
	}

	public String getName3() {
		return name3;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public float getInitialRating() {
		return initialRating;
	}

	public long getCountryId() {
		return countryId;
	}

	public void setCountryId(long countryId) {
		this.countryId = countryId;
	}
}
