package com.learning.java8.streams.terminal;

import com.learning.java8.Util;
import com.learning.model.Bookmark;

import java.util.DoubleSummaryStatistics;
import java.util.IntSummaryStatistics;
import java.util.LongSummaryStatistics;
import java.util.Objects;
import java.util.stream.Collectors;

public class Summarizing {

    public static void performSummarizingInt() {

        IntSummaryStatistics intSummaryStatistics = Util.generateNoteWithBookmarkList()
                .stream()
                .filter(note -> Objects.nonNull(note.getBookmarkList()))
                .flatMap(note -> note.getBookmarkList().stream())
                .peek(System.out::println)
                .collect(Collectors.summarizingInt(Bookmark::getPageNo));
        System.out.println(intSummaryStatistics.getMin());
        System.out.println(intSummaryStatistics.getMax());
        System.out.println(intSummaryStatistics.getSum());
        System.out.println(intSummaryStatistics.getAverage());
    }

    public static void performSummarizingLong() {
        LongSummaryStatistics longSummaryStatistics = Util.generateNoteWithBookmarkList()
                .stream()
                .filter(note -> Objects.nonNull(note.getBookmarkList()))
                .flatMap(note -> note.getBookmarkList().stream())
                .peek(System.out::println)
                .collect(Collectors.summarizingLong(Bookmark::getVersion));
        System.out.println(longSummaryStatistics.getMin());
        System.out.println(longSummaryStatistics.getMax());
        System.out.println(longSummaryStatistics.getSum());
        System.out.println(longSummaryStatistics.getAverage());
    }

    public static void performSummarizingDouble() {
        DoubleSummaryStatistics doubleSummaryStatistics = Util.generateNoteWithBookmarkList()
                .stream()
                .filter(note -> Objects.nonNull(note.getBookmarkList()))
                .flatMap(note -> note.getBookmarkList().stream())
                .peek(System.out::println)
                .collect(Collectors.summarizingDouble(Bookmark::getPrice));
        System.out.println(doubleSummaryStatistics.getMin());
        System.out.println(doubleSummaryStatistics.getMax());
        System.out.println(doubleSummaryStatistics.getSum());
        System.out.println(doubleSummaryStatistics.getAverage());
    }

    public static void main(String[] args) {
        performSummarizingInt();
        performSummarizingLong();
        performSummarizingDouble();
    }
}
