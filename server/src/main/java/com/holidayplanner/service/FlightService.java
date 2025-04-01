package com.holidayplanner.service;

import com.holidayplanner.model.Flight;
import java.util.List;

public interface FlightService {
    List<Flight> findAllFlights();
    Flight findFlightById(Integer id);
    Flight saveFlight(Flight flight);
    void deleteFlightById(Integer id);
    void deleteAllFlights();
}