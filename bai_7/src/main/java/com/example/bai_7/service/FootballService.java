package com.example.bai_7.service;

import com.example.bai_7.model.Football;
import com.example.bai_7.repository.IFootballRepository;
import com.example.bai_7.service.impl.IFootballService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class FootballService implements IFootballService {
    @Autowired
    private IFootballRepository iFootballRepository;
    @Override
    public Page<Football> findByNameContainsAndDateOfBirthBetween(String search, String fDate, String tDay, Pageable pageable) {
        return iFootballRepository.findByNameContainsAndDateOfBirthBetween(search,fDate,tDay,pageable);
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
    public void update(Football football) {
        iFootballRepository.save(football);
    }

    @Override
    public void delete(Football football) {
        iFootballRepository.delete(football);
    }

    @Override
    public Football findById(Integer id) {
        return iFootballRepository.findById(id).get();
    }
}
