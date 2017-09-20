package com.thoughtworks.star.firstproject;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.logging.Logger;

import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;


public class CalculatorTest {

    @Test
    public void should_return_sum_of_two_numbers() {
        // 1. 准备数据，定义输入
        double number1 = 5.0;
        double number2 = 9.0;

        // 2. 执行调用，得到输出
        Calculator calculator = new Calculator();
        double result = calculator.sum(number1, number2);

        // 3. 断言
        assertThat(result, is(14.0));
    }
}
