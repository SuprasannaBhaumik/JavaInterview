package com.learning.java8.streams.operators;

import java.util.stream.Stream;

public class Factory_Of_Generate_Iterate {

    public static void main(String[] args) {

        Stream<String> myStream = Stream.of("Suprasanna", "Bhaumik");
        myStream.forEach(System.out::println);

        //infinite stream
        Stream<Integer> integerStream = Stream.iterate( 10, x -> x*2).limit(4);
        integerStream.forEach(System.out::println);

        //infinite stream
        Stream<String> usingGenerate = Stream.generate( () -> {
            return "hrllo";
        }).limit(9);//stops with 9 items
        usingGenerate.forEach(System.out::println);

    }
}
