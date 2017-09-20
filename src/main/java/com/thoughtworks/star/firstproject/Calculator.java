package com.thoughtworks.star.firstproject;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Calculator {
    public double sum(double number1, double number2) {
        return number1 + number2;
    }

    public int sumEvens(List<Integer> integers) {
        return integers.stream()
                .filter(number -> number % 2 == 0)
                .mapToInt(Integer::intValue).sum();
    }
}
