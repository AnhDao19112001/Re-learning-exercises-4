package com.example.bai_9.repository;

import com.example.bai_9.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITeamRepository extends JpaRepository<Team, Integer> {
}
