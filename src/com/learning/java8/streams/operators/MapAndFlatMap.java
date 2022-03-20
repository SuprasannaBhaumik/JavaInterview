package com.learning.java8.streams.operators;

import com.learning.java8.Util;
import com.learning.model.Bookmark;
import com.learning.model.Note;

import java.awt.print.Book;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class MapAndFlatMap {

    public static List<String> mapExample() {
        return Util.generateNoteWithBookmarkList()
                .stream()
                .map(Note::getTagName)
                .collect(Collectors.toList());
    }

    public static List<String> flapMap_Bookmark() {
        return Util.generateNoteWithBookmarkList()
                .stream()
                .filter( note -> note.getBookmarkList() != null)
                .map(Note::getBookmarkList)
                .flatMap(bookmarks -> bookmarks.stream())// get list, so do list.stream from here, Collection::stream
                .map(Bookmark::getTopic)
                .collect(Collectors.toList());
    }


    public static void main(String[] args) {

        System.out.println(mapExample());
        System.out.println(flapMap_Bookmark());

    }
}
