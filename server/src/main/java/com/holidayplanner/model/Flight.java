package com.holidayplanner.model;

import jakarta.persistence.*;

@Entity
@Table(name = "flights")
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "departure_airport")
    private String departureAirport;

    @Column(name = "destination_airport")
    private String destinationAirport;

    @Column(name = "distance")
    private int distance;

    // Constructors
    public Flight() {}

    public Flight(String departureAirport, String destinationAirport, int distance) {
        this.departureAirport = departureAirport;
        this.destinationAirport = destinationAirport;
        this.distance = distance;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }
}