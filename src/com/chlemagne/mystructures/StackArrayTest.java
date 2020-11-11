package com.chlemagne.mystructures;


import java.util.EmptyStackException;

public class StackArrayTest {

    public static void main (String[] args) {
        StackArray stack = new StackArray();
        System.out.println(stack.isEmpty());
        System.out.println(stack);
        try {
            stack.pop();
            stack.peek();
        } catch (EmptyStackException e) {
            System.out.println("Push first.");
        }
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println(stack);
        System.out.println(stack.peek());
        System.out.println(stack);
        System.out.println(stack.pop());
        System.out.println(stack);
        System.out.println(stack.peek());
    }
}
