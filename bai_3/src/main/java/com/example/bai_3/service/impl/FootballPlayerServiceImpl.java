package com.example.bai_3.service.impl;

import com.example.bai_3.model.FootballPlayer;
import com.example.bai_3.repository.IFootballPlayerRepository;
import com.example.bai_3.service.IFootballPlayerService;
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
    public boolean delete(int id) {
        if (this.iFootballPlayerRepository.delete(id)){
            return true;
        }
        return false;
    }

    @Override
    public void create(FootballPlayer footballPlayer) {
        iFootballPlayerRepository.create(footballPlayer);
    }

    @Override
    public void edit(FootballPlayer footballPlayer) {
        iFootballPlayerRepository.edit(footballPlayer);
    }
}
