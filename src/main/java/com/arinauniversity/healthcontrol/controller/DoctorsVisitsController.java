package com.arinauniversity.healthcontrol.controller;

import com.arinauniversity.healthcontrol.model.DoctorVisit;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

@Controller
@RequestMapping("doctorsVisits")
public class DoctorsVisitsController {

    private static int count = 3;

    private List<DoctorVisit> doctorsVisits = new ArrayList<>(Arrays.asList(
            new DoctorVisit(1, 3, 4, 2021, "dentist", "Tihon", "19:00", "1/2"),
            new DoctorVisit(2, 23, 5, 2021, "optometrist", "Kamilova", "14:30", ""),
            new DoctorVisit(3, 15, 5, 2021, "dentist", "Tihon", "18:00", "2/2")
    ));

    @GetMapping()
    public String getAllDoctorVisits(Model model, HttpServletRequest request) {
        doctorsVisits.sort(Comparator.comparingInt(DoctorVisit::getId));
        model.addAttribute("doctorsVisits", doctorsVisits);
        return "doctorsVisits/doctorsVisits";
    }

    @GetMapping("/editDoctorVisit/{id}")
    public String getEditFormDoctorVisit(Model model, @PathVariable int id) {
        DoctorVisit editVisit = doctorsVisits.stream()
                .filter(visit -> visit.getId() == id)
                .findAny()
                .orElse(null);
        model.addAttribute("doctorsVisits", doctorsVisits);
        model.addAttribute("editVisit", editVisit);
        return "doctorsVisits/editDoctorVisit";
    }

    @PostMapping("/editDoctorVisit")
    public String editDoctorVisit(DoctorVisit doctorVisit) {
        doctorsVisits.removeIf(visit -> visit.getId() == doctorVisit.getId());
        doctorsVisits.add(doctorVisit);
        return "redirect:/doctorsVisits";
    }

    @GetMapping("/deleteDoctorVisit/{id}")
    public String deleteDoctorVisit(@PathVariable int id) {
        doctorsVisits.removeIf(visit -> visit.getId() == id);
        return "redirect:/doctorsVisits";
    }

    @GetMapping("/addDoctorVisit")
    public String addDoctorVisit(@ModelAttribute("doctorVisit") DoctorVisit doctorVisit, Model model) {
        doctorVisit.setId(++count);
        model.addAttribute("doctorsVisits", doctorsVisits);
        return "doctorsVisits/createDoctorVisit";
    }

    @PostMapping("/addDoctorVisit")
    public String saveDoctorVisit(DoctorVisit doctorVisit, HttpServletRequest request) {
        doctorsVisits.add(doctorVisit);
        return "redirect:/doctorsVisits";
    }

}
