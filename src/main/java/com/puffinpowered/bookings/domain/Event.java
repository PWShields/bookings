package com.puffinpowered.bookings.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@JsonIgnoreProperties(ignoreUnknown=true)
public class Event {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private EventType eventType;

    private LocalDateTime dateTime;

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

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
