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

    public void traversePreOrder() {
        traversePreOrder(root);
        System.out.println();
    }

    private void traversePreOrder(Node root) {
        /*  Pre-order traversal: root, left, right
                           7
                    4            9
                 1     6      8    10

            Console: 7, 4, 1, 6, 9, 8, 10
         */

        // base condition
        if (root == null)
            return;

        System.out.printf("%d, ", root.value);
        traversePreOrder(root.leftChild);
        traversePreOrder(root.rightChild);
    }

    public void traverseInOrder() {
        traverseInOrder(root);
        System.out.println();
    }

    private void traverseInOrder(Node root) {
        /*  In-order traversal: left, root, right (ascending)
                           7
                    4            9
                 1     6      8    10

            Console: 1, 4, 6, 7, 8, 9, 10
         */

        // base condition
        if (root == null)
            return;

        traverseInOrder(root.leftChild);
        System.out.printf("%d, ", root.value);
        traverseInOrder(root.rightChild);
    }

    public void traversePostOrder() {
        traversePostOrder(root);
        System.out.println();
    }

    private void traversePostOrder(Node root) {
        /*  Post-order traversal: left, right, root
                           7
                    4            9
                 1     6      8    10

            Console: 1, 6, 4, 8, 10, 9, 7
         */

        // base condition
        if (root == null)
            return;

        traversePostOrder(root.leftChild);
        traversePostOrder(root.rightChild);
        System.out.printf("%d, ", root.value);
    }

    private Node getOrCreateRoot(int value) {
        if (root == null)
            root = new Node(value);
        return root;
    }
}
