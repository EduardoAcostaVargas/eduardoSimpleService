package org.example.eduardosimpleservice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class EduardoSimpleServiceApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void contextLoads() {
    }

    @Test
    void getAllShoes() throws Exception {
        mockMvc.perform(get("/shoes"))
                .andExpect(status().isOk());
    }

    @Test
    void addShoe() throws Exception {
        String newShoe = """
                {
                    "brand": "Test Shoe",
                    "model": "Test Model",
                    "price": 125.99,
                    "shoeSize": 11
                }
                """;

        mockMvc.perform(post("/shoes")
                .contentType(MediaType.APPLICATION_JSON)
                .content(newShoe))
                .andExpect(status().isCreated());
    }

}
