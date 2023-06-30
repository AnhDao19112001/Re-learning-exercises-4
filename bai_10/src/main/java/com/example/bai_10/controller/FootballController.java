package com.example.bai_10.controller;

import com.example.bai_10.dto.FavoritePlayerDto;
import com.example.bai_10.dto.FootballDto;
import com.example.bai_10.model.Football;
import com.example.bai_10.service.IFootballService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Controller
@SessionAttributes("favorite")
@RequestMapping("/player")
public class FootballController {
    @Autowired
    private IFootballService iFootballService;

    @ModelAttribute("favorite")
    public FavoritePlayerDto setUpFavorite(){
        return new FavoritePlayerDto();
    }
    @GetMapping("")
    public String formListPlayer(Model model, @CookieValue(value = "playerId" ,required = false,defaultValue = "-1") int id){
        model.addAttribute("football",iFootballService.findAll());
        return "/football/list";
    }
    @GetMapping("/info/{id}")
    public String detail(@PathVariable int id, Model model) {
        model.addAttribute("soccer", iFootballService.findById(id));
        return "football/info";
    }
    @GetMapping("/add/{id}")
    public String addFavorite(@PathVariable int id, @SessionAttribute("favorite") FavoritePlayerDto favoritePlayerDto,
                              HttpServletResponse response) {

        int num=response.getStatus();
        for (Football football:iFootballService.findAll()) {
            if (iFootballService.findById(id).isPresent()){
                football.setStatus(football.getStatus()+1);
            }
        }

        Football football = iFootballService.findById(id).get();
        FootballDto footballDto = new FootballDto();
        BeanUtils.copyProperties(football, footballDto);
        favoritePlayerDto.addFavoritePlayer(footballDto);


        Cookie cookie = new Cookie("soccerId", id + "");
        cookie.setMaxAge(1 * 24 * 60 * 60);
        cookie.setPath("/favorite");
        response.addCookie(cookie);

        return "redirect:/favorite";
    }
}
