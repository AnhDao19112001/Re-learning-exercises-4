package com.example.bai_8.controller;

import com.example.bai_8.dto.FootballDto;
import com.example.bai_8.model.Football;
import com.example.bai_8.model.Team;
import com.example.bai_8.service.IFootballService;
import com.example.bai_8.service.ITeamService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
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
    @Autowired
    private ITeamService iTeamService;

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
            fromStr = fDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            toStr = tDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
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
        model.addAttribute("football", new FootballDto());
        return "/list";
    }

    @PostMapping("/delete")
    public String deleteFootball(@RequestParam("idDelete") int id, RedirectAttributes redirectAttributes) {
        iFootballService.delete(id);
        redirectAttributes.addFlashAttribute("msg", "Delete success!");
        return "redirect:/player";
    }

    @GetMapping("/create")
    public String getCreateForm(Model model) {
        model.addAttribute("footballDto", new FootballDto());
        model.addAttribute("teams", iTeamService.findAll());
        return "/create";
    }

    @PostMapping("/add")
    public String create(@Valid @ModelAttribute FootballDto footballDto, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {
        new FootballDto().validate(footballDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("teams", iTeamService.findAll());
            return "/create";
        }
        Football football = new Football();
        BeanUtils.copyProperties(footballDto, football);
        iFootballService.create(football);
        redirectAttributes.addFlashAttribute("mess", "thêm mới thành công!");
        return "redirect:/player";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable int id, Model model) {
        FootballDto footballDto = new FootballDto();
        Football football = iFootballService.findById(id).get();
        BeanUtils.copyProperties(football, footballDto);
        model.addAttribute("footballDto", footballDto);
        return "/update";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute @Validated FootballDto footballDto,
                         BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        new FootballDto().validate(footballDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return "/update";
        }
        Football football = new Football();
        BeanUtils.copyProperties(footballDto, football);
        iFootballService.edit(football);
        redirectAttributes.addFlashAttribute("msg", "Chỉnh sửa thành công!");
        return "redirect:/player";
    }
    @GetMapping("/info/{id}")
    private String showDetails(@RequestParam("id") Integer id, Model model) {
        model.addAttribute("footballDto", iFootballService.findById(id));
        return "/info";
    }
}
