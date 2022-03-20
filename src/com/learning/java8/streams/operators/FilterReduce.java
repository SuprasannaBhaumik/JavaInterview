package com.learning.java8.streams.operators;

import com.learning.java8.Util;
import com.learning.model.Note;

public class FilterReduce {

    //fetch sum of all note tagNames(number part)
    public static int sumTagNameValues() {
        return Util.generateNote().stream()
                .map(Note::getTagName)
                .map(s -> Integer.parseInt(Character.toString(s.charAt(4))))
                .reduce(0, (a, b) -> a + b);
    }

    //fetch product of all note tagNames(number part)
    public static int productTagNameValues() {
        return Util.generateNote().stream()
                .map(Note::getTagName)
                .map(s -> Integer.parseInt(Character.toString(s.charAt(4))))
                .filter( x -> x > 3)
                .reduce(1, (a, b) -> a * b);
    }


    public static void main(String[] args) {
        System.out.println(sumTagNameValues());
        System.out.println(productTagNameValues());

    }
}
