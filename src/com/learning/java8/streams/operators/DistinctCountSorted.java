package com.learning.java8.streams.operators;

import com.learning.java8.Util;
import com.learning.model.Note;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DistinctCountSorted {

    public static long count() {
        return Util.generateNote()
                .stream()
                .map(Note::getTagName).count();
    }

    public static List<String> distinctNote() {
        //with distinct note tagname, removes the duplicate
        return Util.generateNote()
                .stream()
                .map(Note::getTagName)
                .distinct()
                .collect(Collectors.toList());
    }


    public static List<Integer> sort() {
        return Stream.of(1, 5, 2, 7, 9, 14, 2)
                .sorted()
                .collect(Collectors.toList());
    }

    public static List<Integer> reverseSort() {
        return Stream.of(1, 5, 2, 7, 9, 14, 2)
                .sorted( (x, y) ->  y - x)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        System.out.println(count());
        System.out.println(distinctNote());
        System.out.println(sort());
        System.out.println(reverseSort());
    }

}

