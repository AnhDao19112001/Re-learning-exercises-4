package com.example.bai_10.dto;

import org.omg.CORBA.PUBLIC_MEMBER;

import java.util.Objects;

public class FootballDto {
    private int id;
    private String name;
    private String dateOfBirth;
    private String experience;
    private String location;
    private String image;
    private boolean status;

    public FootballDto() {
    }

    public FootballDto(int id, String name, String dateOfBirth, String experience, String location, String image, boolean status) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.experience = experience;
        this.location = location;
        this.image = image;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
    @Override
    public boolean equals(Object o){
        if (this == o){
            return true;
        }else {
            if (o == null || getClass() != o.getClass())
                return false;
        }
        FootballDto footballDto = (FootballDto) o;
        return id == footballDto.id;
    }
    @Override
    public int hashCode(){
        return Objects.hash(id);
    }
}
