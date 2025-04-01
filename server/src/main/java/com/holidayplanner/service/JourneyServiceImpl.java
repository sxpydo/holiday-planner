package com.holidayplanner.service;

import com.holidayplanner.model.Journey;
import com.holidayplanner.repository.JourneyRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JourneyServiceImpl implements JourneyService {

    private final JourneyRepository journeyRepository;

    public JourneyServiceImpl(JourneyRepository journeyRepository) {
        this.journeyRepository = journeyRepository;
    }

    @Override
    public List<Journey> findAllJourneys() {
        return journeyRepository.findAll();
    }

    @Override
    public Journey findJourneyById(Integer id) {
        Optional<Journey> journey = journeyRepository.findById(id);
        return journey.orElseThrow(() -> new RuntimeException("Journey not found with id: " + id));
    }

    @Override
    public Journey saveJourney(Journey journey) {
        return journeyRepository.save(journey);
    }

    @Override
    public void deleteJourneyById(Integer id) {
        journeyRepository.deleteById(id);
    }

    @Override
    public void deleteAllJourneys() {
        journeyRepository.deleteAll();
    }
}
