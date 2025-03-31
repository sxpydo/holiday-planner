package com.holidayplanner.controller;

import com.holidayplanner.model.Journey;
import com.holidayplanner.model.Result;
import com.holidayplanner.service.JourneyService;
import com.holidayplanner.service.CalculationService;
import com.holidayplanner.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/journeys")
public class JourneyController {

    @Autowired
    private JourneyService journeyService;

    @Autowired
    private CalculationService calculationService;

    @Autowired
    private ResultService resultService;

    @GetMapping("/")
    public String home() {
        return "Welcome to the Holiday Planner API!";
    }

    @GetMapping("/findbyid/{id}")
    public Journey findJourneyById(@PathVariable Long id) {
        return journeyService.findJourneyById(id);
    }

    @GetMapping("/findall")
    public List<Journey> findAllJourneys() {
        return journeyService.findAllJourneys();
    }

    @DeleteMapping("/delete/{id}")
    public String deleteJourney(@PathVariable Long id) {
        journeyService.deleteJourneyById(id);
        return "Journey with ID " + id + " has been deleted.";
    }

    @DeleteMapping("/deleteall")
    public String deleteAllJourneys() {
        journeyService.deleteAllJourneys();
        return "All journeys have been deleted.";
    }

    @PostMapping("/calculate")
    public Result calculateJourney(@RequestBody Journey journey) {
        Result result = calculationService.calculateJourneyResult(journey);

        // Save the journey and result
        journeyService.saveJourney(journey);
        resultService.saveResult(result); // Save the result

        return result;
    }
}