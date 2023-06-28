package com.example.bai_10.dto;

import java.util.HashMap;
import java.util.Map;

public class FavoritePlayerDto {
    private Map<FootballDto, Integer> footballDtoIntegerMap = new HashMap<>();

    public FavoritePlayerDto() {
    }

    public FavoritePlayerDto(Map<FootballDto, Integer> footballDtoIntegerMap) {
        this.footballDtoIntegerMap = footballDtoIntegerMap;
    }

    public Map<FootballDto, Integer> getFootballDtoIntegerMap() {
        return footballDtoIntegerMap;
    }

    public void setFootballDtoIntegerMap(Map<FootballDto, Integer> footballDtoIntegerMap) {
        this.footballDtoIntegerMap = footballDtoIntegerMap;
    }
    public void addFavoritePlayer(FootballDto footballDto) {
        if (footballDtoIntegerMap.containsKey(footballDto)) {
            Integer view = footballDtoIntegerMap.get(footballDto);
            footballDtoIntegerMap.replace(footballDto, view +1);
        } else {
            footballDtoIntegerMap.put(footballDto,1);
        }
    }
}
