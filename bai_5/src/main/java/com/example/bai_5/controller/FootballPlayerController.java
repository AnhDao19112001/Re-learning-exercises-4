package com.example.bai_5.controller;

import com.example.bai_5.model.FootballPlayer;
import com.example.bai_5.service.IFootballPlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller

public class FootballPlayerController {
    @Autowired
    private IFootballPlayerService iFootballPlayerService;

    @GetMapping("/player")
    public String formFootball(Model model) {
        List<FootballPlayer> footballPlayers = iFootballPlayerService.findAll();
        model.addAttribute("player", footballPlayers);
        return "/list";
    }

    @GetMapping("/info/{id}")
    public String formInfo(@PathVariable int id, Model model, RedirectAttributes redirectAttributes) {
        if (iFootballPlayerService.findById(id) == null){
            redirectAttributes.addFlashAttribute("msg", "Không tìm thấy id!");
            return "redirect:/player";
        }
        model.addAttribute("player", iFootballPlayerService.findById(id));
        return "/view";
    }

    @GetMapping("/delete")
    private String delete(@RequestParam Integer idDelete, RedirectAttributes redirectAttributes) {
        if (iFootballPlayerService.delete(idDelete) == null){
            redirectAttributes.addFlashAttribute("msg","Không tìm thấy!");
            return "redirect:/player";
        }
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
    public String formUpdate(@PathVariable("id") int id, Model model, RedirectAttributes redirectAttributes){
        if (iFootballPlayerService.findById(id) == null){
            redirectAttributes.addFlashAttribute("msg","không tìm thấy");
            return "redirect:/player";
        }
        model.addAttribute("player", iFootballPlayerService.findById(id));
        return "/edit";
    }
    @PostMapping("/update")
    public String edit(@ModelAttribute FootballPlayer footballPlayer, RedirectAttributes redirectAttributes){
        iFootballPlayerService.edit(footballPlayer);
        redirectAttributes.addFlashAttribute("msg","Chỉnh sửa thành công!");
        return "redirect:/player";
    }
}
