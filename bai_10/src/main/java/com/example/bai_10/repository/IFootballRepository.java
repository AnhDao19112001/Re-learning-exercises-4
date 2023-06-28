package com.example.bai_10.repository;

import com.example.bai_10.model.Football;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFootballRepository extends JpaRepository<Football, Integer> {
}
