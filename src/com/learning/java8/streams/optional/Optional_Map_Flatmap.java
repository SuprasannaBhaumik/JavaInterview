package com.learning.java8.streams.optional;

import com.learning.java8.Util;
import com.learning.model.Bookmark;
import com.learning.model.Note;

import java.util.Optional;

public class Optional_Map_Flatmap {

    public static void main(String[] args) {

        Optional<Note> optionalNote = Optional.ofNullable(Util.generateNote().get(0));
        Optional<String> optionalTopic =
                optionalNote
                        .flatMap(Note::getBookmarkOptional)
                        .map(Bookmark::getTopic);

        optionalTopic.ifPresent(System.out::println);

    }
}
