package com.example.calculator.model;

import java.time.LocalDate;

public class Calculator {
    private boolean paramIsNull(Number param) {
        return param == null;
    }

    public Double sum(Double number1, Double number2) {
        if (paramIsNull(number1) || paramIsNull(number2)) {
            throw new NullPointerException("Número 1 e número 2 são obrigatórios.");
        }

        return number1 + number2;
    }

    public Double sub(Double number1, Double number2) {
        if (paramIsNull(number1) || paramIsNull(number2)) {
            throw new NullPointerException("Número 1 e número 2 são obrigatórios.");
        }

        return number1 - number2;
    }

    public Double divide (Double number1, Double number2)  {
        if (paramIsNull(number1) || paramIsNull(number2)) {
            throw new NullPointerException("Número 1 e número 2 são obrigatórios.");
        }

        if (number2 == 0) {
            throw new ArithmeticException("Divisão por zero não é permitido.");
        }

        return number1 / number2;
    }

    public Integer factorial(Integer factorial) {
        if (paramIsNull(factorial)) {
            throw new NullPointerException("Número é obrigatório.");
        }

        int resultado = factorial;

        for (int i = factorial - 1; i > 0; i--) {
            resultado = resultado * i;
        }

        return resultado;
    }

    // Exemplos:
    // Integer = 1 -> Binary = 1
    // Integer = 5 -> Binary = 101
    // Integer = 20 -> Binary = 10100
    public Integer integerToBinary(Integer integer) {
        String numeroBinario = Integer.toBinaryString(integer);

        return Integer.parseInt(numeroBinario);
    }

    // Exemplos:
    // Integer = 1 -> Hexadecimal = "1"
    // Integer = 5 -> Hexadecimal = "37"
    // Integer = 170 -> Binary = "AA"
    public String integerToHexadecimal(Integer integer) {
        return Integer.toHexString(integer);
    }

    // Exemplos
    // Date 1 = LocalDate.of(2020, 3, 15);
    // Date 2 = LocalDate.of(2020, 3, 29)
    // Total de dias = 14
    public int calculeDayBetweenDate(LocalDate date1, LocalDate date2) {
        int days = (int) (date1.toEpochDay() - date2.toEpochDay());

        return Math.abs(days);
    }
}
