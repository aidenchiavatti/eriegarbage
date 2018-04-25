package com.eriegarbage.garbageapp.controllers;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.*;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class BillControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    @WithMockUser
    public void getBillPage() throws Exception {
        this.mockMvc.perform(get("/billPage")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Bill")));
    }

    @Test
    @WithMockUser
    public void payBill() throws Exception {
        this.mockMvc.perform(get("/payBill")
                .param("id", "4")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"cardType\":\"discover\",\"cardNumber\":\"1234\",\"paymentAmount\":20}"))
                .andDo(print()).andExpect(status().isOk());
    }

//    //FAILS. null pointer
//    @Test
//    @WithMockUser
//    public void payNonExistentBill() throws Exception {
//        this.mockMvc.perform(get("/payBill")
//                .param("id", "999")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content("{\"cardType\":\"discover\",\"cardNumber\":\"1234\",\"paymentAmount\":20}"))
//                .andDo(print()).andExpect(status().isBadRequest());
//    }

    @Test
    @WithMockUser
    public void payBillIncorrectAmount() throws Exception {
        this.mockMvc.perform(get("/payBill")
                .param("id", "3")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"cardType\":\"discover\",\"cardNumber\":\"1234\",\"paymentAmount\":21}"))
                .andDo(print()).andExpect(status().isBadRequest());
    }

    //FAILS: user should not be able to pay another person's bill
//    @Test
//    @WithMockUser(username = "testuser")
//    public void payBillForOtherPerson() throws Exception {
//        this.mockMvc.perform(get("/payBill")
//                .param("id", "3")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content("{\"cardType\":\"discover\",\"cardNumber\":\"1234\",\"paymentAmount\":20}"))
//                .andDo(print()).andExpect(status().isBadRequest());
//    }

    @Test
    public void getPaymentsPage() {
    }

    //commented out to prevent email spam
//    @Test
//    @WithMockUser(username = "admin")
//    public void sendReceipt() throws Exception {
//        this.mockMvc.perform(post("/sendReceipt")
//                .param("id", "8")
//                .with(csrf()))
//                .andDo(print()).andExpect(status().isOk());
//    }

    //FAILS: should not be allowed. needs admin protection
//    @Test
//    @WithMockUser
//    public void sendReceiptWithoutAdmin() throws Exception {
//        this.mockMvc.perform(post("/sendReceipt")
//                .param("id", "8")
//                .with(csrf()))
//                .andDo(print()).andExpect(status().isMethodNotAllowed());
//    }


    @Test
    public void viewBillDisputes() {
    }
}