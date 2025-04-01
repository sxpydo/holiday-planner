package com.holidayplanner.service;

import com.holidayplanner.model.Journey;
import java.util.List;

public interface JourneyService {
    List<Journey> findAllJourneys();
    Journey findJourneyById(Integer id);
    Journey saveJourney(Journey journey);
    void deleteJourneyById(Integer id);
    void deleteAllJourneys();
}