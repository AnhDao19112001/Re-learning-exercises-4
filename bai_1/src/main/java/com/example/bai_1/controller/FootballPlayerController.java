package com.example.bai_1.controller;

import com.example.bai_1.service.IFootballPlayerService;
import com.example.bai_1.service.impl.FootballPlayerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class FootballPlayerController {
    @Autowired
    private IFootballPlayerService iFootballPlayerService;
    @GetMapping("/player")
    public String formFootball(Model model) {
        model.addAttribute("player", iFootballPlayerService.findAll());
        return "/home";
    }
}
