package com.chlemagne.linear;

public class ExpressionCheckerTest {

    public static void main (String[] args) {

        String[] testStrings = {
            "int factor = (1 - b);",            // true
            "for [((int number : {numbers}));",  // false
            "([{<>}])",                         // true
            "([{<<)  }])"                       // false
        };

        for (String string : testStrings)
            System.out.printf("%s%n\tIs Balanced: %s%n%n", string, ExpressionChecker.isBalanced(string));
    }
}
