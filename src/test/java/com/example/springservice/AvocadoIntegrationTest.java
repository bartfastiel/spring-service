package com.example.springservice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.math.BigDecimal;

@SpringBootTest
@AutoConfigureMockMvc
public class AvocadoIntegrationTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private AvocadoRepository repository;

    @DirtiesContext
    @Test
    void expectListOfAvocados_whenCallingHttpGet() throws Exception {

        repository.save(new Avocado("1", "brown", BigDecimal.valueOf(2)));
        repository.save(new Avocado("2", "green", BigDecimal.valueOf(3)));

        mvc.perform(MockMvcRequestBuilders.get("/api/avocados"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(
                        """
                        [
                            {
                                "color": "brown"
                            },
                            {
                                "color": "green"
                            }
                        ]
"""
                ));
    }

}







