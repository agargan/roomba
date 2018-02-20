package com.agar.roomba.controller;

import com.agar.roomba.domain.model.Position;
import com.agar.roomba.dto.model.UserDto;
import com.agar.roomba.service.HooverRoomService;
import com.agar.roomba.testbuilders.RequestPayloadBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.assertj.core.util.Lists;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import java.util.Arrays;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(PayloadController.class)
public class PayloadControllerTest {

    private MockMvc mockMvc;

    @Autowired
    HooverRoomService serviceMock;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
                .build();
    }

    @Test
    public void testWhenPayloadIsOkStatusReturnsOk() throws Exception {
        UserDto req = new RequestPayloadBuilder()
                .roomSize(Arrays.asList(5,5))
                .coords(Arrays.asList(1,2))
                .patches(Lists.newArrayList(new Position(1,2)))
                .instructions("NNESW")
                .build();

        mockMvc.perform(MockMvcRequestBuilders.post("/roomba")
                .content(asJsonString(req))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(jsonPath("$.patches").value(1))
                .andExpect(jsonPath("$.coords").isArray());
    }

    // helper method
    public static String asJsonString(Object obj) {
        try {
            final ObjectMapper mapper = new ObjectMapper();
            return mapper.writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
