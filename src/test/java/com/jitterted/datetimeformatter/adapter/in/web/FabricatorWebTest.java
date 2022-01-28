package com.jitterted.datetimeformatter.adapter.in.web;

import com.jitterted.datetimeformatter.application.FabricatorService;
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

    @Test
    public void getRootPathReturns200Ok() throws Exception {
        when(fabricatorService.currentExamples()).thenReturn(List.of("example"));
        mockMvc.perform(get("/"))
               .andExpect(status().isOk());
    }

    @Test
    public void postToAddPatternElementRedirects() throws Exception {
        mockMvc.perform(post("/fabricate")
                                .param("pattern", "yy"))
               .andExpect(status().is3xxRedirection());
    }
}
