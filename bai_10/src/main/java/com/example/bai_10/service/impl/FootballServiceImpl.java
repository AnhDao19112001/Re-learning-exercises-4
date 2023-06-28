package com.example.bai_10.service.impl;

import com.example.bai_10.model.Football;
import com.example.bai_10.repository.IFootballRepository;
import com.example.bai_10.service.IFootballService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FootballServiceImpl implements IFootballService {
    @Autowired
    private IFootballRepository iFootballRepository;

    @Override
    public List<Football> findAll() {
        return iFootballRepository.findAll();
    }

    @Override
    public Optional<Football> findById(int id) {
        return iFootballRepository.findById(id);
    }
}
