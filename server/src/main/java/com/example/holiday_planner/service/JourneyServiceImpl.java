package com.holidayplanner.service;

import com.holidayplanner.model.Journey;
import com.holidayplanner.repository.JourneyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class JourneyServiceImpl implements JourneyService {

    @Autowired
    private JourneyRepository journeyRepository;

    @Override
    public List<Journey> findAllJourneys() {
        return journeyRepository.findAll();
    }

    @Override
    public Journey findJourneyById(Long id) {
        return journeyRepository.findById(id).orElse(null);
    }

    @Override
    public Journey saveJourney(Journey journey) {
        return journeyRepository.save(journey);
    }

    @Override
    public void deleteJourneyById(Long id) {
        journeyRepository.deleteById(id);
    }

    @Override
    public void deleteAllJourneys() {
        journeyRepository.deleteAll();
    }
}