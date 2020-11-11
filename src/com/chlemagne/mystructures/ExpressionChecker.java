package com.chlemagne.mystructures;

import java.util.*;

public class ExpressionChecker {

    private static ArrayList<Character> openingBrackets =
            new ArrayList<>(List.of('(', '[', '{', '<'));
    private static ArrayList<Character> closingBrackets =
            new ArrayList<>(List.of(')', ']', '}', '>'));

    public static boolean isBalanced(String expression) {
        Stack<Character> stack = new Stack();
        for (char c : expression.toCharArray()) {
            if (isOpeningBracket(c)) stack.push(c);

            if (isClosingBracket(c)) {
                if (stack.isEmpty()) return false;
                if (!bracketsMatch(c, stack.pop())) return false;
            }
        }

        return stack.isEmpty();
    }

    private static boolean bracketsMatch(char o, char c) {
        return openingBrackets.indexOf(o) == closingBrackets.indexOf(c);
    }

    private static boolean isOpeningBracket(char c) {
        return openingBrackets.contains(c);
    }

    private static boolean isClosingBracket(char c) {
        return closingBrackets.contains(c);
    }
}
