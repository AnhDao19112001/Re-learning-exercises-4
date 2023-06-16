package com.example.bai_2.service;

import com.example.bai_2.model.FootballPlayer;

import java.util.List;

public interface IFootballPlayerService {
    List<FootballPlayer> findAll();
    FootballPlayer findById(int id);
    void delete(int id);
}
