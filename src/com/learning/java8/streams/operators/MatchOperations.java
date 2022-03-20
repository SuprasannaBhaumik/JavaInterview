package com.learning.java8.streams.operators;

import com.learning.java8.Util;

public class MatchOperations {


    //allMatch
    public static boolean allMatchDemo() {
        return Util.generateNote().stream().allMatch(note -> note.getTagName().startsWith("n"));
    }

    //anyMatch
    public static boolean anyMatchDemo() {
        return Util.generateNote().stream().anyMatch(note -> note.getTagId() > 2);
    }

    //noneMatch
    public static boolean noneMatchDemo() {
        return Util.generateNote().stream().noneMatch(note -> note.getTagName().startsWith("N"));
    }

    public static void main(String[] args) {

        System.out.println(allMatchDemo());
        System.out.println(anyMatchDemo());
        System.out.println(noneMatchDemo());
    }
}
