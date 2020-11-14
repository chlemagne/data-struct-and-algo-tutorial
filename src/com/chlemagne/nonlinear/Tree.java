package com.chlemagne.nonlinear;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    public int height() {
        return height(root);
    }

    private int height(Node root) {
        /*  Height Calculation:
                           7
                    4            9
                 1     6      8    10


            - height(non-leaf) is the longest distance from the last child (left or right) leaf node.
            - height(leaf) is ZERO.
            - A leaf node does not have any children.

            Formula:
            ========

            height(node) = 1 + max(height(leftChild), height(rightChild));

            NOTE: tree height != tree depth
         */

        // edge case; empty tree or no nodes at all
        if (root == null)
            return -1;

        // base condition; leaf node
        if (isLeaf(root))
            return 0;

        return 1 + Math.max(height(root.leftChild), height(root.rightChild));
    }

    /**
     * Find the minimum value using O(n) algorithm for General Binary Trees.
     */
    public int min1() {
        return min1(root);
    }

    // min1() method has a runtime complexity of O(n) and can be applied to General Binary Trees.
    private int min1(Node root) {
        /*  Find minimum:
                           20
                    10            30
                 6      24     4
              8     3

        */

        // edge condition
        if (root == null) {
            throw new IllegalStateException();
        }

        // base condition
        if (isLeaf(root))
            return root.value;

        int minLeft = min1(root.leftChild);
        int minRight = min1(root.rightChild);

        return Math.min(root.value, Math.min(minLeft, minRight));
    }

    /**
     * Find the minimum value using O(log n) algorithm for Binary Search Trees.
     */
    public int min2() {
        return min2(root);
    }

    // min1() method has a runtime complexity of O(log n) and can be applied ONLY to Binary Search Trees.
    private int min2(Node root) {
        /*  Find minimum:
                           7
                    4            9
                 1     6      8    10

            In Binary Search Trees, the left-most leaf is the MINIMUM.
        */

        // edge case
        if (root == null)
            throw new IllegalStateException();

        Node current = root;
        while(current.leftChild != null)
            current = current.leftChild;

        return current.value;
    }

    public boolean equals(Tree other) {
        return equals(root, other.root);
    }
    
    private boolean equals(Node first, Node second) {
        // base condition 1
        if (first == null && second == null)
            return true;

        // recursion with condition
        if (first != null && second != null)
            return first.value == second.value
                    && equals(first.leftChild, second.leftChild)
                    && equals(first.rightChild, second.rightChild);

        // everything else, return false
        return false;
    }

    public boolean isBinarySearchTree() {
        return isBinarySearchTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isBinarySearchTree(Node node, int min, int max) {
        // base condition 1
        if (node == null)
            return true;

        // base condition 2
        if ((node.value < min) || (node.value > max))
            return false;

        // recursion
        return isBinarySearchTree(node.leftChild, min, node.value - 1)
                && isBinarySearchTree(node.rightChild, node.value + 1, max);
    }

    public List<Integer> getNodesAtDistance(int distance) {
        List<Integer> list = new ArrayList<>();
        getNodesAtDistance(root, distance, list);
        return list;
    }

    private void getNodesAtDistance(Node node, int distance, List<Integer> list) {
        // base condition 1
        if (node == null)
            return;

        // base condition 2
        if (distance == 0) {
            list.add(node.value);
            return;
        }

        // recursion
        getNodesAtDistance(node.leftChild, distance - 1, list);
        getNodesAtDistance(node.rightChild, distance - 1, list);
    }

    public void traverseLevelOrder() {
        // breadth-first or level-order traversal
        for (int i = 0; i <= height(root); i++) {
            List<Integer> list = getNodesAtDistance(i);
            System.out.println(Arrays.toString(list.toArray(new Integer[0])));
        }
    }

    private boolean isLeaf(Node node) {
        return (node.leftChild == null && node.rightChild == null) ? true : false;
    }

    private Node getOrCreateRoot(int value) {
        if (root == null)
            root = new Node(value);
        return root;
    }
}
