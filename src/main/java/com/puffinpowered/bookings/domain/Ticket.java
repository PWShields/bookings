package com.puffinpowered.bookings.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@JsonIgnoreProperties(ignoreUnknown=true)
public class Ticket {

    @Id
    @GeneratedValue
    private Long id;

    private Event event;

    private Status status;

    private TicketType ticketType;

    private Purchaser purchaser;

    private String customerName;

    public Ticket(Event event, Status status, TicketType ticketType, Purchaser purchaser, String customerName) {
        this.event = event;
        this.status = status;
        this.ticketType = ticketType;
        this.purchaser = purchaser;
        this.customerName = customerName;
    }

    private Ticket() {
    }

    public Long getId() {
        return id;
    }

    public Event getEvent() {
        return event;
    }

    public Status getStatus() {
        return status;
    }

    public TicketType getTicketType() {
        return ticketType;
    }

    public Purchaser getPurchaser() {
        return purchaser;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setTicketType(TicketType ticketType) {
        this.ticketType = ticketType;
    }

    public void setPurchaser(Purchaser purchaser) {
        this.purchaser = purchaser;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
}
