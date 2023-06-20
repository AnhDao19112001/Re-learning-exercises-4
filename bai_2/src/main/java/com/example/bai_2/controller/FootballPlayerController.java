package com.example.bai_2.controller;

import com.example.bai_2.service.IFootballPlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
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
    public String formInfo(@PathVariable int id, Model model){
        model.addAttribute("player",iFootballPlayerService.findById(id));
        return "info";
    }
    @GetMapping("/delete")
    private String delete(@RequestParam("idDelete") Integer id, RedirectAttributes redirectAttributes) {
        if (this.iFootballPlayerService.delete(id)) {
            redirectAttributes.addFlashAttribute("msg", "Xóa thành công!");
        }
        redirectAttributes.addFlashAttribute("msg","Không thể xóa hoặc không tồn tại!");
        return "redirect:/player";
    }
}
