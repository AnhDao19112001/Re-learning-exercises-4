package com.example.bai_3.controller;

import com.example.bai_3.model.FootballPlayer;
import com.example.bai_3.service.IFootballPlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller

public class FootballPlayerController {
    @Autowired
    private IFootballPlayerService iFootballPlayerService;

    @GetMapping("/player")
    public String formFootball(Model model) {
        model.addAttribute("player", iFootballPlayerService.findAll());
        return "home";
    }

    @GetMapping("/info/{id}")
    public String formInfo(@PathVariable int id, Model model) {
        model.addAttribute("player", iFootballPlayerService.findById(id));
        return "info";
    }

    @GetMapping("/delete")
    private void delete(@RequestParam("idDelete") Integer id, RedirectAttributes redirectAttributes) {
        if (this.iFootballPlayerService.delete(id)) {
            redirectAttributes.addFlashAttribute("msg", "Xóa thành công!");
        }
        redirectAttributes.addFlashAttribute("msg","Không thể xóa hoặc không tồn tại!");
    }
    @GetMapping("/create")
    public String formCreate(Model model){
        model.addAttribute("player", new FootballPlayer());
        return "/create";
    }
    @PostMapping("/create")
    public String add(@ModelAttribute FootballPlayer footballPlayer){
        iFootballPlayerService.create(footballPlayer);
        return "redirect:/home";
    }
    @GetMapping("/update/{id}")
    public String formUpdate(@PathVariable("id") int id, Model model){
        model.addAttribute("player", iFootballPlayerService.findById(id));
        return "/update";
    }
    @PostMapping("/update")
    public String edit(@ModelAttribute FootballPlayer footballPlayer){
        iFootballPlayerService.edit(footballPlayer);
        return "redirect:/home";
    }
}
