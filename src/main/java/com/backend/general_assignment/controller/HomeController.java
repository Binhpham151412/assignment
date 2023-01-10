package com.backend.general_assignment.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/home")
    public String home() {
        return "redirect:/su-dung-dich-vu/tat-ca-thong-tin";
    }
}
