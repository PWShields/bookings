package com.puffinpowered.bookings.repository;

import com.puffinpowered.bookings.domain.Ticket;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends PagingAndSortingRepository<Ticket, Long>{
}
