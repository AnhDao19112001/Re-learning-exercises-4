package com.example.bai_7.repository;

import com.example.bai_7.model.Football;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IFootballRepository extends JpaRepository<Football, Integer> {
    //    @Query(value = "select * from Football where name like %:searchByName% and dateOfBirth like %:searchByDOB",nativeQuery = true)
//    Page<Football> searchByFootball(@Param("searchByName") String name,
//                                    @Param("searchByDOB") String dateOfBirth,
//                                    Pageable pageable);
    Page<Football> findByNameContainsAndDateOfBirthBetween(String search, String fDate, String tDay, Pageable pageable);

    Page<Football> findByNameContains(String search, Pageable pageable);
}
