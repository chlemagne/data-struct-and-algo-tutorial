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

        setHeight(node);

        return balance(node);
    }

    private int height(AVLNode node) {
        return (node == null) ? -1 : node.height;
    }

    private int balanceFactor(AVLNode node) {
        return (node == null) ? 0 : height(node.leftChild) - height(node.rightChild);
    }

    private boolean isLeftHeavy(AVLNode node) {
        return balanceFactor(node) > 1;
    }

    private boolean isRightHeavy(AVLNode node) {
        return balanceFactor(node) < -1;
    }

    private AVLNode balance(AVLNode node) {
        /*   Tree Balancing
            +-----------+-------------------+-----------+
            | Tree      | Balance Factor    | Rotation  |
            +===========+===================+===========+
            | a         | -2                | L         | Right-heavy
            |   b       | -1                |           |
            |     c     |                   |           |
            +-----------+-------------------+-----------+
            |     a     | 2                 | R         | Left-heavy
            |   b       | 1                 |           |
            | c         |                   |           |
            +-----------+-------------------+-----------+
            | a         | -2                |   L       | Right-heavy
            |   b       | 1                 | R         |
            | c         |                   |           |
            +-----------+-------------------+-----------+
            |   a       | 2                 |   R       | Left-heavy
            | b         | -1                | L         |
            |   c       |                   |           |
            +-----------+-------------------+-----------+
         */

        if (isLeftHeavy(node)) {
            if (balanceFactor(node.leftChild) < 0)
                node.leftChild = rotateLeft(node.leftChild);

            return rotateRight(node);
        }
        else if (isRightHeavy(node)) {
            if (balanceFactor(node.rightChild) > 0)
                node.rightChild = rotateRight(node.rightChild);

            return rotateLeft(node);
        }

        return node;
    }

    private void setHeight(AVLNode node) {
        node.height = 1 + Math.max(
                height(node.leftChild),
                height(node.rightChild)
        );
    }

    private AVLNode rotateLeft(AVLNode node) {
        AVLNode other = node.rightChild;

        node.rightChild = other.leftChild;
        other.leftChild = node;

        setHeight(node);
        setHeight(other);

        return other;
    }

    private AVLNode rotateRight(AVLNode node) {
        AVLNode other = node.leftChild;

        node.leftChild = other.rightChild;
        other.leftChild = node;

        setHeight(node);
        setHeight(other);

        return other;
    }

    /* *****************************************************
     *****  OVERRIDE METHODS
     ******************************************************/
}
