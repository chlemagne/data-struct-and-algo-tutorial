package com.chlemagne.mystructures;

public class ReversalTest {

    public static void main (String[] args) {
        String testString = "aeiou";
        System.out.printf("Reverse of string \"%s\" is \"%s\"",
                testString,
                Reversal.reverse(testString)
        );
    }
}
