package com.holidayplanner.service;

import com.holidayplanner.model.Journey;
import com.holidayplanner.model.Result;

public interface CalculationService {
    Result calculateJourneyResult(Journey journey);
}