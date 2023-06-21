package com.example.bai_5.service;

import com.example.bai_5.model.FootballPlayer;

import java.util.List;

public interface IFootballPlayerService {
    List<FootballPlayer> findAll();
    FootballPlayer findById(int id);
    Boolean delete(int id);
    void create(FootballPlayer footballPlayer);
    boolean edit (FootballPlayer footballPlayer);
}
