package com.example.bai_7.service;

import com.example.bai_7.model.Team;
import com.example.bai_7.repository.IFootballRepository;
import com.example.bai_7.repository.ITeamRepository;
import com.example.bai_7.service.impl.ITeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService implements ITeamService {
    @Autowired
    private ITeamRepository iTeamRepository;
    @Override
    public List<Team> findAll() {
        return iTeamRepository.findAll();
    }
}
