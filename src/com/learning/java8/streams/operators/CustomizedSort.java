package com.learning.java8.streams.operators;

import com.learning.java8.Util;
import com.learning.model.Note;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CustomizedSort {

    //customized sort
    public static List<Note> sortByTagNameNumber() {
        return Util.generateNote()
                .stream()
                .sorted(Comparator.comparingInt(o -> Integer.parseInt(Character.toString(o.getTagName().charAt(4)))))
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        System.out.println(sortByTagNameNumber());

    }
}
