package com.arinauniversity.healthcontrol.controller;

import com.arinauniversity.healthcontrol.exceptions.SqlInjectionException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ControllerAdvisor {

    @ExceptionHandler(SqlInjectionException.class)
    public String handle(SqlInjectionException exception, Model model) {
        model.addAttribute("exception", exception.getMessage());
        return "error/errorPage";
    }

}
