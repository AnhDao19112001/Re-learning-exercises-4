package com.example.bai_1.repository;

import com.example.bai_1.model.FootballPlayer;

import java.util.List;

public interface IFootballPlayerRepository {
    List<FootballPlayer> findAll();
}
