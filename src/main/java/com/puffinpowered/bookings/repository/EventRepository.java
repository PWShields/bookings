package com.puffinpowered.bookings.repository;

import com.puffinpowered.bookings.domain.Event;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends PagingAndSortingRepository<Event, Long>{

}
