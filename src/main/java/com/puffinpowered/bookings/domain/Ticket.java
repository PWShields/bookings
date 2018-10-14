package com.puffinpowered.bookings.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Ticket {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "event_id", nullable = false)
	private Event event;

	private Status status;

	private TicketType ticketType;

	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "purchaser_id")
	private Purchaser purchaser;

	private String customerName;


	public Ticket setEvent(Event event) {
		this.event = event;
		return this;
	}

	public Ticket setStatus(Status status) {
		this.status = status;
		return this;
	}

	public Ticket setTicketType(TicketType ticketType) {
		this.ticketType = ticketType;
		return this;
	}

	public Ticket setPurchaser(Purchaser purchaser) {
		this.purchaser = purchaser;
		return this;
	}

	public Ticket setCustomerName(String customerName) {
		this.customerName = customerName;
		return this;
	}
}
