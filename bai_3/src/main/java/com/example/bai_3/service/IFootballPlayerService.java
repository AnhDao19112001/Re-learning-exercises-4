package com.example.bai_3.service;

import com.example.bai_3.model.FootballPlayer;

import java.util.List;

public interface IFootballPlayerService {
    List<FootballPlayer> findAll();
    FootballPlayer findById(int id);
    boolean delete(int id);
    void create(FootballPlayer footballPlayer);
    void edit (FootballPlayer footballPlayer);
}
