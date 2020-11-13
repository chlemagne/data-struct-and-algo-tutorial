package com.chlemagne.nonlinear;

public class TreeTest {
    public static void main (String[] args) {
        Tree tree = new Tree();
        tree.insert(10);
        tree.insert(20);
        tree.insert(3);
        tree.insert(9);
        tree.insert(33);

        System.out.println(tree.find(9));
    }
}
