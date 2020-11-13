package com.chlemagne.linear;

import java.util.Arrays;
import java.util.EmptyStackException;

public class StackArray {
    private int[] items;
    private int count;

    private final static int DEFAULT_SIZE = 10;

    /**
     * Create StackArray object with default size of {@value StackArray#DEFAULT_SIZE}.
     */
    public StackArray() {
        this(DEFAULT_SIZE);
    }

    /**
     * Create StackArray object with custom size.
     * @param size
     */
    public StackArray(int size) {
        count = 0;
        items = new int[size];
    }

    /**
     * Add item into the top of the stack.
     * @param item
     */
    public void push(int item) {
        if (count >= items.length) throw new StackOverflowError();
        items[count++] = item;
    }

    /**
     * Return the top item and remove it from stack.
     * @return
     */
    public int pop() {
        if (count == 0) throw new EmptyStackException();
        return items[--count];
    }

    /**
     * Return the top item without deleting it.
     * @return
     */
    public int peek() {
        if (count == 0) throw new EmptyStackException();
        return items[count - 1];
    }

    /**
     * isEmpty.
     * @return true if stack is empty.
     */
    public boolean isEmpty() {
        return count < 1;
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOfRange(items, 0, count));
    }
}
