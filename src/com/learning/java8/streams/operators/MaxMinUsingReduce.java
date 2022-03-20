package com.learning.java8.streams.operators;

import java.util.List;

public class MaxMinUsingReduce {

    public static void main(String[] args) {

        List<Integer> integerList = List.of(1, -5, 5, 45, 98, 78, 15);

        System.out.println("Min: " + integerList.stream().reduce((o, n) -> o < n ? o : n));
        System.out.println("Max: " + integerList.stream().reduce((o, n) -> o > n ? o : n));


    }
}
