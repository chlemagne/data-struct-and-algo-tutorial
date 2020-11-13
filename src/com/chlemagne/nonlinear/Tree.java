package com.chlemagne.nonlinear;


public class Tree {

    private Node root;
    private class Node {
        private int value;
        private Node leftChild;
        private Node rightChild;

        public Node(int value) {
            this(value, null, null);
        }

        public Node(int value, Node leftChild, Node rightChild) {
            this.value = value;
            this.leftChild = leftChild;
            this.rightChild = rightChild;
        }

        public Node getOrCreateLeftChild(int value) {
            if (leftChild == null)
                leftChild = new Node(value);

            return leftChild;
        }

        public Node getOrCreateRightChild(int value) {
            if (rightChild == null)
                rightChild = new Node(value);

            return rightChild;
        }

        @Override
        public String toString() {
            return Integer.toString(value);
        }
    }

    public Tree() {
        this.root = null;
    }

    public void insert(int value) {
        Node node = getOrCreateRoot(value);

        while(value != node.value) {
            if (value > node.value)
                node = node.getOrCreateRightChild(value);

            else // (value < node.value)
                node = node.getOrCreateLeftChild(value);
        }
    }

    public boolean find(int value) {
        Node node = root;
        while(node != null) {
            if (value == node.value)
                return true;
            if (value > node.value)
                node = node.rightChild;
            else if (value < node.value)
                node = node.leftChild;
        }

        return false;
    }

    private Node getOrCreateRoot(int value) {
        if (root == null)
            root = new Node(value);
        return root;
    }
}
