package pl.adam.puremvc.controllers;


import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import pl.adam.puremvc.services.IssueService;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


public class MockitoControllerTest {
    private MockMvc mockMvc;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(issueController).build();
    }

    @Mock
    private IssueController issueController;

    @Test
    public void MockSatanTest() throws Exception {
        when(issueController.satanTest()).thenReturn(66);
        mockMvc.perform(get("/satantest"))
                .andDo(print())
                .andExpect(status().isOk());
    }

}
