package com.learning.java8.streams.terminal;

import com.learning.java8.Util;
import com.learning.model.Note;

import java.util.stream.Collectors;

public class Joining {

    public static void joining_v1() {
        System.out.println("simple joining");
        String join = Util.generateNoteWithBookmarkList().stream()
                .map(Note::getTagName)
                .collect(Collectors.joining());
        System.out.println(join);
    }

    public static void joining_v2() {
        System.out.println("joining with delimiter comma");
        String join = Util.generateNoteWithBookmarkList().stream()
                .map(Note::getTagName)
                .collect(Collectors.joining(","));
        System.out.println(join);
    }

    public static void joining_v3() {
        System.out.println("joining with delimiter, and prefix/suffix at endpoints");
        String join = Util.generateNoteWithBookmarkList().stream()
                .map(Note::getTagName)
                .collect(Collectors.joining(",", "-", "-"));
        System.out.println(join);
    }

    public static void main(String[] args) {

        joining_v1();
        joining_v2();
        joining_v3();

    }
}
