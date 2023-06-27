package com.example.bai_9.repository;

import com.example.bai_9.model.Football;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IFootballRepository extends JpaRepository<Football, Integer> {
    Page<Football> findByNameContainsAndDateOfBirthBetween(String search, String fDate, String tDay, Pageable pageable);

    Page<Football> findByNameContains(String search, Pageable pageable);

    List<Football> findAllByStatusIsTrue();
}
