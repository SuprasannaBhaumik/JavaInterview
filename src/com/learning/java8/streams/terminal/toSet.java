package com.learning.java8.streams.terminal;

import com.learning.java8.Util;
import com.learning.model.Bookmark;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class toSet {

    public static void toSet() {
        Set<Integer> integerSet =
                Util.generateNoteWithBookmarkList().stream()
                        .filter(note -> Objects.nonNull(note.getBookmarkList()))
                        .flatMap(note -> note.getBookmarkList().stream())
                        .map(Bookmark::getPageNo)
                        .collect(Collectors.toSet());
        System.out.println(integerSet);
    }

    public static void toUnmodifiableSet() {
        Set<Integer> integerSet =
                Util.generateNoteWithBookmarkList().stream()
                        .filter(note -> Objects.nonNull(note.getBookmarkList()))
                        .flatMap(note -> note.getBookmarkList().stream())
                        .map(Bookmark::getPageNo)
                        .collect(Collectors.toUnmodifiableSet());
        System.out.println(integerSet);
    }

    public static void main(String[] args) {
        toSet();
        toUnmodifiableSet();
    }
}
