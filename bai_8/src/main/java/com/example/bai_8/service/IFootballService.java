package com.example.bai_8.service;

import com.example.bai_8.model.Football;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IFootballService {
    Page<Football> findByNameContainsAndDateOfBirthBetween(String search, String fDate, String tDay, Pageable pageable);

    Page<Football> findByNameContains(String search, Pageable pageable);
    void create(Football football);
    void edit(Football football);
    void delete(int id);
    Optional<Football> findById(int id);
}
