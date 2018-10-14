package com.puffinpowered.bookings;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class BookingsApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookingsApplication.class, args);
    }
}
