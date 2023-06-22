package com.example.bai_6.service;

import com.example.bai_6.model.Football;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IFootballService {
    Page<Football> findByNameContainsAndDateOfBirthBetween(String search, String fDate, String tDay, Pageable pageable);
    Page<Football> findByNameContains(String search, Pageable pageable);
    void create(Football football);
    void update(Football football);

    void delete(Football football);

    Football findById(Integer id);
}
