package com.example.bai_8.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name_team;

    @OneToMany(mappedBy = "team")
    private List<Football> footballs;

    public Team() {
    }

    public Team(int id, String name_team, List<Football> footballs) {
        this.id = id;
        this.name_team = name_team;
        this.footballs = footballs;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName_team() {
        return name_team;
    }

    public void setName_team(String name_team) {
        this.name_team = name_team;
    }

    public List<Football> getFootballs() {
        return footballs;
    }

    public void setFootballs(List<Football> footballs) {
        this.footballs = footballs;
    }
}
