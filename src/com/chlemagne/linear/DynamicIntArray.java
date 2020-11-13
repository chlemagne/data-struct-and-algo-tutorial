package com.chlemagne.linear;


import java.util.Arrays;

/**
 * Custom Dynamic Integer Array using linear algorithms.
 */
public class DynamicIntArray {

    private int insertPointer;
    private int[] items;

    /**
     * Create dynamic int array of fixed length.
     * @param length
     */
    public DynamicIntArray(int length) {
        this.insertPointer = 0;
        this.items = new int[length];
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOfRange(items, 0, insertPointer));
    }

    /**
     * Insert item from the tail of the array.
     * @param item
     */
    public void insert(int item) {
        // check size
        if (insertPointer >= items.length)
            doubleArraySize();

        items[insertPointer++] = item;
    }

    /**
     * Remove item at index. As result, items to the right of index will be shifted to the left
     * and the new size of the array is one less.
     * @param index
     */
    public void removeAt(int index) {
        /*
            Scenario 1:
                count = 321 (after insert)
                index = 320
         */
        // validate index
        if (index < 0 || index >= insertPointer)
            throw new IndexOutOfBoundsException();

        // linear algorithm
        for (int i = index; i < insertPointer; i++) {
            /* Shift-left either:
                a.) items[1 + 1] or right adjacent item
                b.) zero (0) if index is last item */
            items[i] = (index == insertPointer - 1) ? 0 : items[i + 1]; // shift-left
        }

        this.insertPointer--;
    }

    /**
     * Find the first match of item and return its index.
     * @param item
     * @return Index of item if found or -1.
     */
    public int indexOf(int item) {

        // linear search algorithm
        for (int i = 0; i < insertPointer; i++) {
            if (item == items[i])
                return i;
        }

        return -1;
    }

    /**
     * Resize array size by one. Items in the original array are linearly copied to the new array.
     */
    private void doubleArraySize() {

        int[] temp = new int[items.length * 2]; // double the length of new array

        // linear copy algorithm
        for (int i = 0; i < items.length; i++)
            temp[i] = items[i]; // copy item in original array to the new array

        items = temp; // discard original array
    }
}
