package com.chlemagne.mystructures;

import java.util.Stack;

public class Reversal {

    /**
     * Invert a string.
     * @param string
     * @return inverted string.
     */
    public static String reverse(String string) {
        if (string == null)
            throw new IllegalArgumentException();

        Stack<Character> stack = new Stack();
        StringBuffer buffer = new StringBuffer(); // ideal for countless string manipulations

        for (char c : string.toCharArray()) stack.push(c);
        while(!stack.isEmpty()) {
            buffer.append(stack.pop());
        }

        return buffer.toString();
    }
}
