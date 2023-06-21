package com.example.bai_5.repository;
import com.example.bai_5.model.FootballPlayer;

import java.util.List;

public interface IFootballPlayerRepository {
    List<FootballPlayer> findAll();
    FootballPlayer findById(int id);
    Boolean delete(int id);
    void create(FootballPlayer footballPlayer);
    Boolean edit(FootballPlayer footballPlayer);
}
