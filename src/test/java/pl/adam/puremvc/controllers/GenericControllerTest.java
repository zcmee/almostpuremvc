package pl.adam.puremvc.controllers;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import pl.adam.puremvc.PureMVCAppConfiguration;
import pl.adam.puremvc.PureMVCWebConfiguration;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(org.springframework.test.context.junit4.SpringRunner.class)
@ContextConfiguration(classes={PureMVCAppConfiguration.class, PureMVCWebConfiguration.class })
@WebAppConfiguration
public class GenericControllerTest {

    @Autowired
    private WebApplicationContext wac;
    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    //Test response http code
    @Test
    public void commentTest() throws Exception {
        mockMvc.perform(get("/mapping/valuetest")).andExpect(status().is2xxSuccessful());
    }

    @Test
    public void converterTest() throws Exception {
        mockMvc.perform(get("/conventer").param("range", "8-3"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(jsonPath("response").value("11"));
    }

    @Test
    public void satanTest() throws Exception {
        mockMvc.perform(get("/satantest"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("666"));
    }

    @Test //is Junit correctly configured ??
    public void okTest() {
        Assert.assertTrue(true);
    }


    @Test //404 http code
    public void notFoundCodeTest() throws Exception {
        mockMvc.perform(get("/error404"))
                .andExpect(status().is(HttpStatus.NOT_FOUND.value()));
    }

}
