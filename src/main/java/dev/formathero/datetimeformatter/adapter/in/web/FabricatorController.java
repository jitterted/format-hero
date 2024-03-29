package dev.formathero.datetimeformatter.adapter.in.web;

import dev.formathero.datetimeformatter.application.FabricatorService;
import dev.formathero.datetimeformatter.application.port.IdGenerator;
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
    private final IdGenerator idGenerator;

    @Autowired
    public FabricatorController(FabricatorService fabricatorService,
                                IdGenerator idGenerator) {
        this.fabricatorService = fabricatorService;
        this.idGenerator = idGenerator;
    }

    @GetMapping("/")
    public String mainView(Model model, @RequestParam(defaultValue = "") String id) {
        if (id.isBlank()) {
            return "redirect:/?id=" + idGenerator.newId();
        }
        model.addAttribute("pattern", fabricatorService.patternFor(id));
        model.addAttribute("examples", fabricatorService.currentExamples(id));
        model.addAttribute("id", id);
        return "fabricator";
    }

    @PostMapping("/fabricate")
    public String fabricate(@RequestParam("pattern") String patternElement,
                            @RequestParam String id) {
        fabricatorService.withPatternElement(patternElement, id);
        return "redirect:/?id=" + id;
    }

}
