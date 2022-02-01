package com.jitterted.formathero.datetimeformatter.adapter.in.web;

import com.jitterted.formathero.datetimeformatter.application.FabricatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

// INBOUND ADAPTER
@Controller
public class FabricatorController {

    private final FabricatorService fabricatorService;

    @Autowired
    public FabricatorController(FabricatorService fabricatorService) {
        this.fabricatorService = fabricatorService;
    }

    @GetMapping("/")
    public String mainView(Model model, @RequestParam(value = "id", defaultValue = "") String id) {
        if (id.isBlank()) {
            return "redirect:/?id=windy-dolphin-73";
        }
        model.addAttribute("pattern", fabricatorService.currentPattern());
        model.addAttribute("examples", fabricatorService.currentExamples());
        model.addAttribute("id", id);
        return "fabricator";
    }

    @PostMapping("/fabricate")
    public String fabricate(@RequestParam("pattern") String patternElement) {
        fabricatorService.withPatternElement(patternElement);
        return "redirect:/";
    }
}
