package com.arinauniversity.healthcontrol.controller;

import com.arinauniversity.healthcontrol.model.Headache;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/headacheDiary")
public class HeadacheController {

    private List<Headache> headaches = new ArrayList<>(Arrays.asList(
            new Headache(1, "02.10.2020", 4, 6),
            new Headache(2, "03.05.2021", 3, 2),
            new Headache(3, "15.06.2021", 6, 12)
    ));

    @GetMapping("/headaches")
    public String getAllHeadaches(Model model) {
        model.addAttribute("headaches", headaches);
        return "headacheDiary/headaches";
    }

    @GetMapping("/addHeadache")
    public String getCreateFormHeadache(Model model, Headache headache) {
        model.addAttribute("headache", headache);
        return "headacheDiary/createFormHeadache";
    }

    @PostMapping("/addHeadache")
    public String addHeadache(Headache headache) {
        headaches.add(headache);
        return "redirect:headaches";
    }

}
