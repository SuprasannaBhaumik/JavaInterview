package com.learning.java8.streams.terminal;

import com.learning.java8.Util;
import com.learning.model.Bookmark;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class toList {

    public static void toList() {

        List<Integer> integerList =
                Util.generateNoteWithBookmarkList().stream()
                        .filter(note -> Objects.nonNull(note.getBookmarkList()))
                        .flatMap(note -> note.getBookmarkList().stream())
                        .map(Bookmark::getPageNo)
                        .collect(Collectors.toList());
        System.out.println(integerList);
    }


    public static void main(String[] args) {
        toList();
    }
}
