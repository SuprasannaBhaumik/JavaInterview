package com.learning.java8.streams.optional;

import java.util.Optional;

public class Of_Empty_OfNullable {

    public static Optional<String> ofNullable() {
        //this returns Optional.empty
        return Optional.ofNullable(null);
    }

    public static Optional<String> of() {
        //this returns  exception
        return Optional.of(null);
    }

    public static void main(String[] args) {

        System.out.println("-------using ofNullable ------");
        System.out.println("ofNullable: " + ofNullable());

        System.out.println("-------using of ------");
        System.out.println("of: " + of());
        //System.out.println("Fetch using get :" + of().get());


    }
}
