package com.puffinpowered.bookings.repository;

import com.puffinpowered.bookings.domain.Ticket;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface TicketRepository extends PagingAndSortingRepository<Ticket, Long>{

	@Query("Select t from Ticket t where event_id = (:id)")
	Set<Ticket> fetchAllTicketsForEvent(@Param("id")long l);
}
