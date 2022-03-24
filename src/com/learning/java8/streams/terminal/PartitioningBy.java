package com.learning.java8.streams.terminal;

import com.learning.java8.Util;
import com.learning.model.Bookmark;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PartitioningBy {

    public static void partitioning_v1() {
        System.out.println("partitioning with predicate");

        Predicate<Bookmark> myPredicate = bookmark -> bookmark.getPageNo() > 50;

        Map<Boolean, List<Bookmark>> myMap = Util.generateNoteWithBookmarkList().stream()
                .filter(note -> Objects.nonNull(note.getBookmarkList()))
                .flatMap(note -> note.getBookmarkList().stream())
                .collect(Collectors.partitioningBy(myPredicate));
        System.out.println(myMap);

    }

    public static void partitioning_v2() {
        System.out.println("partitioning with predicate and downstream");

        Predicate<Bookmark> myPredicate = bookmark -> bookmark.getPageNo() > 50 ? true : false;

        Map<Boolean, Map<Integer, Bookmark>> myMap = Util.generateNoteWithBookmarkList().stream()
                .filter(note -> Objects.nonNull(note.getBookmarkList()))
                .flatMap(note -> note.getBookmarkList().stream())
                .collect(Collectors.partitioningBy(
                            myPredicate,
                            Collectors.toMap(
                                    Bookmark::getPageNo, //key mapper
                                    Function.identity(), //value mapper
                                    (a, b) -> a //conflict resolution
                            )
                        )
                );
        System.out.println(myMap);


    }

    public static void main(String[] args) {
        partitioning_v1();
        partitioning_v2();
    }
}
