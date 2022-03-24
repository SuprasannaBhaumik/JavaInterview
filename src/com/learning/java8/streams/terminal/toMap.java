package com.learning.java8.streams.terminal;

import com.learning.java8.Util;
import com.learning.model.Note;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class toMap {

    public static void toMap_version1() {
        System.out.println("simple toMap");
        Map<Integer, String> myMap = Util.generateNoteWithBookmarkList().stream()
                .collect(
                        Collectors.toMap(
                                Note::getTagId,
                                Note::getTagName
                        )
                );
        System.out.println(myMap);

        System.out.println("with object as value");
        Map<Integer, Note> myMap2 = Util.generateNoteWithBookmarkList().stream()
                .collect(
                        Collectors.toMap(
                                Note::getTagId,
                                note -> note
                        )
                );
        System.out.println(myMap2);
    }

    public static void toMap_version2() {
        System.out.println("with conflict resolution: keep old");
        Map<String, Integer> myMap = Util.generateNoteWithBookmarkList().stream()
                .collect(
                        Collectors.toMap(
                                Note::getTagName, //key mapper
                                Note::getId, //value mapper
                                (a, b) -> a //conflict resolution, keep old value
                        )
                );
        System.out.println(myMap);
    }

    public static void toMap_version3() {
        System.out.println("with retaining order: keep new");
        Map<String, Integer> myMap = Util.generateNoteWithBookmarkList().stream()
                .collect(
                        Collectors.toMap(
                                Note::getTagName, //key mapper
                                Note::getId, //value mapper
                                (a, b) -> b, //conflict resolution, keep new value
                                LinkedHashMap::new //maintain ordering
                        )
                );
        System.out.println(myMap);
    }

    public static void main(String[] args) {
        toMap_version1();
        toMap_version2();
        toMap_version3();
    }
}
