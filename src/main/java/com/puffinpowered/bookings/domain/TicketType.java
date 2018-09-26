package com.puffinpowered.bookings.domain;

public enum TicketType {

    STANDARD("This is a standard ticket"),
    PREMIUM("This is a premium ticket"),
    VIP("This is VIP"),
    BACKSTAGE("This ticket allows you backstage before the show");

    private String description;

    TicketType(String description) {
        this.description = description;
    }

    private TicketType() {
    }

    public String getDescription() {
        return description;
    }
}
