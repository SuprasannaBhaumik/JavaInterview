package com.learning.java8.streams.optional;

import java.util.Optional;

public class Optional_Else_Forms {

    public static String orElse() {
        Optional<String> stringOptional = Optional.ofNullable(null);
        return stringOptional.orElse("name");
    }

    public static String orElseGet() {
        Optional<String> stringOptional = Optional.ofNullable(null);
        return stringOptional.orElseGet(() -> "name");
    }

    public static String orElseThrow() {
        Optional<String> stringOptional = Optional.ofNullable(null);
        return stringOptional.orElseThrow(() -> new RuntimeException("no data available"));
    }

    public static void main(String[] args) {

        System.out.println("orElse: " + orElse());
        System.out.println("orElseGet: " + orElseGet());
        System.out.println("orElseThrow: " + orElseThrow());

    }
}
