package com.arinauniversity.healthcontrol.model;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping()
    public String start() {
        return "start";
    }

}
