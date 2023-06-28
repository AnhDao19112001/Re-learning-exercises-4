package com.example.bai_10.controller;

import com.example.bai_10.dto.FavoritePlayerDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FavoriteController {
    @GetMapping("/favorite")
    public ModelAndView showFavorite(@SessionAttribute(name = "favorite") FavoritePlayerDto favoritePlayerDto) {
        return new ModelAndView("favorite/list", "favorite", favoritePlayerDto);
    }
}
