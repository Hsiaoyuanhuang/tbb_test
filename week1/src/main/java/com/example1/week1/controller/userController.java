package com.example1.week1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

@Controller
public class userController {

    @RequestMapping("/MyFirstPage")
    public String greeting(@RequestParam(value = "title", required = false, defaultValue = "week1作業") String title,
            Model model) {
        model.addAttribute("name", title);
        return "index";
    }

}