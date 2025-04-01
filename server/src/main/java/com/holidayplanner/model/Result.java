package com.holidayplanner.model;

import jakarta.persistence.*;

@Entity
@Table(name = "results")
public class Result {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "journey_id")
    private int journeyId;

    @Column(name = "vehicle")
    private String vehicle;

    @Column(name = "return_cost")
    private double returnCost;

    @Column(name = "outbound_route")
    private String outboundRoute;

    @Column(name = "outbound_cost")
    private double outboundCost;

    @Column(name = "inbound_route")
    private String inboundRoute;

    @Column(name = "inbound_cost")
    private double inboundCost;

    @Column(name = "total_cost")
    private double totalCost;

    // Constructors
    public Result() {}

    public Result(int journeyId, String vehicle, double returnCost, String outboundRoute, double outboundCost, String inboundRoute, double inboundCost, double totalCost) {
        this.journeyId = journeyId;
        this.vehicle = vehicle;
        this.returnCost = returnCost;
        this.outboundRoute = outboundRoute;
        this.outboundCost = outboundCost;
        this.inboundRoute = inboundRoute;
        this.inboundCost = inboundCost;
        this.totalCost = totalCost;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getJourneyId() {
        return journeyId;
    }

    public void setJourneyId(int journeyId) {
        this.journeyId = journeyId;
    }

    public String getVehicle() {
        return vehicle;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }

    public double getReturnCost() {
        return returnCost;
    }

    public void setReturnCost(double returnCost) {
        this.returnCost = returnCost;
    }

    public String getOutboundRoute() {
        return outboundRoute;
    }

    public void setOutboundRoute(String outboundRoute) {
        this.outboundRoute = outboundRoute;
    }

    public double getOutboundCost() {
        return outboundCost;
    }

    public void setOutboundCost(double outboundCost) {
        this.outboundCost = outboundCost;
    }

    public String getInboundRoute() {
        return inboundRoute;
    }

    public void setInboundRoute(String inboundRoute) {
        this.inboundRoute = inboundRoute;
    }

    public double getInboundCost() {
        return inboundCost;
    }

    public void setInboundCost(double inboundCost) {
        this.inboundCost = inboundCost;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }
}