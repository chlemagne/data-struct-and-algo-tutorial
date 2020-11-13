package com.chlemagne.linear;

public class DynamicIntArrayTest {

    public static void main (String[] args) {

        DynamicIntArray array = new DynamicIntArray(3);
        System.out.printf("dbg_a: %s%n", array);

        array.insert(10);
        array.insert(20);
        array.insert(30);
        System.out.printf("dbg_b: %s%n", array);
        array.indexOf(100);

        array.insert(40);
        System.out.printf("dbg_c: %s%n", array);

        System.out.printf("dbg_d: %s%n", array.indexOf(30));

        array.removeAt(1);
        System.out.printf("dbg_e: %s%n", array.indexOf(30));
        System.out.printf("dbg_f: %s%n", array);

        array.insert(50);
        array.insert(60);
        array.insert(70);
        System.out.printf("dbg_g: %s%n", array);
        array.removeAt(array.indexOf(70));
        System.out.printf("dbg_h: %s%n", array);

        array.insert(80);
        System.out.printf("dbg_i: %s%n", array);
    }
}
