package com.thoughtworks.star.firstproject;

import org.junit.Test;

import java.util.Arrays;
import java.util.Map;

import static org.hamcrest.Matchers.contains;
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

    /**
     * 统计列表中偶数的和
     * Input: Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
     * Output: 30
     */
    @Test
    public void should_sum_evens() {
        Calculator calculator = new Calculator();
        int result = calculator.sumEvens(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        assertThat(result, is(30));
    }


    /**
     * 按照名字拼音顺序统计名字的长度，输入为名字列表，输出为名字-长度映射
     * Input: Arrays.asList("ynpan", "yzqi", "ybowang", "qiqzhao", "yibtan", "abc", "sjyuan")
     * Output: Map<String, Integer>: {"abc": 3, qiqzhao": 7, "sjyuan": 6, "ybowang": 7, yibtan: 6, ynpan: 5, yzqi: 4 }
     */
    @Test
    public void should_sort_and_count_names() {
        Calculator calculator = new Calculator();

        Map<String, Integer> result = calculator.sortAndCount(Arrays.asList("ynpan", "yzqi", "ybowang", "qiqzhao",
                "yibtan", "abc", "sjyuan"));
        assertThat(result.keySet(), contains("abc", "qiqzhao", "sjyuan", "ybowang", "yibtan", "ynpan", "yzqi"));
        assertThat(result.values(), contains(3, 7, 6, 7, 6, 5, 4));
    }
}
