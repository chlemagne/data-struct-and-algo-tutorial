package com.chlemagne.linear;

import java.util.LinkedList;

public class HashTable {
    private class Entry {
        private final int key;
        private String value;

        private Entry(int key, String value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return key + "=" + value;
        }
    }

    private LinkedList<Entry>[] entries;

    private static final int DEFAULT_SIZE = 5;

    /**
     * Create HashTable with default size.
     */
    public HashTable() {
        this(DEFAULT_SIZE);
    }

    /**
     * Create HashTable with custom size.
     * @param size
     */
    public HashTable(int size) {
        this.entries = new LinkedList[size];
    }

    /**
     * Associates the specified value with the specified key in this map.
     * @param k
     * @param v
     */
    public void put(int k, String v) {
        if (v == null)
            throw new NullPointerException();

        int hashCode = hash(k);
        if (entries[hashCode] == null)
            entries[hashCode] = new LinkedList<>();

        int index = findIndex(k);
        if (index == -1)
            entries[hashCode].addLast(new Entry(k, v));
        else
            entries[hashCode].get(index).value = v;
    }

    /**
     * Returns the value to which the specified key is mapped, or null if this map contains no mapping for the key.
     * @param k
     * @return String
     */
    public String get(int k) {
        return entries[hash(k)].get(findIndex(k)).value;
    }

    /**
     * Removes the mapping for the specified key from this map if present.
     * @param k
     */
    public void remove(int k) {
        entries[hash(k)].remove(findIndex(k));
    }

    /**
     * Returns a hash code value for the object.
     * @return int
     */
    private int hash(int k) {
        return k % entries.length;
    }

    /**
     * Returns an index of the corresponding linked list in the table.
     * @return int
     */
    private int findIndex(int k) {
        int hashCode = hash(k);

        if (entries[hashCode] == null)
            throw new NullPointerException();

        for (int i = 0; i < entries[hashCode].size(); i++) {
            Entry entry = entries[hashCode].get(i);
            if (k == entry.key) {
                return i;
            }
        }
        return -1;

    }
    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < entries.length; i++) {

            if (entries[i] == null)
                continue;

            for (int j = 0; j < entries[i].size(); j++)
                buffer.append(entries[i].get(j) + ", ");
        }
        return "{" + buffer + "}";
    }
}
