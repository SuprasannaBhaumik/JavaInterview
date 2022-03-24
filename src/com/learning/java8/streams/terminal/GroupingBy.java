package com.learning.java8.streams.terminal;

import com.learning.java8.Util;
import com.learning.model.Bookmark;
import com.learning.model.Note;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toSet;

public class GroupingBy {

    public static void grouping_1Arg() {

        //groupingBy always returns a map
        // key -> String
        // value -> List
        Map<String, List<Note>> myMap = Util.generateNoteWithBookmarkList()
                .stream()
                .collect(groupingBy(Note::getTagName));//default downstream is list

        System.out.println(myMap);

    }

    public static void grouping_2Arg() {
        //2nd argument is downstream for value (data-structure to collect items in)
        Map<String, Set<Note>> myMap = Util.generateNoteWithBookmarkList()
                .stream()
                .collect(groupingBy(Note::getTagName, toSet()));
        System.out.println(myMap);
    }

    // return Map<String, Map<String, List<Bookmark>>>
    // key -> tagName
    // value -> Map<String, List<Bookmark>>
    //              ADVANCED_READER( pageNo > 30, from bookmark) and all bookmarks
    //              AMATEUR_READER and all bookmarks
    public static void grouping_2Arg_1() {
        //2nd argument is downstream for value (data-structure to collect items in)
        Map<String, Map<String, List<Note>>> myMap =
                Util.generateNoteWithBookmarkList()
                .stream()
                .collect(groupingBy(Note::getTagName, groupingBy(note ->
                   note.getTagId() > 10 ? "XYZ" : "ABC"
                )));
        System.out.println(myMap);
    }

    public static void grouping_2Arg_2() {

        Map<String, List<Note>> highLevelMap =
                Util.generateNoteWithBookmarkList().stream().collect(groupingBy(Note::getTagName));

        Map<String, Map<String, List<Bookmark>>> resultMap = new HashMap<>();

        highLevelMap.forEach( (keyNote, noteList) -> {

            Map<String, List<Bookmark>> myCustomMap =
                    noteList
                    .stream()
                    .filter(note -> Objects.nonNull(note.getBookmarkList()))
                    .flatMap(note -> note.getBookmarkList().stream())
                    .collect(groupingBy(bookmark -> bookmark.getPageNo() > 30 ? "VORACIOUS": "NORMAL"));
            resultMap.put(keyNote, myCustomMap);
        });
        System.out.println("Result map");
        System.out.println(resultMap);
        System.out.println("----------------------------------");

    }

    public static void grouping_3Arg() {
        Map<String, Set<Note>> myMap = Util.generateNoteWithBookmarkList()
                .stream()
                .collect(groupingBy(Note::getTagName, LinkedHashMap::new, toSet()));
        System.out.println(myMap);
        System.out.println();

    }

    public static void main(String[] args) {

        grouping_1Arg();
        grouping_2Arg();
        grouping_2Arg_1();
        grouping_2Arg_2();
        grouping_3Arg();

    }

}
