package com.jitterted.datetimeformatter.adapter.in.web;

import com.jitterted.datetimeformatter.application.FabricatorService;
import com.jitterted.datetimeformatter.domain.ZonedDateTimeFactory;
import org.junit.jupiter.api.Test;
import org.springframework.ui.ConcurrentModel;

import java.time.ZonedDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class FabricatorControllerTest {

    private static final ZonedDateTime JAN_9_2031 = ZonedDateTimeFactory.zoneDateTimeUtc(2031, 1, 9);

    @Test
    public void uponStartPatternAndExampleAreEmptyStrings() throws Exception {
        FabricatorService fabricatorService = new FabricatorService(List.of(JAN_9_2031));
        FabricatorController fabricatorController = new FabricatorController(fabricatorService);

        ConcurrentModel model = new ConcurrentModel();
        String pageName = fabricatorController.mainView(model);

        assertThat(pageName)
                .isEqualTo("fabricator");

        assertThat((String) model.getAttribute("pattern"))
                .isEmpty();
        List<String> examples = (List<String>) model.getAttribute("examples");
        assertThat(examples)
                .containsExactly("");
    }

    @Test
    public void add_4_Digit_Year_PatternIsYyyy() throws Exception {
        FabricatorService fabricatorService = new FabricatorService(List.of(JAN_9_2031));
        FabricatorController fabricatorController =
                new FabricatorController(fabricatorService);

        fabricatorController.fabricate("yyyy");

        ConcurrentModel model = new ConcurrentModel();
        fabricatorController.mainView(model);

        assertThat((String) model.getAttribute("pattern"))
                .isEqualTo("yyyy");
        List<String> examples = (List<String>) model.getAttribute("examples");
        assertThat(examples)
                .containsExactly("2031");
    }

}