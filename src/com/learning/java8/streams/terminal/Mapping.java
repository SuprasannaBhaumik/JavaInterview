package com.learning.java8.streams.terminal;

import com.learning.java8.Util;
import com.learning.model.Note;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Mapping {

    public static void mapping() {

        Function<String, Integer> mapperFunction =
                s -> Integer.parseInt(Character.toString(s.charAt(4)));


        List<Integer> myList = Util.generateNoteWithBookmarkList().stream()
                .map(Note::getTagName)
                .distinct()
                .collect(Collectors.mapping(mapperFunction, Collectors.toList()));

        System.out.println(myList);
    }

    public static void main(String[] args) {
        mapping();
    }
}
