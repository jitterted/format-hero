package dev.formathero.datetimeformatter.adapter.in.web;

import dev.formathero.datetimeformatter.SomeZonedDateTimes;
import dev.formathero.datetimeformatter.application.FabricatorService;
import dev.formathero.datetimeformatter.application.InMemoryFabricatorRepository;
import dev.formathero.datetimeformatter.application.StubIdGenerator;
import dev.formathero.datetimeformatter.domain.Fabricator;
import org.junit.jupiter.api.Test;
import org.springframework.ui.ConcurrentModel;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class FabricatorControllerIdTest {

    @Test
    public void mainViewWithoutIdThenRedirectsWithId() throws Exception {
        FabricatorService fabricatorService = new FabricatorService(new InMemoryFabricatorRepository(), List.of(SomeZonedDateTimes.JAN_9_2031));
        FabricatorController fabricatorController = new FabricatorController(fabricatorService, new StubIdGenerator());

        ConcurrentModel model = new ConcurrentModel();
        String redirectPage = fabricatorController.mainView(model, "");

        assertThat(redirectPage)
                .isEqualTo("redirect:/?id=windy-dolphin-73");
    }

    @Test
    public void mainViewWithIdThenReturnsPageWithContentForThatId() throws Exception {
        String windyDolphinPattern = "yyyy";
        String coldPenguinPattern = "MM";
        String coldPenguinId = "cold-penguin-23";
        InMemoryFabricatorRepository repo = new InMemoryFabricatorRepository();
        repo.save(Fabricator.EMPTY.with(coldPenguinPattern), coldPenguinId);
        repo.save(Fabricator.EMPTY.with(windyDolphinPattern), "windy-dolphin-73");

        FabricatorService fabricatorService = new FabricatorService(repo, List.of(SomeZonedDateTimes.JAN_9_2031));
        FabricatorController fabricatorController = new FabricatorController(fabricatorService, new StubIdGenerator());

        ConcurrentModel model = new ConcurrentModel();
        String page = fabricatorController.mainView(model, coldPenguinId);

        assertThat(page)
                .isEqualTo("fabricator");
        assertThat(model.getAttribute("id"))
                .isEqualTo(coldPenguinId);
        assertThat(model.getAttribute("pattern"))
                .isEqualTo(coldPenguinPattern);
    }
}
