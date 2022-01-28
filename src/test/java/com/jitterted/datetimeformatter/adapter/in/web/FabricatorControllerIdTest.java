package com.jitterted.datetimeformatter.adapter.in.web;

import com.jitterted.datetimeformatter.SomeZonedDateTimes;
import com.jitterted.datetimeformatter.application.FabricatorService;
import org.junit.jupiter.api.Test;
import org.springframework.ui.ConcurrentModel;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class FabricatorControllerIdTest {

    @Test
    public void mainViewWithoutIdThenRedirectsWithId() throws Exception {
        FabricatorService fabricatorService = new FabricatorService(List.of(SomeZonedDateTimes.JAN_9_2031));
        FabricatorController fabricatorController = new FabricatorController(fabricatorService);

        ConcurrentModel model = new ConcurrentModel();
        String redirectPage = fabricatorController.mainView(model, "");

        assertThat(redirectPage)
                .isEqualTo("redirect:/?id=windy-dolphin-73");
    }
}
