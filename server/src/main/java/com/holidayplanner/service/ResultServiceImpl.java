package com.holidayplanner.service;

import com.holidayplanner.model.Result;
import com.holidayplanner.repository.ResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ResultServiceImpl implements ResultService {

    @Autowired
    private ResultRepository resultRepository;

    @Override
    public List<Result> findAllResults() {
        return resultRepository.findAll();
    }

    @Override
    public Result findResultById(Long id) {
        return resultRepository.findById(id).orElse(null);
    }

    @Override
    public Result saveResult(Result result) {
        return resultRepository.save(result);
    }

    @Override
    public void deleteResultById(Long id) {
        resultRepository.deleteById(id);
    }

    @Override
    public void deleteAllResults() {
        resultRepository.deleteAll();
    }
}