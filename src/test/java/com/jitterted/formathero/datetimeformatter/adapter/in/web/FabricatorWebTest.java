package com.jitterted.formathero.datetimeformatter.adapter.in.web;

import com.jitterted.formathero.datetimeformatter.application.FabricatorService;
import com.jitterted.formathero.datetimeformatter.application.port.IdGenerator;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
@Tag("integration")
public class FabricatorWebTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    FabricatorService fabricatorService;

    @MockBean
    IdGenerator idGenerator;

    @Test
    public void getRootPathReturns200Ok() throws Exception {
        when(fabricatorService.currentExamples("windy-dolphin-73")).thenReturn(List.of("example"));
        mockMvc.perform(get("/?id=windy-dolphin-73"))
               .andExpect(status().isOk());
    }

    @Test
    public void postToAddPatternElementRedirects() throws Exception {
        mockMvc.perform(post("/fabricate")
                                .param("id", "frozen-unicorn-79")
                                .param("pattern", "yy"))
               .andExpect(status().is3xxRedirection());
    }
}
