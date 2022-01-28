package com.jitterted.datetimeformatter.adapter.in.web;

import org.junit.jupiter.api.Test;
import org.springframework.ui.ConcurrentModel;

import static org.assertj.core.api.Assertions.*;

class FabricatorControllerTest {

    @Test
    public void uponStartPatternAndExampleAreEmptyStrings() throws Exception {
        FabricatorController fabricatorController = new FabricatorController();

        ConcurrentModel model = new ConcurrentModel();
        String pageName = fabricatorController.mainView(model);

        assertThat(pageName)
                .isEqualTo("fabricator");

        assertThat((String) model.getAttribute("pattern"))
                .isEmpty();
        assertThat((String) model.getAttribute("example"))
                .isEmpty();
    }

//    @Test
//    public void add_4_Digit_Year_PatternIsYyyy() throws Exception {
//        FabricatorController fabricatorController = new FabricatorController();
//
//        ConcurrentModel model = new ConcurrentModel();
//        fabricatorController.mainView(model);
//
//        assertThat((String) model.getAttribute("pattern"))
//                .isEqualTo("yyyy");
//    }

}