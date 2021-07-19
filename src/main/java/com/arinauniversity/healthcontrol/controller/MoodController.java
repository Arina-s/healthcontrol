package com.arinauniversity.healthcontrol.controller;

import com.arinauniversity.healthcontrol.model.Mood;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Controller
@RequestMapping("/moodDiary")
public class MoodController {

    private static int count = 3;

    private List<Mood> moods = new ArrayList<>(Arrays.asList(
            new Mood(1, "2.05.20", 5),
            new Mood(2, "26.03.20", 2),
            new Mood(3, "17.07.20", 4)
    ));

    @GetMapping()
    public String getAllMood(Model model) {
        moods.sort(Comparator.comparingInt(Mood::getId));
        model.addAttribute("moods", moods);
        return "moodDiary/moods";
    }

    @GetMapping("/addMood")
    public String getCreateFormMood(@ModelAttribute("mood") Mood mood) {
        mood.setId(++count);
        return "moodDiary/createFormMood";
    }

    @PostMapping("/addMood")
    public String addMood(Mood mood) {
        moods.add(mood);
        return "redirect:/moodDiary";
    }

    @GetMapping("/deleteMood/{id}")
    public String deleteMood(@PathVariable("id") int id) {
        moods.removeIf(mood -> mood.getId() == id);
        return "redirect:/moodDiary";
    }

    @GetMapping("/editMood/{id}")
    public String getEditFormMood(@PathVariable("id") int id, Model model) {
        Mood mood = moods.stream()
                .filter(obj -> obj.getId() == id)
                .findFirst()
                .orElse(null);
        model.addAttribute("mood", mood);
        return "moodDiary/editFormMood";
    }

    @PostMapping("/editMood")
    public String getEditFormMood(Mood mood) {
        moods.removeIf(obj -> obj.getId() == mood.getId());
        moods.add(mood);
        return "redirect:/moodDiary";
    }

    @GetMapping("/addRandomMood")
    public String addRandomMood(@RequestParam(value = "future", required = false) boolean future) {
        Mood mood = new Mood();
        mood.setId(++count);
        int day = new Random().nextInt(31);
        int month = new Random().nextInt(12);
        int year = new Random().nextInt(11) + 2010;
        if (future) {
            year += 10;
        }
        int estimation = 1 + new Random().nextInt(5);
        mood.setDate(String.format("%s.%s.%s", day, month, year));
        mood.setEstimation(estimation);
        moods.add(mood);
        return "redirect:/moodDiary";
    }

    @GetMapping("/addEstimation")
    public String addEstimation(HttpServletRequest httpServletRequest) {
        int value = Integer.parseInt(httpServletRequest.getParameter("value"));
        moods.forEach(mood -> {
            if (mood.getEstimation() + value <= 5) {
                int estimation = mood.getEstimation();
                mood.setEstimation(estimation + value);
            }
        });
        return "redirect:/moodDiary";
    }

}
