package com.example.bai_7.model;

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
    @ManyToOne
    @JoinColumn(name = "id_team",referencedColumnName = "id")
    private Team team;

    public Football() {
    }

    public Football(Integer id, String name, String dateOfBirth, String experience, String location, String image, Team team) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.experience = experience;
        this.location = location;
        this.image = image;
        this.team = team;
    }

    public Football(String name, String dateOfBirth, String experience, String location, String image, Team team) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.experience = experience;
        this.location = location;
        this.image = image;
        this.team = team;
    }

    public Football(String name, String dateOfBirth, String experience, String location, String image) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.experience = experience;
        this.location = location;
        this.image = image;
    }

    public Football(Integer id, String name, String dateOfBirth, String experience, String location, String image) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.experience = experience;
        this.location = location;
        this.image = image;
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

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
