package com.pimsoft.rater.data;

import java.util.Date;
import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

@XStreamAlias("event")
public class EventData {
	@XStreamAsAttribute
	private final Date date;
	@XStreamAsAttribute
	private final String name;
	@XStreamImplicit(itemFieldName = "participant")
	private final List<EventDiverRating> participants;

	public EventData(Date date, String name, List<EventDiverRating> participants) {
		this.date = date;
		this.name = name;
		this.participants = participants;
	}

	public Date getDate() {
		return date;
	}

	public String getName() {
		return name;
	}

	public List<EventDiverRating> getParticipants() {
		return participants;
	}

	public void setup(Rating rating) {
		for (EventDiverRating participant : participants) {
			participant.setup(rating, this);
		}
	}
}
