package com.holidayplanner.repository;

import com.holidayplanner.model.Journey;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JourneyRepository extends JpaRepository<Journey, Long> {
    // Find journeys by destination airport
    List<Journey> findByDestinationAirport(String destinationAirport);

    // Find journeys by the number of passengers
    List<Journey> findByPassengers(int passengers);

}