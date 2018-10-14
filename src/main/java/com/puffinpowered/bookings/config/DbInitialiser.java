package com.puffinpowered.bookings.config;

import com.puffinpowered.bookings.domain.Event;
import com.puffinpowered.bookings.domain.EventType;
import com.puffinpowered.bookings.domain.Status;
import com.puffinpowered.bookings.domain.Ticket;
import com.puffinpowered.bookings.repository.EventRepository;
import com.puffinpowered.bookings.repository.TicketRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

@Component
@ConditionalOnProperty(name = "loadInMemoryData", havingValue = "true")
public class DbInitialiser implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(DbInitialiser.class);

	private EventRepository eventRepository;
	private TicketRepository ticketRepository;

	public DbInitialiser(EventRepository eventRepository, TicketRepository ticketRepository) {
		this.eventRepository = eventRepository;
		this.ticketRepository = ticketRepository;
	}

	@Override
	public void run(String... args) throws Exception {


		Event princessEugenieWedding = new Event();
		LocalDateTime localDateTime = LocalDateTime.parse("2018-10-12T11:00");
		ZoneId zoneId = ZoneId.of("Europe/London");
		ZonedDateTime zonedDateTime = ZonedDateTime.of(localDateTime, zoneId);
		princessEugenieWedding
				.setCountry("UK")
				.setDateTime(zonedDateTime)
				.setEventType(EventType.WEDDING)
				.setName("Wedding of Princess Eugenie and Jack")
				.setRegion("SE England")
				.setStatus(Status.CURRENT)
				.setVenue("St George Chapel");
		eventRepository.save(princessEugenieWedding);

		Set<Ticket> tickets = makeTickets(50, princessEugenieWedding);
		 princessEugenieWedding.setTickets(tickets);
		eventRepository.save(princessEugenieWedding);

		//Get all tickets for an event

		Set<Ticket> tickets1 = ticketRepository.fetchAllTicketsForEvent(1L);

	}

	private Set<Ticket> makeTickets(int i, Event event) {
		Set<Ticket> tickets = new CopyOnWriteArraySet<>();
		while (i > 0) {
			Ticket ticket = new Ticket();
			ticket.setEvent(event);
			ticketRepository.save(ticket);
			tickets.add(ticket);
			--i;
		}
		return tickets;
	}
}
