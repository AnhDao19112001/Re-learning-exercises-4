package com.example.bai_10.service;

import com.example.bai_10.model.Football;

import java.util.List;
import java.util.Optional;

public interface IFootballService {

    List<Football> findAll();
    Optional<Football> findById(int id);
}
