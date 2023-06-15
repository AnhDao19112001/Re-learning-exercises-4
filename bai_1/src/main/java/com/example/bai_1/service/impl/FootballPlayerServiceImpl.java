package com.example.bai_1.service.impl;

import com.example.bai_1.model.FootballPlayer;
import com.example.bai_1.repository.IFootballPlayerRepository;
import com.example.bai_1.repository.impl.FootballPlayerImpl;
import com.example.bai_1.service.IFootballPlayerService;
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
}
