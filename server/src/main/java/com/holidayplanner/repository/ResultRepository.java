package com.holidayplanner.repository;

import com.holidayplanner.model.Result;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResultRepository extends JpaRepository<Result, Long> {
    // Find results by journey ID
    List<Result> findByJourneyId(Long journeyId);

    // Find results by vehicle type
    List<Result> findByVehicle(String vehicle);

}
