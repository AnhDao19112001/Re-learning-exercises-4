package com.example.bai_2.repository;
import com.example.bai_2.model.FootballPlayer;

import java.util.List;

public interface IFootballPlayerRepository {
    List<FootballPlayer> findAll();
    FootballPlayer findById(int id);
    void delete(int id);
}
