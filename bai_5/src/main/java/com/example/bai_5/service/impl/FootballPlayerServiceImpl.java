package com.example.bai_5.service.impl;

import com.example.bai_5.model.FootballPlayer;
import com.example.bai_5.repository.IFootballPlayerRepository;
import com.example.bai_5.service.IFootballPlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FootballPlayerServiceImpl implements IFootballPlayerService {
    @Autowired
    private IFootballPlayerRepository iFootballPlayerRepository;

    @Override
    public List<FootballPlayer> findAll() {
        return iFootballPlayerRepository.findAll();
    }

    @Override
    public FootballPlayer findById(int id) {
        return iFootballPlayerRepository.findById(id);
    }

    @Override
    public Boolean delete(int id) {
        return this.iFootballPlayerRepository.delete(id);
    }

    @Override
    public void create(FootballPlayer footballPlayer) {
        iFootballPlayerRepository.create(footballPlayer);
    }

    @Override
    public boolean edit(FootballPlayer footballPlayer) {
        return this.iFootballPlayerRepository.edit(footballPlayer);
    }
}
