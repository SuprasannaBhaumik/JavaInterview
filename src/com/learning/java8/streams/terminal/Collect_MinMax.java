package com.learning.java8.streams.terminal;

import com.learning.java8.Util;
import com.learning.model.Bookmark;

import java.util.Comparator;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class Collect_MinMax {

    //find out minimum bookmark page no
    public static void calculateMin() {
        Optional<Bookmark> min = Util.generateNoteWithBookmarkList()
                .stream()
                .filter(note -> Objects.nonNull(note.getBookmarkList()))
                .flatMap(note -> note.getBookmarkList().stream())
                .min(Comparator.comparingInt(Bookmark::getPageNo));
        min.ifPresentOrElse(
                bookmark -> System.out.println(bookmark.getPageNo()),
                () -> System.out.println("no data")
        );

    }

    //find out maximum bookmark page no
    public static void calculateMax() {

        Bookmark max = Util.generateNoteWithBookmarkList()
                .stream()
                .filter(note -> Objects.nonNull(note.getBookmarkList()))
                .flatMap(note -> note.getBookmarkList().stream())
                .collect(
                        Collectors.collectingAndThen(
                                Collectors.maxBy(Comparator.comparingInt(Bookmark::getPageNo)),
                                Optional::get
                        ));

        System.out.println(max.getPageNo());


    }

    public static void main(String[] args) {
        calculateMin();
        calculateMax();
    }

}
