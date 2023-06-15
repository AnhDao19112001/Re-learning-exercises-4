package com.example.bai_1.repository.impl;

import com.example.bai_1.model.FootballPlayer;
import com.example.bai_1.repository.IFootballPlayerRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class FootballPlayerImpl implements IFootballPlayerRepository {
    private static List<FootballPlayer> playerList = new ArrayList<>();
    static {
        playerList.add(new FootballPlayer(1,"Anh Đào","19-11-2001","2 năm","Hậu vệ","123"));
        playerList.add(new FootballPlayer(2,"Anh Đào","19-11-2001","2 năm","Trung vệ","123"));
        playerList.add(new FootballPlayer(3,"Anh Đào","19-11-2001","2 năm","Tiền vệ","123"));
        playerList.add(new FootballPlayer(4,"Anh Đào","19-11-2001","2 năm","Tiền đạo","123"));
        playerList.add(new FootballPlayer(5,"Anh Đào","19-11-2001","2 năm","Tiền vệ vệ","123"));
        playerList.add(new FootballPlayer(6,"Anh Đào","19-11-2001","2 năm","Thủ môn","123"));
    }
    @Override
    public List<FootballPlayer> findAll() {
        return playerList;
    }
}
