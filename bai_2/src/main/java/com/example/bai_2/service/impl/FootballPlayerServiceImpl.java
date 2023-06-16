package com.example.bai_2.service.impl;

import com.example.bai_2.model.FootballPlayer;
import com.example.bai_2.repository.IFootballPlayerRepository;
import com.example.bai_2.service.IFootballPlayerService;
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
    public void delete(int id) {
        iFootballPlayerRepository.delete(id);
    }
}