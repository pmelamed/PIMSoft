package com.pimsoft.rater.data;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("participant")
public class EventDiverRating {
	private transient EventData event;
	private transient DiverData diver;
	private long diverId;
	private int place;
	private float points;
	private float ratingBefore;
	private float ratingUpdate;

	public EventDiverRating() {
	}

	public void setup(Rating rating, EventData event) {
		this.event = event;
		this.diver = rating.getDiver(diverId);
	}

	public long getDiverId() {
		return diverId;
	}

	public void setDiverId(long diverId) {
		this.diverId = diverId;
	}

	public void setDiver(DiverData diver) {
		this.diver = diver;
	}

	public void setPlace(int place) {
		this.place = place;
	}

	public void setPoints(float points) {
		this.points = points;
	}

	public void setRatingBefore(float ratingBefore) {
		this.ratingBefore = ratingBefore;
	}

	public void setRatingUpdate(float ratingUpdate) {
		this.ratingUpdate = ratingUpdate;
	}

	public DiverData getDiver() {
		return diver;
	}

	public float getRatingBefore() {
		return ratingBefore;
	}

	public float getRatingUpdate() {
		return ratingUpdate;
	}

	public int getPlace() {
		return place;
	}

	public float getPoints() {
		return points;
	}

	public EventData getEvent() {
		return event;
	}

	public void setEvent(EventData event) {
		this.event = event;
	}
}
