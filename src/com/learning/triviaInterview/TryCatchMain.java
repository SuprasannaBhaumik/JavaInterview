package com.learning.triviaInterview;

import java.util.regex.Pattern;

public class TryCatchMain {

    public static void main(String[] args) {


       // System.out.println(getNumber());

        String fuel = "3.455";
        String newDate = "2022-02-03T11:23:56.734Z";

        Pattern NUMBER_REGEX = Pattern.compile("^\\d+\\.?\\d{0,2}$");
        //System.out.println(NUMBER_REGEX.matcher(fuel).matches());

        Pattern DATE_REGEX = Pattern.compile("^\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}.\\d{3}Z?$");
        System.out.println(DATE_REGEX.matcher(newDate).matches());


    }

    public static int getNumber() {
        try {
            int i = 23 / 0;
            int[] arr = new int[2];
            arr[0] = 1;
            arr[1] = 2;
            arr[2] = 30;
            return arr[3];
        } catch (Exception e) {
            System.out.println("inside exception");
            return 2;
        }
        /*catch(ArithmaticException e) {

        }*/ finally {
            System.out.println("inside catch");
            return 3;
        }

    }
}

//normal execution : Output -> 3
// with exception in catch ->
