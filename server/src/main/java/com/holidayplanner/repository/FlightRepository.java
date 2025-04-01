package com.holidayplanner.repository;

import com.holidayplanner.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Integer> {

    // Find all flights from a given departure airport
    List<Flight> findByDeparture(String departure);

    // Find all flights to a given destination airport
    List<Flight> findByDestination(String destination);

    // Find a flight by departure and destination
    Flight findByDepartureAndDestination(String departure, String destination);

    List<Object[]> findShortestRoute(
            @Param("startAirport") String startAirport,
            @Param("endAirport") String endAirport
    );

    // Find all flights
    @Query("SELECT f FROM Flight f")
    List<Flight> findAllFlights();
}
