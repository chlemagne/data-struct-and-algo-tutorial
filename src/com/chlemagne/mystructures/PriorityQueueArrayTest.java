package com.chlemagne.mystructures;

public class PriorityQueueArrayTest {

    public static void main (String[] args) {

        PriorityQueueArray queue = new PriorityQueueArray(5);
        System.out.println(queue);
        System.out.println(queue.isEmpty());

        queue.add(5);
        System.out.println(queue);

        queue.add(3);
        System.out.println(queue);

        queue.add(4);
        System.out.println(queue);

        System.out.println(queue.remove());
        System.out.println(queue);

        System.out.println(queue.remove());
        System.out.println(queue);

        System.out.println(queue.remove());
        System.out.println(queue);
        System.out.println(queue.isEmpty());

        queue.add(8);
        queue.add(8);
        queue.add(8);
        queue.add(8);
        queue.add(2);
        System.out.println(queue.isFull());
        System.out.println(queue);

        System.out.println(queue.remove());
        System.out.println(queue);

        queue.add(9);
        System.out.println(queue);
    }
}
