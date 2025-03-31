package com.holidayplanner.service;

import com.holidayplanner.model.Flight;
import java.util.List;

public interface FlightService {
    List<Flight> findAllFlights();
    Flight findFlightById(Long id);
    Flight saveFlight(Flight flight);
    void deleteFlightById(Long id);
    void deleteAllFlights();
}