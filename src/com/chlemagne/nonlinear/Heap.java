package com.chlemagne.nonlinear;

import java.util.Arrays;

public class Heap {
    private int count;
    private int[] items;

    private static final int DEFAULT_SIZE = 10;

    /* *****************************************************
     *****  PUBLIC METHODS
     ******************************************************/

    public Heap() {
        this(DEFAULT_SIZE);
    }

    public Heap(int size) {
        this.count = 0;
        this.items = new int[size];
    }

    public boolean isFull() {
        return count > items.length;
    }

    public boolean isEmpty() {
        return count < 1;
    }

    public void insert(int value) {
        if (isFull())
            throw new IllegalStateException();

        items[count++] = value;

        bubbleUp();
    }

    public int remove() {
        if (isEmpty())
            throw new IllegalStateException();

        int root = items[0];
        items[0] = items[--count];

        bubbleDown();

        return root;
    }

    @Override
    public String toString() {
        return Arrays.toString(items);
    }

    /* *****************************************************
     *****  PRIVATE METHODS
     ******************************************************/

    private int parentIndex(int childIndex) {
        return (childIndex - 1) / 2;
    }

    private int leftChildIndex(int parentIndex) {
        return (parentIndex * 2) + 1;
    }

    private int rightChildIndex(int parentIndex) {
        return (parentIndex * 2) + 2;
    }

    private int leftChild(int parentIndex) {
        return items[leftChildIndex(parentIndex)];
    }

    private int rightChild(int parentIndex) {
        return items[rightChildIndex(parentIndex)];
    }

    private boolean isParentValid(int parentIndex) {
        if (!hasLeftChild(parentIndex))
            return true;

        boolean isValid = items[parentIndex] >= leftChild(parentIndex);

        if (!hasRightChild(parentIndex))
            isValid &= items[parentIndex] >= rightChild(parentIndex);

        return isValid;
    }

    private int largerChildIndex(int parentIndex) {
        return (leftChild(parentIndex) > rightChild(parentIndex) ?
                leftChildIndex(parentIndex) : rightChildIndex(parentIndex));
    }

    private boolean hasLeftChild(int parentIndex) {
        return leftChildIndex(parentIndex) <= count;
    }

    private boolean hasRightChild(int parentIndex) {
        return rightChildIndex(parentIndex) <= count;
    }

    private void swapItems(int n, int m) {
        int temp = items[n];
        items[n] = items[m];
        items[m] = temp;
    }

    private void bubbleUp() {
        /*  ORIGINAL ALGO CODE
        >>>>>>>
            int childIndex = count - 1;
            int parentIndex = getParentIndex(childIndex);
            while(childIndex > 0 || parentIndex > 0) {
                if (items[childIndex] > items[parentIndex]) {
                    swapItems(childIndex, parentIndex);

                    childIndex = parentIndex;
                    parentIndex = getParentIndex(childIndex);
                }
                else {
                    break;
                }
            }
        <<<<<<< */

        // Refactored (with added edge case in childIndex > 0):
        int childIndex = count - 1;
        while((childIndex > 0) && (items[childIndex] > items[parentIndex(childIndex)])) {
            swapItems(childIndex, parentIndex(childIndex));
            childIndex = parentIndex(childIndex);
        }
    }

    private void bubbleDown() {
        int parentIndex = 0;
        while((parentIndex <= count) && (!isParentValid(parentIndex))) {
            int largerChildIndex = largerChildIndex(parentIndex);

            swapItems(parentIndex, largerChildIndex);
            parentIndex = largerChildIndex;
        }
    }

}
