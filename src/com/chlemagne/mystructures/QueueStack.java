package com.chlemagne.mystructures;

import java.util.EmptyStackException;
import java.util.Stack;

public class QueueStack {
    private Stack<Integer> enqueue;
    private Stack<Integer> dequeue;

    /**
     * Create QueueArray object.
     */
    public QueueStack() {
        enqueue = new Stack();
        dequeue = new Stack();
    }

    /**
     * Inserts the specified element at the end of this deque.
     * @param item
     */
    public void add(int item) {
        enqueue.push(item);
    }

    /**
     * Retrieves and removes the head of the queue represented by this deque.
     * @return int
     */
    public int remove() {
        if (isEmpty()) throw new EmptyStackException();

        if (dequeue.isEmpty())
            transferStack(enqueue, dequeue);

        return dequeue.pop();
    }

    /**
     * Retrieves, but does not remove, the head of the queue represented by this deque.
     * @return int
     */
    public int peek() {
        if (isEmpty()) throw new EmptyStackException();

        if (dequeue.isEmpty())
            transferStack(enqueue, dequeue);

        return dequeue.peek();
    }

    /**
     * Returns true if this deque contains no elements.
     * @return boolean
     */
    public boolean isEmpty() {
        return (enqueue.isEmpty() && dequeue.isEmpty());
    }

    /**
     * Transfer (inverted) items in source stack to destination stack.
     * @param src
     * @param dst
     */
    private void transferStack(Stack<Integer> src, Stack<Integer> dst) {
        while(!src.isEmpty())
            dst.push(src.pop());
    }

    @Override
    public String toString() {
        if (enqueue.isEmpty())
            transferStack(dequeue, enqueue);

        return enqueue.toString();
    }
}
