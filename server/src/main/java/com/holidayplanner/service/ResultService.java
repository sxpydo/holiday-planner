package com.holidayplanner.service;

import com.holidayplanner.model.Result;
import java.util.List;

public interface ResultService {
    List<Result> findAllResults();
    Result findResultById(Integer id);
    Result saveResult(Result result);
    void deleteResultById(Integer id);
    void deleteAllResults();
}