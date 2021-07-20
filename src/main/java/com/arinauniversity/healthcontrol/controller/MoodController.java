package com.arinauniversity.healthcontrol.controller;

import com.arinauniversity.healthcontrol.model.Mood;
import com.arinauniversity.healthcontrol.service.MoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@RequestMapping("/moodDiary")
@RequiredArgsConstructor
public class MoodController {

    private final MoodService moodService;

    @GetMapping()
    public String getAllMood(Model model) {
        model.addAttribute("moods", moodService.getAllMoods());
        return "moodDiary/moods";
    }

    @GetMapping("/addMood")
    public String getCreateFormMood(@ModelAttribute("mood") Mood mood) {
        return "moodDiary/createFormMood";
    }

    @PostMapping("/addMood")
    public String addMood(@Valid Mood mood, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "moodDiary/createFormMood";
        }
        moodService.saveMood(mood);
        return "redirect:/moodDiary";
    }

    @GetMapping("/deleteMood/{id}")
    public String deleteMood(@PathVariable("id") int id) {
        moodService.deleteMoodById(id);
        return "redirect:/moodDiary";
    }

    @GetMapping("/editMood/{id}")
    public String getEditFormMood(@PathVariable("id") int id, Model model) {
        model.addAttribute("mood", moodService.getMoodById(id));
        return "moodDiary/editFormMood";
    }

    @PostMapping("/editMood")
    public String getEditFormMood(Mood mood) {
        moodService.editMood(mood);
        return "redirect:/moodDiary";
    }

    @GetMapping("/addRandomMood")
    public String addRandomMood(@RequestParam(value = "future", required = false) boolean future) {
        moodService.addRandomMood(future);
        return "redirect:/moodDiary";
    }

    @GetMapping("/addEstimation")
    public String addEstimation(HttpServletRequest httpServletRequest) {
        int value = Integer.parseInt(httpServletRequest.getParameter("value"));
        moodService.addEstimation(value);
        return "redirect:/moodDiary";
    }

}
