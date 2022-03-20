package com.learning.java8.streams.operators;

import com.learning.java8.Util;
import com.learning.model.Note;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MapAndFilter {


    public static void main(String[] args) {

        List<Integer> myList =
                Util.generateNote()
                        .stream()
                        .map(Note::getTagName)
                        .map( x -> Integer.parseInt(Character.toString(x.charAt(4))))
                        .filter(x -> x>3)
                        .map(x -> x+10)
                        .collect(Collectors.toList());

        System.out.println(myList);

    }

}
