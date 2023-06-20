package com.example.bai_4.repository;
import com.example.bai_4.model.FootballPlayer;

import java.util.List;

public interface IFootballPlayerRepository {
    List<FootballPlayer> findAll();
    FootballPlayer findById(int id);
    void delete(int id);
    void create(FootballPlayer footballPlayer);
    void edit(FootballPlayer footballPlayer);
}
