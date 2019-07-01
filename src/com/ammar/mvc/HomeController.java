package com.ammar.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
    @RequestMapping("/")
    public String showMyPage() {
        return "index";
    }

    @RequestMapping("ShowForm")
    public String showForm() {
        return ("index-form");
    }

    @RequestMapping("processForm")
    public String processForm(@RequestParam("studentName") String theName, Model model) {
        String name = theName;
        name = name.toUpperCase();
        String result = name + "request working";
        model.addAttribute("message", result);

        return ("index-processForm");
    }

}
