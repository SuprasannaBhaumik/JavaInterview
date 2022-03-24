package com.learning.java8.streams.terminal;

import com.learning.java8.Util;
import com.learning.model.Note;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Reducing {

    public static void reducing_v1() {
        System.out.println("reducing only");
        Optional<Integer> sum = Util.generateNoteWithBookmarkList().stream()
                .map(Note::getId)
                .distinct()
                .collect(Collectors.reducing((a, b) -> a + b));

        sum.ifPresent(System.out::println);
    }

    public static void reducing_v2() {
        System.out.println("reducing with identity");
        int sum = Util.generateNoteWithBookmarkList().stream()
                .map(Note::getTagId)
                .distinct()
                .collect(Collectors.reducing(0, (a, b) -> a + b));

        System.out.println(sum);
    }

    public static void reducing_v3() {
        System.out.println("reducing with mapper");
        int sum = Util.generateNoteWithBookmarkList().stream()
                .map(Note::getId)
                .distinct()
                .collect(Collectors.reducing(0, a -> a * 10 ,(a, b) -> a + b));

        System.out.println(sum);
    }

    public static void main(String[] args) {
        reducing_v1();
        reducing_v2();
        reducing_v3();
    }
}
