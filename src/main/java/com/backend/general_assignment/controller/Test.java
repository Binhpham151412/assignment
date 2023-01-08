package com.backend.general_assignment.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Test {
    @GetMapping("/test")
    public ModelAndView test1() {
        return new ModelAndView("test");
    }
}
