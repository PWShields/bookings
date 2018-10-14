package com.puffinpowered.bookings.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Set;

@Entity
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Event {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	private EventType eventType;

	private ZonedDateTime dateTime;

	@OneToMany(mappedBy = "event")
	private Set<Ticket> tickets;

	private String venue;

	private String country;

	private String region;

	private Status status;

	public Event setName(String name) {
		this.name = name;
		return this;
	}

	public Event setEventType(EventType eventType) {
		this.eventType = eventType;
		return this;
	}

	public Event setDateTime(ZonedDateTime dateTime) {
		this.dateTime = dateTime;
		return this;
	}

	public Event setTickets(Set<Ticket> tickets) {
		this.tickets = tickets;
		return this;
	}

	public Event setVenue(String venue) {
		this.venue = venue;
		return this;
	}

	public Event setCountry(String country) {
		this.country = country;
		return this;
	}

	public Event setRegion(String region) {
		this.region = region;
		return this;
	}

	public Event setStatus(Status status) {
		this.status = status;
		return this;
	}

	@Override
	public String toString() {
		return "Event{" +
				"id=" + id +
				", name='" + name + '\'' +
				", eventType=" + eventType +
				", dateTime=" + dateTime +
				", venue='" + venue + '\'' +
				", country='" + country + '\'' +
				", region='" + region + '\'' +
				", status=" + status +
				'}';
	}
}
