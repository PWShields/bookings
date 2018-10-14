package com.puffinpowered.bookings.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
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

	private LocalDateTime dateTime;

	@OneToMany(mappedBy = "event")
	private Set<Ticket> tickets;

	private String venue;

	private String country;

	private String region;

	private Status status;

	public Event(String name, EventType eventType, LocalDateTime dateTime, String venue, String country, String region, Status status) {
		this.name = name;
		this.eventType = eventType;
		this.dateTime = dateTime;
		this.venue = venue;
		this.country = country;
		this.region = region;
		this.status = status;
	}

	private Event() {
	}

	private Event setId(Long id) {
		this.id = id;
		return this;
	}
}
