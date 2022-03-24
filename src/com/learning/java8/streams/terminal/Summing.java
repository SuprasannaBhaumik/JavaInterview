package com.learning.java8.streams.terminal;

import com.learning.java8.Util;
import com.learning.model.Bookmark;

import java.util.Objects;
import java.util.stream.Collectors;

public class Summing {

    public static void performSummingInt() {

        int total = Util.generateNoteWithBookmarkList()
                .stream()
                .filter(note -> Objects.nonNull(note.getBookmarkList()))
                .flatMap(note -> note.getBookmarkList().stream())
                .filter(bookmark -> bookmark.getPageNo() > 60)
                .peek(bookmark -> System.out.println(bookmark))
                .collect(Collectors.summingInt(Bookmark::getPageNo));
        System.out.println(total);
    }

    public static void performSummingLong() {
        Long total = Util.generateNoteWithBookmarkList()
                .stream()
                .filter(note -> Objects.nonNull(note.getBookmarkList()))
                .flatMap(note -> note.getBookmarkList().stream())
                .filter(bookmark -> bookmark.getPageNo() > 60)
                .collect(Collectors.summingLong(Bookmark::getVersion));
        System.out.println(total);
    }

    public static void performSummingDouble() {
        Double total = Util.generateNoteWithBookmarkList()
                .stream()
                .filter(note -> Objects.nonNull(note.getBookmarkList()))
                .flatMap(note -> note.getBookmarkList().stream())
                .filter(bookmark -> bookmark.getPageNo() > 60)
                .collect(Collectors.summingDouble(Bookmark::getPrice));
        System.out.println(total);
    }

    public static void main(String[] args) {
        performSummingInt();
        performSummingDouble();
        performSummingLong();
    }
}
