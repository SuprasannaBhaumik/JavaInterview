package com.learning.java8;

import com.learning.model.Note;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class Trivia {

    public static void main(String[] args) {

        List<String> notes = Util.getStringList();

        //iterate collection in Java 8
        //using method reference
        System.out.println("----------Using method reference--------------");
        notes.forEach(System.out::println);
        //lambdas
        System.out.println("----------Using lambda-----------------");
        notes.forEach(x -> System.out.println(x));
        //to filter out
        System.out.println("-----------Using filter: removing note1 ----------------");
        notes.stream().filter( x -> !"note1".equalsIgnoreCase(x)).forEach(System.out::println);



        //How to check if list is empty in Java 8 using Optional,
        // if not null iterate through the list and print the object?
        System.out.println("------------Using Optional nullable---------------");
        Optional.ofNullable(notes)
                .orElseGet(Collections::emptyList)
                .stream().filter(Objects::nonNull)
                .forEach(System.out::println);

        System.out.println("------------Sort collection---------------");
        List<Note> myNotes = Util.generateNote();

        // same as below: myNotes.sort( (x,y) -> x.getId() - y.getId())
        myNotes.sort(Comparator.comparingInt(Note::getId));
        myNotes.forEach(System.out::println);


        //How to use map to convert object into Uppercase in Java 8
        System.out.println("------------Use map to convert object into Uppercase---------------");
        List<String> names = Arrays.asList("aa", "bb", "cc", "dd");

        List<String> newNames = names.stream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(newNames);


        //How to convert a list of objects to a Map in Java 8 by handling duplicate keys?
        System.out.println("------------convert a list of objects to a Map: handling duplicate keys---------------");
        Map<String, Integer> notesRecords = myNotes
                .stream()
                .collect(
                        Collectors.toMap(
                                Note::getTagName, // key mapper, same as:  x -> x.getTagName()
                                Note::getTagId, //value mapper, same as : x -> x.getTagId()
                                (o, n) -> o // merge conflict resolution -> keeps the old record
                        )
                );
        System.out.println(notesRecords);

        //How to convert a List of objects into a Map by considering duplicated keys and store them in sorted order ?
        System.out.println("----------Convert a List<Objects> to a Map, considering duplicated keys, and store them in sorted order-----------------");
        Map<String, Integer> notesRecords1 =
                myNotes
                        .stream()
                        .sorted(Comparator.comparingLong(Note::getTagId).reversed())
                        .collect(Collectors.toMap(Note::getTagName, Note::getTagId, (o, n)-> o, LinkedHashMap::new));
        System.out.println(notesRecords1);


        //Convert list to map with duplicated entries for certain parameter as key, and value as list
        // e.g a-1, a-2, a-3, b-1, b-2, c1 => a - [1,2,3] | b - [1,2] | c - [1]
        // you can collect in the value, what exactly you need and in what collection
        // e.g. list, set, etc with either the entire obj, or specific parameter
        System.out.println("--------------group by Tag Name, but more fine grained controls -----------");
        Map<String, List<Note>>  myMap = myNotes.stream().collect(
                Collectors.groupingBy(
                        x -> x.getTagName(),//key
                        Collectors.mapping( x -> x, Collectors.toList())//value, which is a list
                        //the value represents what can be the underlying ds to have the elements
                ));

        System.out.println(myMap);

        //group by tagName
        System.out.println("--------------group by Tag Name-----------");
        Map<String, List<Note>> collect = myNotes.stream().collect(
                Collectors.groupingBy(Note::getTagName));
        System.out.println(collect);

    }




}
