package com.learning.java8.streams.terminal;

import com.learning.java8.Util;
import com.learning.model.Bookmark;

import java.util.Objects;
import java.util.stream.Collectors;

public class Averaging {

    public static void averagingInt() {

        //average of all pageno in the bookmarks
        double average = Util.generateNoteWithBookmarkList()
                .stream()
                .filter(note -> Objects.nonNull(note.getBookmarkList()))
                .flatMap(note -> note.getBookmarkList().stream())
                .collect(Collectors.averagingInt(Bookmark::getPageNo));

        System.out.println(average);
    }

    public static void averagingDouble() {

        //average of all pageno in the bookmarks
        double average = Util.generateNoteWithBookmarkList()
                .stream()
                .filter(note -> Objects.nonNull(note.getBookmarkList()))
                .flatMap(note -> note.getBookmarkList().stream())
                .collect(Collectors.averagingDouble(Bookmark::getPrice));

        System.out.println(average);

    }

    public static void averagingLong() {
//average of all pageno in the bookmarks
        double average = Util.generateNoteWithBookmarkList()
                .stream()
                .filter(note -> Objects.nonNull(note.getBookmarkList()))
                .flatMap(note -> note.getBookmarkList().stream())
                .collect(Collectors.averagingLong(Bookmark::getVersion));

        System.out.println(average);
    }

    public static void main(String[] args) {
        averagingInt();
        averagingDouble();
        averagingLong();
    }

}
