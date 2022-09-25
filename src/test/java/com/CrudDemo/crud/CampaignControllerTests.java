package com.CrudDemo.crud;

import com.CrudDemo.crud.Campaign.Campaign;
import com.CrudDemo.crud.Campaign.CampaignsController;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.math.BigDecimal;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
public class CampaignControllerTests {


    @Autowired
    private MockMvc mvc;

    @MockBean
    private CampaignsController campaignsController;

    Campaign campaign = new Campaign();

    @BeforeEach
    public void setUp() {
        campaign.setName("campaign2");
        campaign.setTown("Katowice");
        campaign.setRadius(90);
        campaign.setKeywords("shirts, sport, running");
        campaign.setCampaignFound(BigDecimal.valueOf(90000));
        campaign.setBidAmount(BigDecimal.valueOf(15000));
        campaign.setStatus(true);
    }


    @Test
    void createCampaignTest() throws Exception {
        mvc.perform(MockMvcRequestBuilders.post("/campaigns")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(campaign)))
                .andExpect(status().isOk());
    }

    @Test
    void deleteCampaignTest() throws Exception {
        mvc.perform(MockMvcRequestBuilders.delete("/campaigns/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(campaign)))
                .andExpect(status().isOk());
    }

    @Test
    void updateCampaignTest() throws Exception {
        mvc.perform(MockMvcRequestBuilders.put("/campaigns/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(campaign)))
                .andExpect(status().isOk());
    }


    private static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
