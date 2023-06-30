package com.example.bai_11.service.impl;

import com.example.bai_11.model.Football;
import com.example.bai_11.repository.IFootballRepository;
import com.example.bai_11.service.IFootballService;
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
    public Optional<Football> findById(Integer id) {
        return iFootballRepository.findById(id);
    }

    @Override
    public Football create(Football football) {
        return iFootballRepository.save(football);
    }

    @Override
    public void delete(Integer id) {
        iFootballRepository.deleteById(id);
    }
}
