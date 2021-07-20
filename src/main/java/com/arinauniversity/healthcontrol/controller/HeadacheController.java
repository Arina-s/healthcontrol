package com.arinauniversity.healthcontrol.controller;

import com.arinauniversity.healthcontrol.model.Headache;
import com.arinauniversity.healthcontrol.model.Tablet;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@RequestMapping("/headacheDiary")
public class HeadacheController {

    private static int count = 3;

    private List<Headache> headaches = new ArrayList<>(Arrays.asList(
            new Headache(1, "02.10.2020", 4, 6, new Tablet("-", 0)),
            new Headache(2, "03.05.2021", 3, 2, new Tablet("-", 0)),
            new Headache(3, "15.06.2021", 6, 12, new Tablet("nurofen", 2))
    ));

    @RequestMapping(value = "/headaches", method = RequestMethod.GET)
    public String getAllHeadaches(Model model) {
        headaches.sort(Comparator.comparingInt(Headache::getId));
        model.addAttribute("headaches", headaches);
        return "headacheDiary/headaches";
    }

    @GetMapping("/addHeadache")
    public String getCreateFormHeadache(@ModelAttribute("headache") Headache headache) {
        headache.setId(++count);
        return "headacheDiary/createFormHeadache";
    }

    @PostMapping("/addHeadache")
    public String addHeadache(Headache headache) {
        headaches.add(headache);
        return "redirect:/headacheDiary/headaches";
    }

    @GetMapping("/deleteHeadache/{id}")
    public String deleteHeadache(@PathVariable("id") int id) {
        headaches.removeIf(headache -> headache.getId() == id);
        return "redirect:/headacheDiary/headaches";
    }

    @GetMapping("/editHeadache/{id}")
    public String updateHeadache(@PathVariable("id") int id, Model model) {
        Headache headache = headaches.stream()
                .filter(obj -> obj.getId() == id)
                .findFirst()
                .orElse(null);
        model.addAttribute("headache", headache);
        return "headacheDiary/editFormHeadache";
    }

    @PostMapping("/editHeadache")
    public String updateHeadache(Headache headache) {
        headaches.removeIf(h -> h.getId() == headache.getId());
        headaches.add(headache);
        return "redirect:/headacheDiary/headaches";
    }


}
