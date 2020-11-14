package com.chlemagne.nonlinear;

public class TreeTest {
    public static void main (String[] args) {
        Tree tree = new Tree();
        tree.insert(7);
        tree.insert(4);
        tree.insert(9);
        tree.insert(1);
        tree.insert(6);
        tree.insert(8);
        tree.insert(10);


        System.out.println(tree.find(9));

        // TRAVERSAL DEMO
        tree.traversePreOrder();
        tree.traverseInOrder();
        tree.traversePostOrder();
        System.out.println(tree.height());
        System.out.println(tree.min1());
        System.out.println(tree.min2());
    }
}
