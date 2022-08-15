package com.example.calculator.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@ExtendWith(SpringExtension.class)
@WebMvcTest(CalculatorController.class)
public class CalculatorControllerTest {
    @Autowired
    private MockMvc mvc;

    @Test
    void messageWelcome() throws Exception {
        RequestBuilder request = get("/calculator/welcome");

        MvcResult result = mvc.perform(request).andReturn();

        assertEquals("Bem vindo à CALCULATOR API REST.", result.getResponse().getContentAsString());
    }

    @Test
    void addNumbers() throws Exception {
        RequestBuilder request = get("/calculator/addNumbers?number1=1&number2=2");

        MvcResult result = mvc.perform(request).andReturn();

        assertEquals("3.0", result.getResponse().getContentAsString());
    }

    @Test
    void subNumbers() throws Exception {
        RequestBuilder request = get("/calculator/subNumbers?number1=2&number2=1");

        MvcResult result = mvc.perform(request).andReturn();

        assertEquals("1.0", result.getResponse().getContentAsString());
    }

    @Test
    void divideNumbers() throws Exception {
        RequestBuilder request = get("/calculator/divideNumbers?number1=2&number2=1");

        MvcResult result = mvc.perform(request).andReturn();

        assertEquals("2.0", result.getResponse().getContentAsString());
    }

    @Test
    void factorial() throws Exception {
        RequestBuilder request = get("/calculator/factorial?factorial=5");

        MvcResult result = mvc.perform(request).andReturn();

        assertEquals("120", result.getResponse().getContentAsString());
    }

    @Test
    void calculeDayBetweenDate() throws Exception {
        String date1 = LocalDate.of(2020, 3, 15).format(DateTimeFormatter.ISO_DATE);
        String date2 = LocalDate.of(2020, 3, 29).format(DateTimeFormatter.ISO_DATE);

        String url = String.format("/calculator/calculeDayBetweenDate?localDate1=%s&localDate2=%s", date1, date2);

        RequestBuilder request = get(url);

        MvcResult result = mvc.perform(request).andReturn();

        assertEquals("14", result.getResponse().getContentAsString());
    }

    @Test
    void integerToBinary() throws Exception {
        RequestBuilder request = get("/calculator/integerToBinary?number1=5");

        MvcResult result = mvc.perform(request).andReturn();

        assertEquals("101", result.getResponse().getContentAsString());
    }

    @Test
    void integerToHexadecimal() throws Exception {
        RequestBuilder request = get("/calculator/integerToHexadecimal?number1=1");

        MvcResult result = mvc.perform(request).andReturn();

        assertEquals("1", result.getResponse().getContentAsString());
    }
}
