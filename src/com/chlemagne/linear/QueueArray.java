package com.chlemagne.linear;

import java.util.Arrays;
import java.util.EmptyStackException;

public class QueueArray {
    private int[] items;
    private int head;
    private int tail;
    private int count;

    private final static int DEFAULT_SIZE = 10;

    /**
     * Create QueueArray object with a default size of {@value QueueArray#DEFAULT_SIZE}.
     */
    public QueueArray() {
        this(DEFAULT_SIZE);
    }

    /**
     * Create QueueArray object with a custom size.
     * @param size
     */
    public QueueArray(int size) {
        head = 0;
        tail = 0;
        count = 0;
        items = new int[size];
    }

    /**
     * Inserts the specified element at the end of this deque.
     * @param item
     */
    public void add(int item) {
        if (isFull()) throw new StackOverflowError();

        items[tail] = item;
        tail = (tail + 1) % items.length;
        count++;
    }

    /**
     * Retrieves and removes the head of the queue represented by this deque.
     * @return int
     */
    public int remove() {
        if (isEmpty()) throw new EmptyStackException();

        int item = items[head];
        items[head] = 0;
        head = (head + 1) % items.length;
        count--;
        return item;
    }

    /**
     * Retrieves, but does not remove, the head of the queue represented by this deque.
     * @return int
     */
    public int peek() {
        if (isEmpty()) throw new EmptyStackException();
        return items[head];
    }

    /**
     * Returns true if this deque contains no elements.
     * @return boolean
     */
    public boolean isEmpty() {
        return count < 1;
    }

    /**
     * Returns true if this deque is full.
     * @return boolean
     */
    public boolean isFull() {
        return count >= items.length;
    }

    @Override
    public String toString() {
        return Arrays.toString(items);
    }
}
