package com.learning.java8.streams.optional;

import java.util.Optional;

public class Optional_Present_Forms {

    public static void main(String[] args) {

        Optional<Integer> integerOptional = Optional.ofNullable(null);
        System.out.println(integerOptional.isPresent());

        Optional<Integer> integerOptional2 = Optional.ofNullable(2);
        System.out.println(integerOptional2.isPresent());

        //extracts the data out of it
        integerOptional2.ifPresent(System.out::println);

    }
}
