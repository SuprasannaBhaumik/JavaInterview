package com.learning.java8.streams.operators;

import com.learning.java8.Util;
import com.learning.model.Note;

import java.util.Optional;

public class FindAnyFindFirst {

    //relevant in context of multithreading
    public static Optional<Note> findAny() {
        return Util.generateNote().stream().findAny();
    }

    //relevant in context of multithreading
    public static Optional<Note> findFirst() {
        return Util.generateNote().stream().findFirst();
    }

    public static void main(String[] args) {
        System.out.println(findAny().get());
        System.out.println(findFirst().get());
    }
}
