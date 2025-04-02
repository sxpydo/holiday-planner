package com.holidayplanner.controller;

import com.holidayplanner.model.Journey;
import com.holidayplanner.service.JourneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/journey")
public class JourneyController {

    @Autowired
    private JourneyService journeyService;

    @GetMapping("/")
    public List<Journey> findAllJourneys() {
        return journeyService.findAllJourneys();
    }

    @PostMapping("/")
    public ResponseEntity<Journey> createJourney(@RequestBody Journey journey) {
        Journey savedJourney = journeyService.saveJourney(journey);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedJourney);
    }

    @GetMapping("/{id}")
    public Journey findJourneyById(@PathVariable Integer id) {
        return journeyService.findJourneyById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteJourney(@PathVariable Integer id) {
        journeyService.deleteJourneyById(id);
        return "Journey with ID " + id + " has been deleted.";
    }
}