package com.holidayplanner.service;

import com.holidayplanner.model.Result;
import java.util.List;

public interface ResultService {
    List<Result> findAllResults();
    Result findResultById(Long id);
    Result saveResult(Result result);
    void deleteResultById(Long id);
    void deleteAllResults();
}