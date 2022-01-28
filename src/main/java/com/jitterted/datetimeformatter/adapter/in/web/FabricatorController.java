package com.jitterted.datetimeformatter.adapter.in.web;

import com.jitterted.datetimeformatter.application.FabricatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

// INBOUND ADAPTER
@Controller
public class FabricatorController {

    private final FabricatorService fabricatorService;

    @Autowired
    public FabricatorController(FabricatorService fabricatorService) {
        this.fabricatorService = fabricatorService;
    }

    @GetMapping("/")
    public String mainView(Model model) {
        model.addAttribute("pattern", fabricatorService.currentPattern());
        model.addAttribute("example", "");
        return "fabricator";
    }

    @PostMapping("/fabricate")
    public String fabricate(String patternElement) {
        fabricatorService.withPatternElement(patternElement);
        return "redirect:/";
    }
}
