package com.chlemagne.nonlinear;

public class HeapTest {
    public static void main (String[] args) {
        Heap heap = new Heap();
        heap.insert(10);
        heap.insert(5);
        heap.insert(17);
        heap.insert(4);
        heap.insert(22);
       System.out.println(heap);

        heap.remove();
        System.out.println(heap);
    }
}
