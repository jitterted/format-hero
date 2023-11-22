package dev.formathero.datetimeformatter.adapter.in.web;

import dev.formathero.datetimeformatter.SomeZonedDateTimes;
import dev.formathero.datetimeformatter.adapter.out.caffeine.CaffeineFabricatorRepository;
import dev.formathero.datetimeformatter.application.FabricatorService;
import dev.formathero.datetimeformatter.application.StubIdGenerator;
import dev.formathero.datetimeformatter.application.port.FabricatorRepository;
import org.junit.jupiter.api.Test;
import org.springframework.ui.ConcurrentModel;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class FabricatorControllerTest {

    @Test
    void uponStartPatternAndExampleAreEmptyStrings() throws Exception {
        FabricatorRepository fabricatorRepository = new CaffeineFabricatorRepository();
        FabricatorService fabricatorService = new FabricatorService(fabricatorRepository, List.of(SomeZonedDateTimes.JAN_9_2031));
        FabricatorController fabricatorController = new FabricatorController(fabricatorService, new StubIdGenerator());

        ConcurrentModel model = new ConcurrentModel();
        String pageName = fabricatorController.mainView(model, "windy-dolphin-73");

        assertThat(pageName)
                .isEqualTo("fabricator");

        assertThat((String) model.getAttribute("pattern"))
                .isEmpty();
        List<String> examples = (List<String>) model.getAttribute("examples");
        assertThat(examples)
                .containsExactly("");
    }

    @Test
    void add_4_Digit_Year_PatternIsYyyy() throws Exception {
        FabricatorRepository fabricatorRepository = new CaffeineFabricatorRepository();
        FabricatorService fabricatorService = new FabricatorService(
                fabricatorRepository,
                List.of(SomeZonedDateTimes.JAN_9_2031));
        FabricatorController fabricatorController =
                new FabricatorController(fabricatorService, new StubIdGenerator());
        String id = "blue-penguin-22";

        String page = fabricatorController.fabricate("yyyy", id);

        assertThat(page)
                .isEqualTo("redirect:/?id=" + id);

        ConcurrentModel model = new ConcurrentModel();
        fabricatorController.mainView(model, id);
        assertThat((String) model.getAttribute("pattern"))
                .isEqualTo("yyyy");
        List<String> examples = (List<String>) model.getAttribute("examples");
        assertThat(examples)
                .containsExactly("2031");
    }

}