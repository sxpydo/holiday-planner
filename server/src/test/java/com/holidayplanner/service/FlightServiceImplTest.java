package com.holidayplanner.service;

import com.holidayplanner.model.Flight;
import com.holidayplanner.repository.FlightRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

class FlightServiceImplTest {

    @Mock
    private FlightRepository flightRepository;

    @InjectMocks
    private FlightServiceImpl flightService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void findAllFlights_shouldReturnAllFlights() {
        // Arrange
        Flight flight1 = new Flight();
        flight1.setId(1);
        flight1.setDepartureAirport("A");
        flight1.setDestinationAirport("B");
        flight1.setDistance(100);

        Flight flight2 = new Flight();
        flight2.setId(2);
        flight2.setDepartureAirport("B");
        flight2.setDestinationAirport("C");
        flight2.setDistance(200);

        List<Flight> expectedFlights = Arrays.asList(flight1, flight2);

        when(flightRepository.findAll()).thenReturn(expectedFlights);

        // Act
        List<Flight> actualFlights = flightService.findAllFlights();

        // Assert
        assertEquals(expectedFlights.size(), actualFlights.size());
        assertEquals(expectedFlights.get(0).getId(), actualFlights.get(0).getId());
        assertEquals(expectedFlights.get(1).getId(), actualFlights.get(1).getId());
        verify(flightRepository, times(1)).findAll();
    }

    @Test
    void getFlightById_shouldReturnFlightWhenIdExists() {
        // Arrange
        Flight flight = new Flight();
        flight.setId(1);
        flight.setDepartureAirport("A");
        flight.setDestinationAirport("B");
        flight.setDistance(100);

        when(flightRepository.findById(1)).thenReturn(Optional.of(flight));

        // Act
        Flight actualFlight = flightService.findFlightById(1);

        // Assert
        assertNotNull(actualFlight);
        assertEquals(flight.getId(), actualFlight.getId());
        verify(flightRepository, times(1)).findById(1);
    }

    @Test
    void saveFlight_shouldSaveAndReturnFlight() {
        // Arrange
        Flight flight = new Flight();
        flight.setDepartureAirport("A");
        flight.setDestinationAirport("B");
        flight.setDistance(100);

        when(flightRepository.save(flight)).thenReturn(flight);

        // Act
        Flight savedFlight = flightService.saveFlight(flight);

        // Assert
        assertNotNull(savedFlight);
        assertEquals(flight.getDepartureAirport(), savedFlight.getDepartureAirport());
        verify(flightRepository, times(1)).save(flight);
    }

    @Test
    void deleteFlight_shouldDeleteFlightById() {
        // Arrange
        Integer flightId = 1;

        // Act
        flightService.deleteFlightById(flightId);

        // Assert
        verify(flightRepository, times(1)).deleteById(flightId);
    }

    @Test
    void deleteAllFlights_shouldDeleteAllFlights() {
        // Act
        flightService.deleteAllFlights();

        // Assert
        verify(flightRepository, times(1)).deleteAll();
    }
}
