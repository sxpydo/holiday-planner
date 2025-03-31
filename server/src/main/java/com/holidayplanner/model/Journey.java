package com.holidayplanner.model;

import javax.persistence.*;

@Entity
@Table(name = "journeys")
public class Journey {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "passengers")
    private int passengers;

    @Column(name = "home_to_airport_distance")
    private int homeToAirportDistance;

    @Column(name = "departure_airport")
    private String departureAirport;

    @Column(name = "destination_airport")
    private String destinationAirport;

    // Constructors
    public Journey() {}

    public Journey(int passengers, int homeToAirportDistance, String departureAirport, String destinationAirport) {
        this.passengers = passengers;
        this.homeToAirportDistance = homeToAirportDistance;
        this.departureAirport = departureAirport;
        this.destinationAirport = destinationAirport;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getPassengers() {
        return passengers;
    }

    public void setPassengers(int passengers) {
        this.passengers = passengers;
    }

    public int getHomeToAirportDistance() {
        return homeToAirportDistance;
    }

    public void setHomeToAirportDistance(int homeToAirportDistance) {
        this.homeToAirportDistance = homeToAirportDistance;
    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    public void setDepartureAirport(String departureAirport) {
        this.departureAirport = departureAirport;
    }

    public String getDestinationAirport() {
        return destinationAirport;
    }

    public void setDestinationAirport(String destinationAirport) {
        this.destinationAirport = destinationAirport;
    }
}