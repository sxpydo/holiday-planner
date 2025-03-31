package com.holidayplanner.service;

import com.holidayplanner.model.Flight;
import com.holidayplanner.model.Journey;
import com.holidayplanner.model.Result;
import com.holidayplanner.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

@Service
public class CalculationServiceImpl implements CalculationService {

    @Autowired
    private FlightRepository flightRepository;

    @Override
    public Result calculateJourneyResult(Journey journey) {
        Result result = new Result();
        result.setJourneyId(journey.getId());

        calculateVehicleCost(journey, result);
        calculateFlightCostsAndRoutes(journey, result);
        result.setTotalCost(result.getReturnCost() + result.getOutboundCost() + result.getInboundCost());

        return result;
    }

    private void calculateVehicleCost(Journey journey, Result result) {
        int passengers = journey.getPassengers();
        int distance = journey.getHomeToAirportDistance();

        if (passengers <= 4) {
            result.setVehicle("Car");
            result.setReturnCost(distance * 0.2 + 3);
        } else {
            result.setVehicle("Taxi");
            result.setReturnCost(distance * 0.4 * Math.ceil((double) passengers / 4));
        }
    }

    private void calculateFlightCostsAndRoutes(Journey journey, Result result) {
        String departureAirport = journey.getDepartureAirport();
        String destinationAirport = journey.getDestinationAirport();

        List<Flight> allFlights = flightRepository.findAll();
        Map<String, List<Flight>> graph = buildGraph(allFlights);

        List<String> outboundRoute = dijkstra(graph, departureAirport, destinationAirport);
        List<String> inboundRoute = dijkstra(graph, destinationAirport, departureAirport);

        if (outboundRoute != null && inboundRoute != null) {
            result.setOutboundRoute(String.join(" -> ", outboundRoute));
            result.setOutboundCost(calculateRouteCost(graph, outboundRoute));
            result.setInboundRoute(String.join(" -> ", inboundRoute));
            result.setInboundCost(calculateRouteCost(graph, inboundRoute));
        } else {
            result.setOutboundRoute("No valid route found");
            result.setOutboundCost(0.0);
            result.setInboundRoute("No valid route found");
            result.setInboundCost(0.0);
        }
    }

    private Map<String, List<Flight>> buildGraph(List<Flight> flights) {
        Map<String, List<Flight>> graph = new HashMap<>();
        for (Flight flight : flights) {
            graph.computeIfAbsent(flight.getDepartureAirport(), k -> new ArrayList<>()).add(flight);
        }
        return graph;
    }

    private List<String> dijkstra(Map<String, List<Flight>> graph, String start, String end) {
        Map<String, Integer> distances = new HashMap<>();
        Map<String, String> previous = new HashMap<>();
        PriorityQueue<String> queue = new PriorityQueue<>((a, b) -> distances.getOrDefault(a, Integer.MAX_VALUE) - distances.getOrDefault(b, Integer.MAX_VALUE));

        distances.put(start, 0);
        queue.add(start);

        while (!queue.isEmpty()) {
            String current = queue.poll();
            if (current.equals(end)) {
                break;
            }

            for (Flight neighborFlight : graph.getOrDefault(current, new ArrayList<>())) {
                String neighbor = neighborFlight.getDestinationAirport();
                int newDistance = distances.getOrDefault(current, Integer.MAX_VALUE) + neighborFlight.getDistance();

                if (newDistance < distances.getOrDefault(neighbor, Integer.MAX_VALUE)) {
                    distances.put(neighbor, newDistance);
                    previous.put(neighbor, current);
                    queue.add(neighbor);
                }
            }
        }

        if (!previous.containsKey(end)) {
            return null; // No path found
        }

        List<String> path = new ArrayList<>();
        String current = end;
        while (current != null) {
            path.add(0, current);
            current = previous.get(current);
        }
        return path;
    }

    private double calculateRouteCost(Map<String, List<Flight>> graph, List<String> route) {
        double cost = 0.0;
        for (int i = 0; i < route.size() - 1; i++) {
            String current = route.get(i);
            String next = route.get(i + 1);
            for (Flight flight : graph.getOrDefault(current, new ArrayList<>())) {
                if (flight.getDestinationAirport().equals(next)) {
                    cost += flight.getDistance() * 0.1; // Example cost per distance
                    break;
                }
            }
        }
        return cost;
    }
}