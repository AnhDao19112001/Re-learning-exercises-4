package com.example.bai_4.controller;

import com.example.bai_4.model.FootballPlayer;
import com.example.bai_4.service.IFootballPlayerService;
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
        return "/list";
    }

    @GetMapping("/info/{id}")
    public String formInfo(@PathVariable int id, Model model) {
        model.addAttribute("player", iFootballPlayerService.findById(id));
        return "/view";
    }

    @GetMapping("/delete")
    private String delete(@RequestParam Integer idDelete, RedirectAttributes redirectAttributes) {
        iFootballPlayerService.delete(idDelete);
        redirectAttributes.addFlashAttribute("msg","Xóa thành công!");
        return "redirect:/player";
    }
    @GetMapping("/create")
    public String formCreate(Model model){
        model.addAttribute("player", new FootballPlayer());
        return "/create";
    }
    @PostMapping("/save")
    public String add(@ModelAttribute FootballPlayer footballPlayer, RedirectAttributes redirectAttributes){
        iFootballPlayerService.create(footballPlayer);
        redirectAttributes.addFlashAttribute("msg", "Thêm mới thành công!");
        return "redirect:/player";
    }
    @GetMapping("/update/{id}")
    public String formUpdate(@PathVariable("id") int id, Model model){
        model.addAttribute("player", iFootballPlayerService.findById(id));
        return "/edit";
    }
    @PostMapping("/update")
    public String edit(@ModelAttribute FootballPlayer footballPlayer, RedirectAttributes redirectAttributes){
        iFootballPlayerService.edit(footballPlayer);
        redirectAttributes.addFlashAttribute("msg", "Chỉnh sửa thành công!");
        return "redirect:/player";
    }
}
