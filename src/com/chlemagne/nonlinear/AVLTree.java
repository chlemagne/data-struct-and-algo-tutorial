package com.chlemagne.nonlinear;

public class AVLTree {
    private AVLNode root;
    private class AVLNode {
        private int value;
        private int height;
        private AVLNode leftChild;
        private AVLNode rightChild;

        public AVLNode(int value) {
            this.value = value;
            this.height = 0;
            this.leftChild = null;
            this.rightChild = null;
        }

        @Override
        public String toString() {
            return "Value=" + value;
        }
    }

    /* *****************************************************
     *****  PUBLIC METHODS
     ******************************************************/
    public void insert(int value) {
        root = insert(root, value);
    }

    /* *****************************************************
     *****  PRIVATE METHODS
     ******************************************************/
    private AVLNode insert(AVLNode node, int value) {
        // base condition
        if (node == null)
            return new AVLNode(value);

        // recursion
        if (value < node.value)
            node.leftChild = insert(node.leftChild, value);
        else
            node.rightChild = insert(node.rightChild, value);

        node.height = 1 + Math.max(
            height(node.leftChild),
            height(node.rightChild)
        );

        return node;
    }

    private int height(AVLNode node) {
        return (node == null) ? -1 : node.height;
    }

    private int balanceFactor(AVLNode node) {
        return (node == null) ? 0 : height(node.leftChild) - height(node.rightChild);
    }

    /* *****************************************************
     *****  OVERRIDE METHODS
     ******************************************************/
}
