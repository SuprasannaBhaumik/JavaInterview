package com.learning.triviaInterview;

class A {
    public void methodA() {
        System.out.println("inside methodA");
        methodB();
    }

    public void methodB() {
        System.out.println("A b method");
    }
}
