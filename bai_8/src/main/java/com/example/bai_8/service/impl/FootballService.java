package com.example.bai_8.service.impl;

import com.example.bai_8.model.Football;
import com.example.bai_8.repository.IFootballRepository;
import com.example.bai_8.service.IFootballService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FootballService implements IFootballService {
    @Autowired
    private IFootballRepository iFootballRepository;

    @Override
    public Page<Football> findByNameContainsAndDateOfBirthBetween(String search, String fDate, String tDay, Pageable pageable) {
        return iFootballRepository.findByNameContainsAndDateOfBirthBetween(search, fDate, tDay, pageable);
    }

    @Override
    public Page<Football> findByNameContains(String search, Pageable pageable) {
        return iFootballRepository.findByNameContains(search, pageable);
    }

    @Override
    public void create(Football football) {
        iFootballRepository.save(football);
    }

    @Override
    public void edit(Football football) {
        iFootballRepository.save(football);
    }

    @Override
    public void delete(int id) {
        iFootballRepository.deleteById(id);
    }

    @Override
    public Optional<Football> findById(int id) {
        return iFootballRepository.findById(id);
    }
}
