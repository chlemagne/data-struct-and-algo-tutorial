/*
    ARRAYS vs LINKED LIST
    +-----------------------+-----------+-------------+
    | Comparison            | Arrays    | Linked List |
    +===========+===========+===========+=============+
    | Lookup    | By index  | O(1) *    | O(n)        |
    |           | By value  | O(n)      | O(n)        |
    +-----------+-----------+-----------+-------------+
    | Insert    | Head/Tail | O(n)      | O(1) *      |
    |           | Middle    | O(n)      | O(n)        |
    +-----------+-----------+-----------+-------------+
    |           | Head      | O(n)      | O(1) *      |
    | Delete    | Middle    | O(n)      | O(n)        |
    |           | Tail      | O(n)      | O(n)        |
    +-----------+-----------+-----------+-------------+

*/
package com.chlemagne.mystructures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

public class LinkedList {
    private Node first;
    private Node last;

    private class Node {
        private int value;
        private Node next;

        /**
         * Create a primitive-type integer Node object, pointing to itself as the next Node.
         * @param value
         */
        public Node(int value) {
            this.value = value;
            this.next = null;
        }

        /**
         * isLast.
         * @return ``true`` if Node is the last in the list.
         */
        public boolean isLast() {
            return next == null;
        }

        public void setLast() {
            next = null;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", isLast=" + isLast() +
                    '}';
        }
    }

    /**
     * Create an empty primitive-type integer LinkedList object.
     */
    public LinkedList() {
        first = last = null;
    }

    /**
     * Create a non-empty primitive-type integer LinkedList object.
     */
    public LinkedList(int a, int b) {
        last = new Node(b);
        first = new Node(a);
        first.next = last;
    }

    /**
     * Add node at the head of the list.
     * @param a
     */
    public void addFirst(int a) {
        Node node = new Node(a);
        if (isEmpty())
            first = last = node;
        else {
            node.next = first;
            first = node;
        }
    }

    /**
     * Add node at the tail of the list.
     * @param a
     */
    public void addLast(int a) {
        Node node = new Node(a);
        if (isEmpty())
            first = last = node;
        else {
            last.next = node;
            last = node;
        }
    }

    /**
     * Remove the node at the head of the list.
     */
    public void deleteFirst() {
        if (first.next.isLast() || isEmpty())
            throw new NoSuchElementException();
        else
            first = first.next;
    }

    /**
     * Remove the node at the tail of the list.
     */
    public void deleteLast() {
        Node penultimate = getPenultimate();
        if (first == penultimate || isEmpty())
            throw new NoSuchElementException();
        else
            last = penultimate;
            last.setLast();
    }

    /**
     * Find a value using linear search algorithm.
     * @param a
     * @return true if value is found.
     */
    public boolean contains(int a) {
        return (indexOf(a) != -1);
    }

    /**
     * Find a value using linear search algorithm.
     * @param a
     * @return Index if value is found. Otherwise, -1.
     */
    public int indexOf(int a) {
        if (isEmpty())
            return -1;

        int index = 0;
        Node node = first;
        while(true) {
            if (a == node.value) return index;
            if (node.isLast()) break;
            node = node.next;
            index++;
        }

        return -1;
    }

    /**
     * Get the second to the last node.
     * @return Node.
     */
    private Node getPenultimate() {
        Node penultimate = first;
        // linear search algorithm
        while(true) {
            if (penultimate.next.isLast()) break;
            penultimate = penultimate.next;
        }

        return penultimate;
    }

    /**
     * isEmpty.
     * @return true if empty.
     */
    public boolean isEmpty() {
        return (first == null && last == null);
    }

    @Override
    public String toString() {
        if (isEmpty())
            return "[]";

        Node node = first;
        List<Integer> list = new ArrayList<>();
        while(true) {
            list.add(node.value);
            if (node.isLast()) break;
            node = node.next;
        }

        return Arrays.toString(list.toArray());
    }
}
