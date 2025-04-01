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
@RequestMapping("/api/journey")
public class JourneyController {

    @Autowired
    private JourneyService journeyService;

    @Autowired
    private CalculationService calculationService;

    @Autowired
    private ResultService resultService;


    @GetMapping("/")
    public List<Journey> findAllJourneys() {
        return journeyService.findAllJourneys();
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

    @PostMapping("/calculate")
    public Result calculateJourney(@RequestBody Journey journey) {
        Result result = calculationService.calculateJourneyResult(journey);

        // Save the journey and result
        journeyService.saveJourney(journey);
        resultService.saveResult(result); // Save the result

        return result;
    }
}