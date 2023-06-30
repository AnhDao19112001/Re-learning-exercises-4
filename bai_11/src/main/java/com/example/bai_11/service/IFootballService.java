package com.example.bai_11.service;

import com.example.bai_11.model.Football;

import java.util.List;
import java.util.Optional;

public interface IFootballService {
    List<Football> findAll();
    Optional<Football> findById(Integer id);
    Football create(Football football);
    void delete (Integer id);
}
