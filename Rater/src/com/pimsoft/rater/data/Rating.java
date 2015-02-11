package com.pimsoft.rater.data;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

@XStreamAlias("rating")
public class Rating {
	private static final Path RATING_PATH = Paths.get("data", "rating.xml");
	private static final Log LOG = LogFactory.getLog(Rating.class);
	@XStreamImplicit(itemFieldName = "country")
	private List<CountryData> countries = new ArrayList<>();
	private transient Map<Long, CountryData> countryById = new HashMap<>();

	@XStreamImplicit(itemFieldName = "diver")
	private List<DiverData> divers = new ArrayList<>();
	private transient Map<Long, DiverData> diverById = new HashMap<>();

	@XStreamImplicit(itemFieldName = "event")
	private List<EventData> events = new ArrayList<>();

	private static XStream getStream() {
		XStream stream = new XStream();
		stream.processAnnotations(new Class<?>[] { Rating.class });
		return stream;
	}

	public static final Rating load() {
		if (Files.isRegularFile(RATING_PATH)) {
			XStream stream = getStream();
			Rating loaded;
			try {
				loaded = (Rating) stream.fromXML(Files.newInputStream(
						RATING_PATH, StandardOpenOption.READ));
				loaded.setup();
				return loaded;
			} catch (IOException e) {
				LOG.error(e, e);
			}
		}
		return new Rating();
	}

	public static final void save(Rating rating) {
		try (OutputStream stream = Files.newOutputStream(RATING_PATH,
				StandardOpenOption.WRITE, StandardOpenOption.CREATE,
				StandardOpenOption.TRUNCATE_EXISTING)) {
			getStream().toXML(rating, stream);
		} catch (IOException e) {
			LOG.error(e, e);
		}
	}

	public Rating() {
	}

	public void setup() {
		for (CountryData country : countries) {
			countryById.put(country.getId(), country);
		}
		for (DiverData diver : divers) {
			diver.setup(this);
			diverById.put(diver.getId(), diver);
		}
		for (EventData event : events) {
			event.setup(this);
		}
	}

	public CountryData getCountry(long countryId) {
		return countryById.get(countryId);
	}

	public DiverData getDiver(long diverId) {
		return diverById.get(diverId);
	}
}
