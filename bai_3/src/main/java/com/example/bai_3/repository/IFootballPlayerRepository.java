package com.example.bai_3.repository;
import com.example.bai_3.model.FootballPlayer;

import java.util.List;

public interface IFootballPlayerRepository {
    List<FootballPlayer> findAll();
    FootballPlayer findById(int id);
    boolean delete(int id);
    void create(FootballPlayer footballPlayer);
    void edit(FootballPlayer footballPlayer);
}
