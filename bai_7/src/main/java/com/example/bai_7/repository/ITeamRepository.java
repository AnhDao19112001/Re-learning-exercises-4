package com.example.bai_7.repository;

import com.example.bai_7.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITeamRepository extends JpaRepository<Team, Integer> {
}
