package com.holidayplanner.repository;

import com.holidayplanner.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {

    // Find all flights from a given departure airport
    List<Flight> findByDeparture(String departure);

    // Find all flights to a given destination airport
    List<Flight> findByDestination(String destination);

    // Find a flight by departure and destination
    Flight findByDepartureAndDestination(String departure, String destination);

    // Find the shortest route between two airports using a recursive query
    @Query(value = """
        WITH RECURSIVE ShortestPath AS (
            SELECT
                f.departure AS start_airport,
                f.destination AS end_airport,
                f.distance AS total_distance,
                CAST(f.departure || '--' || f.destination AS VARCHAR) AS route
            FROM
                Flight f
            WHERE
                f.departure = :startAirport
            UNION ALL
            SELECT
                sp.start_airport,
                f.destination,
                sp.total_distance + f.distance,
                sp.route || '--' || f.destination
            FROM
                ShortestPath sp
                JOIN Flight f ON sp.end_airport = f.departure
            WHERE NOT sp.route LIKE '%' || f.destination || '%'
        )
        SELECT
            sp.route,
            sp.total_distance
        FROM
            ShortestPath sp
        WHERE
            sp.end_airport = :endAirport
        ORDER BY
            sp.total_distance
        LIMIT 1
        """, nativeQuery = true)
    List<Object[]> findShortestRoute(
            @Param("startAirport") String startAirport,
            @Param("endAirport") String endAirport
    );

    // Find all flights
    @Query("SELECT f FROM Flight f")
    List<Flight> findAllFlights();
}
