package com.example.bai_11.repository;

import com.example.bai_11.model.Football;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFootballRepository extends JpaRepository<Football, Integer> {
}
