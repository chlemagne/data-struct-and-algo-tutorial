package com.chlemagne.nonlinear;

import java.util.HashMap;

public class Trie {
    private class Node {
        private char value;
        private HashMap<Character, Node> children;
        private boolean isEndOfWord;

        public Node(char value) {
            this.value = value;
            this.children = new HashMap<>();
            this.isEndOfWord = false;
        }

        public boolean hasChild(char c) {
            return children.containsKey(c);
        }

        public boolean hasChildren() {
            return !children.isEmpty();
        }

        public void addChild(char c) {
            children.put(c, new Node(c));
        }

        public void removeChild(char c) {
            children.remove(c);
        }

        public Node getChild(char c) {
            return children.get(c);
        }

        public boolean isEndOfWord() {
            return isEndOfWord;
        }

        public void setEndOfWord() {
            isEndOfWord = true;
        }

        public void unsetEndOfWord() {
            isEndOfWord = false;
        }

        @Override
        public String toString() {
            return Character.toString(value);
        }
    }

    private Node root;

    public Trie() {
        root = new Node(Character.MIN_VALUE);
    }

    public void insert(String word) {
        if (word == null)
            throw new IllegalArgumentException();

        Node node = root;
        for (char c : word.toCharArray()) {
            if (!node.hasChild(c))
                node.addChild(c);

            node = node.getChild(c);
        }
        node.setEndOfWord();
    }

    public boolean contains(String word) {
        if (word == null)
            return false;

        Node node = root;
        for (char c : word.toCharArray()) {
            if (!node.hasChild(c))
                return false;

            node = node.getChild(c);
        }
        return node.isEndOfWord();
    }

    public void remove(String word) {
        if (word == null)
            return;

        remove(root, word, 0);
    }

    private void remove(Node node, String word, int position) {
        // base condition
        if (position >= word.length()) {
            node.unsetEndOfWord();
            return;
        }

        char c = word.charAt(position);
        Node child = node.getChild(c);
        if (!node.hasChild(c))
            return;

        // recursion
        remove(child, word, ++position);

        // post-order routine
        if (!child.hasChildren() && !child.isEndOfWord())
            node.removeChild(c);
    }
}
