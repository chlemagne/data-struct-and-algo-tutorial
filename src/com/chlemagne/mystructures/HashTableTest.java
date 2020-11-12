package com.chlemagne.mystructures;

public class HashTableTest {

    public static void main (String[] args) {
        HashTable table = new HashTable();
        System.out.println(table);

        table.put(1, "a");
        table.put(1, "o");
        System.out.println(table);

        table.put(86, "j");
        table.put(234, "p");
        System.out.println(table);

        System.out.println(table.get(234));

        table.remove(86);
        System.out.println(table);

    }
}
