package com.example.bai_7.service.impl;

import com.example.bai_7.model.Football;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

public interface IFootballService {
    Page<Football> findByNameContainsAndDateOfBirthBetween(String search, String fDate, String tDay, Pageable pageable);

    Page<Football> findByNameContains(String search, Pageable pageable);

    void create(Football football);

    void update(Football football);

    void delete(Football football);

    Football findById(Integer id);

}
