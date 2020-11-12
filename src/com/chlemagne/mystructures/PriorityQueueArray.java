package com.chlemagne.mystructures;

import java.util.Arrays;
import java.util.EmptyStackException;

public class PriorityQueueArray {
    private int[] items;
    private int count;

    private final static int DEFAULT_SIZE = 10;

    /**
     * Create PriorityQueueArray object with a default size of {@value PriorityQueueArray#DEFAULT_SIZE}.
     */
    public PriorityQueueArray() {
        this(DEFAULT_SIZE);
    }

    /**
     * Create PriorityQueueArray object with a custom size.
     * @param size
     */
    public PriorityQueueArray(int size) {
        count = 0;
        items = new int[size];
    }

    /**
     * Inserts the specified element into the correct priority.
     * @param item
     */
    public void add(int item) {
        if (isFull()) throw new StackOverflowError();

        int insert = item;
        int p = items.length - 1; // start at the back

        for (int i = 0; i < (count + 1); i++) {
            if (items[p] < item) {
                // swap items[p] and insert
                int temp = items[p];
                items[p] = insert;
                insert = temp;
            }
            p--;
        }
        count++;
    }

    /**
     * Retrieves and removes the highest priority item in the queue.
     * @return int
     */
    public int remove() {
        if (isEmpty()) throw new EmptyStackException();
        // [0, 0, 0, 0, 5]
        //           ^
        // count=2
        // size=5
        // size - count
        int item = items[items.length - count];
        items[items.length - count] = 0;
        count--;
        return item;
    }

    /**
     * Retrieves, but does not remove, the highest priority item in the queue.
     * @return int
     */
    public int peek() {
        if (isEmpty()) throw new EmptyStackException();
        return items[count - 1];
    }

    /**
     * Returns true if this deque is full.
     * @return boolean
     */
    public boolean isFull() {
        return count >= items.length;
    }

    /**
     * Returns true if this deque contains no elements.
     * @return boolean
     */
    public boolean isEmpty() {
        return count < 1;
    }

    @Override
    public String toString() {
        return Arrays.toString(items);
    }
}
