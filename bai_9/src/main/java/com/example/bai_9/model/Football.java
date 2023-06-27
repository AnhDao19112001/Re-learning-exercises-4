package com.example.bai_9.model;

import javax.persistence.*;

@Entity
public class Football {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String dateOfBirth;
    private String experience;
    private String location;
    private String image;
    private boolean status;
    @ManyToOne
    @JoinColumn(name = "id_team",referencedColumnName = "id")
    private Team team;

    public Football() {
    }

    public Football(Integer id, String name, String dateOfBirth, String experience, String location, String image, boolean status, Team team) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.experience = experience;
        this.location = location;
        this.image = image;
        this.status = status;
        this.team = team;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
