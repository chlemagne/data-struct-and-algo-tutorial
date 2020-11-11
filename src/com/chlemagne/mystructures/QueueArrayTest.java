package com.chlemagne.mystructures;

public class QueueArrayTest {

    public static void main (String[] args) {

        QueueArray queue = new QueueArray(5);
        System.out.println(queue);
        System.out.println(queue.isEmpty());
        System.out.println(queue.isFull());
        queue.add(10);
        queue.add(20);
        queue.add(30);
        System.out.println(queue);
        queue.add(40);
        queue.add(50);
        System.out.println(queue);
        System.out.println(queue.isEmpty());
        System.out.println(queue.isFull());

        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue);
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue);
        System.out.println(queue.isEmpty());
        System.out.println(queue.isFull());

        queue.add(60);
        queue.add(70);
        queue.add(80);
        System.out.println(queue);
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue);




    }
}
