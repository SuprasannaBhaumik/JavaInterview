package com.learning.java8.streams.operators;

import com.learning.java8.Util;
import com.learning.model.Note;

import java.util.List;
import java.util.stream.Collectors;

public class LimitAndSkip {

    //get only 2
    public static List<Note> limitDemo() {
        return Util.generateNote()
                .stream()
                .limit(2)
                .collect(Collectors.toList());
    }

    //skip 2
    public static List<Note> skipDemo() {
        return Util.generateNote()
                .stream()
                .skip(2)
                .collect(Collectors.toList());

    }

    public static void main(String[] args) {
        System.out.println(skipDemo());
        System.out.println(limitDemo());
    }
}
