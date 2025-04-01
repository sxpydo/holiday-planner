package com.holidayplanner.service;

import com.holidayplanner.model.Result;
import com.holidayplanner.repository.ResultRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResultServiceImpl implements ResultService {

    private final ResultRepository resultRepository;

    public ResultServiceImpl(ResultRepository resultRepository) {
        this.resultRepository = resultRepository;
    }

    @Override
    public List<Result> findAllResults() {
        return resultRepository.findAll();
    }

    @Override
    public Result findResultById(Integer id) {
        Optional<Result> result = resultRepository.findById(id);
        return result.orElseThrow(() -> new RuntimeException("Result not found with id: " + id));
    }

    @Override
    public Result saveResult(Result result) {
        return resultRepository.save(result);
    }

    @Override
    public void deleteResultById(Integer id) {
        resultRepository.deleteById(id);
    }

    @Override
    public void deleteAllResults() {
        resultRepository.deleteAll();
    }
}
