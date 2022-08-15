package com.example.calculator.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    public void setup() {
        calculator = new Calculator();
    }

    @Test
    void sumTest() {
        double result = calculator.sum(1.0, 1.0);

        assertEquals(result, 2.0);
    }

    @Test
    public void numbersNullSumTest() {
        Exception exception = assertThrows(NullPointerException.class, () -> calculator.sum(null, null));

        assertEquals(exception.getMessage(), "Número 1 e número 2 são obrigatórios.");
    }

    @Test
    void subTest() {
        double result = calculator.sub(2.0, 1.0);

        assertEquals(result, 1.0);
    }

    @Test
    void divideTest() {
        double result = calculator.divide(2.0, 1.0);

        assertEquals(result, 2.0);
    }

    @Test
    public void divisionByZeroTest() {
        ArithmeticException exception = assertThrows(ArithmeticException.class, () -> calculator.divide(4.0, 0.0));

        assertEquals(exception.getMessage(), "Divisão por zero não é permitido.");
    }

    @Test
    void factorialTest() {
        int result = calculator.factorial(5);

        assertEquals(result, 120);
    }

    @Test
    void integerToBinaryTest() {
        int result = calculator.integerToBinary(5);

        assertEquals(result, 101);
    }

    @Test
    void integerToHexadecimalTest() {
        String result = calculator.integerToHexadecimal(1);

        assertEquals(result, "1");
    }

    @Test
    void calculeDayBetweenDateTest() {
        LocalDate date1 = LocalDate.of(2020, 3, 15);
        LocalDate date2 = LocalDate.of(2020, 3, 29);

        int result = calculator.calculeDayBetweenDate(date1, date2);

        assertEquals(result, 14);
    }
}
