package com.holidayplanner.service;

import com.holidayplanner.model.Journey;
import java.util.List;

public interface JourneyService {
    List<Journey> findAllJourneys();
    Journey findJourneyById(Long id);
    Journey saveJourney(Journey journey);
    void deleteJourneyById(Long id);
    void deleteAllJourneys();
}