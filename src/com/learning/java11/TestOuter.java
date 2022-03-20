package com.learning.java11;

import java.lang.reflect.Field;

/**
 * Nest based access control
 * Allows for classes and interfaces to be nested within each other
 */
public class TestOuter {

    private static int MYVARIABLE = 17;

    public static class NestedInner {

        public static void test() throws Exception {
            Field value = TestOuter.class.getDeclaredField("MYVARIABLE");
            value.setInt(null, 12);
        }

    }

    public static void main(String[] args) throws Exception {
        NestedInner.test();
        System.out.println(TestOuter.MYVARIABLE);
    }

}
