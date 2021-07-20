package com.arinauniversity.healthcontrol.controller;

import com.arinauniversity.healthcontrol.model.Headache;
import com.arinauniversity.healthcontrol.service.HeadacheService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/headacheDiary")
@RequiredArgsConstructor
public class HeadacheController {

    private final HeadacheService headacheService;

    @RequestMapping(value = "/headaches", method = RequestMethod.GET)
    public String getAllHeadaches(Model model) {
        model.addAttribute("headaches", headacheService.getHeadaches());
        return "headacheDiary/headaches";
    }

    @GetMapping("/addHeadache")
    public String getCreateFormHeadache(@ModelAttribute("headache") Headache headache) {
        return "headacheDiary/createFormHeadache";
    }

    @PostMapping("/addHeadache")
    public String addHeadache(Headache headache) {
        headacheService.addHeadache(headache);
        return "redirect:/headacheDiary/headaches";
    }

    @GetMapping("/deleteHeadache/{id}")
    public String deleteHeadache(@PathVariable("id") int id) {
        headacheService.deleteHeadacheById(id);
        return "redirect:/headacheDiary/headaches";
    }

    @GetMapping("/editHeadache/{id}")
    public String updateHeadache(@PathVariable("id") int id, Model model) {
        Headache headache = headacheService.getHeadacheById(id);
        model.addAttribute("headache", headache);
        return "headacheDiary/editFormHeadache";
    }

    @PostMapping("/editHeadache")
    public String updateHeadache(Headache headache) {
       headacheService.updateHeadache(headache);
        return "redirect:/headacheDiary/headaches";
    }


}
