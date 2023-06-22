package com.example.bai_6.controller;

import com.example.bai_6.model.Football;
import com.example.bai_6.service.IFootballService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
public class FootballController {
    @Autowired
    private IFootballService iFootballService;
    @GetMapping("/player")
    public String showFormFootball(Model model, @RequestParam(required = false, defaultValue = "") String search,
                                   @RequestParam(required = false) @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate fDate,
                                   @RequestParam(required = false) @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate tDate,
                                   @RequestParam(required = false) Integer pageIn, Pageable pageable) {
        int pageSize = pageable.getPageSize();
        if (pageIn != null && pageIn > 0) {
            pageSize = pageIn;
        }

        Sort sort = search.isEmpty() ? Sort.by("dateOfBirth").ascending() : Sort.by("name").ascending();
        Page<Football> footballPage;
        String fromStr = null;
        String toStr = null;
        if (fDate != null && tDate != null) {
            fromStr = fDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            toStr = tDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            footballPage = iFootballService.findByNameContainsAndDateOfBirthBetween(search, fromStr, toStr, PageRequest.of(
                    pageable.getPageNumber(), pageSize, sort));
        } else {
            footballPage = iFootballService.findByNameContains(search, PageRequest.of(pageable.getPageNumber(), pageSize, sort));
        }
        model.addAttribute("footballPage", footballPage);
        List<Integer> pageNumberList;
        int currentPage = pageable.getPageNumber() + 1;
        int totalRecords = (int) footballPage.getTotalElements();

        pageable = PageRequest.of(currentPage - 1, pageSize, sort);
        Page<?> page = new PageImpl<>(Collections.emptyList(), pageable, totalRecords);
        pageNumberList = IntStream.rangeClosed(
                1, page.getTotalPages()).boxed().collect(Collectors.toList());
        model.addAttribute("pageNumberList", pageNumberList);
        model.addAttribute("football", new Football());
        return "/list";
    }
    @PostMapping("/delete")
    private String delete(@RequestParam("idDelete") Integer id, RedirectAttributes redirectAttributes) {
        Football soccerPlayer = this.iFootballService.findById(id);
        this.iFootballService.delete(soccerPlayer);
        redirectAttributes.addFlashAttribute("message", "Delete Success");
        return "redirect:/player";
    }

    @GetMapping("/info/{id}")
    private String showDetails(@RequestParam("id") Integer id, Model model) {
        model.addAttribute("player", iFootballService.findById(id));
        return "/view";
    }

    @GetMapping("/create")
    public String formCreate(Model model){
        model.addAttribute("player", new Football());
        return "/create";
    }

    @PostMapping("/create")
    public String createSoccerPlayer(@ModelAttribute Football football, RedirectAttributes redirectAttributes) {
        iFootballService.create(football);
        redirectAttributes.addFlashAttribute("msg","Add player success!");
        return "redirect:/list";
    }

    @GetMapping("/update/{id}")
    public String showUpdateSoccerPlayer(@PathVariable("id") int id, Model model) {
        model.addAttribute("player", iFootballService.findById(id));
        return "/edit";
    }

    @PostMapping("/update")
    public String updateSoccerPlayer(@ModelAttribute Football soccerPlayer, RedirectAttributes redirectAttributes) {
        iFootballService.update(soccerPlayer);
        redirectAttributes.addFlashAttribute("msg","Update success!");
        return "redirect:/player";
    }
}
