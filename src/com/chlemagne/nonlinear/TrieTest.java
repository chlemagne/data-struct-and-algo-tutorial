package com.chlemagne.nonlinear;

public class TrieTest {
    public static void main (String[] args) {
        Trie trie = new Trie();
        trie.insert("ba");
        trie.insert("bat");
        trie.insert("cat");
        trie.insert("cab");
        trie.insert("canada");
        trie.insert("digger");
        trie.insert("battery");

        String test = "battery";
        System.out.println(trie.contains(test));
        trie.remove(test);
        System.out.println(trie.contains(test));
    }
}
