package com.learning.triviaInterview;

import com.learning.model.Note;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MergeMap {

    public static void main(String[] args) {

        List<Note> noteLst = new ArrayList<>();
        noteLst.add(new Note(1, "note1", 11));
        noteLst.add(new Note(2, "note2", 22));
        noteLst.add(new Note(3, "note3", 33));
        noteLst.add(new Note(4, "note4", 44));
        noteLst.add(new Note(5, "note5", 55));

        noteLst.add(new Note(6, "note4", 66));

        //merge map with old key value
        Map<String, Integer> notesRecords = noteLst.stream().collect(
                Collectors.toMap(
                        Note::getTagName,
                        Note::getTagId,
                        (oldValue, newValue) -> oldValue)
        );
        System.out.println(notesRecords);
    }
}
