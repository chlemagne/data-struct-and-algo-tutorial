package com.chlemagne.mystructures;

public class LinkedListTest {

    public static void main (String[] args) {

        LinkedList list = new LinkedList();
        list.reverse();
        System.out.println(list);

        list.addLast(40);
        list.reverse();
        System.out.println(list);

        list.addLast(50);
        System.out.println(list);

        list.addFirst(30);
        list.addLast(60);
        System.out.println(list);

        list.deleteFirst();
        System.out.println(list);

        list.deleteLast();
        System.out.println(list);

        list.addFirst(30);
        list.addFirst(20);
        list.addFirst(10);
        System.out.println(list);

        list.addLast(60);
        list.addLast(70);
        list.addLast(80);
        System.out.println(list);

        System.out.printf("Does list contains a 80-valued node? %s%n", list.contains(80));
        System.out.printf("Does list contains a 200-valued node? %s%n", list.contains(200));

        System.out.printf("Index of 80-valued node: %d%n", list.indexOf(80));
        System.out.printf("Index of 200-valued node: %d%n", list.indexOf(200));

        list.reverse();
        System.out.println(list);

        System.out.printf("Find k=1 value from the end: %d%n", list.getKthFromEnd(1));
        System.out.printf("Find k=3 value from the end: %d%n", list.getKthFromEnd(3));
        System.out.printf("Find k=8 value from the end: %d%n", list.getKthFromEnd(8));
        //System.out.printf("Find k=100 value from the end: %d%n", list.getKthFromEnd(100));
    }
}
