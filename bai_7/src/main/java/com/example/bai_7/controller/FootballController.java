package com.example.bai_7.controller;

import com.example.bai_7.model.Football;
import com.example.bai_7.service.impl.IFootballService;
import com.example.bai_7.service.impl.ITeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.persistence.ManyToOne;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
public class FootballController {
    @Autowired
    private ITeamService iTeamService;
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
        model.addAttribute("teamList", iTeamService.findAll());
        model.addAttribute("football", new Football());
        return "/list";
    }

    @GetMapping("/create")
    public String formCreate(Model model) {
        model.addAttribute("football", new Football());
        model.addAttribute("teamList", iTeamService.findAll());
        return "/create";
    }

    @PostMapping("/save")
    public String save(Football football, RedirectAttributes redirectAttributes) {
        iFootballService.create(football);
        redirectAttributes.addFlashAttribute("msg", "Them moi thanh cong!");
        return "redirect:/player";
    }

    @GetMapping("/info/{id}")
    public String formInfoFootball(@PathVariable int id, Model model) {
        model.addAttribute("football", iFootballService.findById(id));
        model.addAttribute("teamList", iTeamService.findAll());
        return "/info";
    }

    @GetMapping("/edit/{id}")
    public String formEdit(@PathVariable int id, Model model) {
        model.addAttribute("football", iFootballService.findById(id));
        model.addAttribute("teamList", iTeamService.findAll());
        return "/update";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Football football, RedirectAttributes redirectAttributes) {
        iFootballService.update(football);
        redirectAttributes.addFlashAttribute("msg", "Sua thanh cong!");
        return "redirect:/player";
    }

    @PostMapping("/delete")
    public String delete(@ModelAttribute Football football, RedirectAttributes redirectAttributes) {
        iFootballService.delete(football);
        redirectAttributes.addFlashAttribute("msg", "Xoa thanh cong");
        return "redirect:/player";
    }
}
