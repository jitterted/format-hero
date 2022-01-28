package com.jitterted.datetimeformatter.adapter.in.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

// INBOUND ADAPTER
@Controller
public class FabricatorController {

    @GetMapping("/")
    public String mainView(Model model) {
        model.addAttribute("pattern", "");
        model.addAttribute("example", "");
        return "fabricator";
    }

    @PostMapping("/fabricate")
    public String fabricate() {
        return "redirect:/";
    }
}
