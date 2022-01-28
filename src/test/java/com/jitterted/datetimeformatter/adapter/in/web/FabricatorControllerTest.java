package com.jitterted.datetimeformatter.adapter.in.web;

import com.jitterted.datetimeformatter.application.FabricatorService;
import org.junit.jupiter.api.Test;
import org.springframework.ui.ConcurrentModel;

import static org.assertj.core.api.Assertions.*;

class FabricatorControllerTest {

    @Test
    public void uponStartPatternAndExampleAreEmptyStrings() throws Exception {
        FabricatorService fabricatorService = new FabricatorService();
        FabricatorController fabricatorController = new FabricatorController(fabricatorService);

        ConcurrentModel model = new ConcurrentModel();
        String pageName = fabricatorController.mainView(model);

        assertThat(pageName)
                .isEqualTo("fabricator");

        assertThat((String) model.getAttribute("pattern"))
                .isEmpty();
        assertThat((String) model.getAttribute("example"))
                .isEmpty();
    }

    @Test
    public void add_4_Digit_Year_PatternIsYyyy() throws Exception {
        FabricatorService fabricatorService = new FabricatorService();
        FabricatorController fabricatorController = new FabricatorController(fabricatorService);

        fabricatorController.fabricate("yyyy");

        String pattern = fabricatorService.currentPattern();
        assertThat(pattern)
                .isEqualTo("yyyy");
    }

}