package com.example.bai_9.service.impl;

import com.example.bai_9.model.Team;
import com.example.bai_9.repository.ITeamRepository;
import com.example.bai_9.service.ITeamService;
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
