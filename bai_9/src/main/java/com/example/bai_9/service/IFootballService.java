package com.example.bai_9.service;

import com.example.bai_9.model.Football;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IFootballService {
    Page<Football> findByNameContainsAndDateOfBirthBetween(String search, String fDate, String tDay, Pageable pageable);

    Page<Football> findByNameContains(String search, Pageable pageable);
    void create(Football football);
    void edit(Football football);
    void delete(int id);

    List<Football> findAll();

    List<Football> findAllByStatusIsTrue();

    Optional<Football> findById(int id);
}
