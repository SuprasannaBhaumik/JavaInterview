package com.learning.java8;

import com.learning.model.Bookmark;
import com.learning.model.Note;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Util {

    public static List<String> getStringList() {
        List<String> notes = new ArrayList<>();
        notes.add("note1");
        notes.add("note2");
        notes.add("note3");
        notes.add("note4");
        notes.add("note5");
        return notes;
    }

    public static List<Note> generateNote() {

        List<Note> noteLst = new ArrayList<>();
        noteLst.add(new Note(1, "note3", 33, Optional.of(new Bookmark(1, "flatMap"))));
        noteLst.add(new Note(2, "note1", 11));
        noteLst.add(new Note(3, "note5", 55, Optional.of(new Bookmark(27, "map"))));
        noteLst.add(new Note(4, "note4", 27));
        noteLst.add(new Note(5, "note2", 17, Optional.of(new Bookmark(38, "api"))));
        noteLst.add(new Note(6, "note5", 48));
        noteLst.add(new Note(7, "note2", 22));
        noteLst.add(new Note(8, "note4", 66));
        return noteLst;
    }

    public static List<Note> generateNoteWithBookmarkList() {

        List<Note> noteLst = new ArrayList<>();
        noteLst.add(new Note(3, "note3", 33,
                List.of(
                        new Bookmark(1, "flatMap", 156454L, 34.5),
                        new Bookmark(23, "map", 63849L, 368.56),
                        new Bookmark(115, "generics", 54898L, 456.38)
                )
        ));
        noteLst.add(new Note(1, "note1", 11));
        noteLst.add(new Note(5, "note5", 55,
                List.of(
                        new Bookmark(27, "map", 123L, 6875.29))));
        noteLst.add(new Note(4, "note4", 27));
        noteLst.add(new Note(2, "note2", 17,
                List.of(
                        new Bookmark(38, "api", 964357L, 435.9),
                        new Bookmark(48, "parameters", 98543L, 4.2)
                )
        ));
        noteLst.add(new Note(5, "note5", 48));
        noteLst.add(new Note(2, "note2", 22,
                List.of(
                        new Bookmark(1, "horror", 5243L, 354.8),
                        new Bookmark(23, "map", 354L, 4543.1),
                        new Bookmark(115, "generics", 47624L, 90.7)
                )
        ));
        noteLst.add(new Note(6, "note4", 66));
        return noteLst;
    }
}
