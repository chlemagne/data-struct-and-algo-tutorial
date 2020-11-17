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

        String[] words = {
                "came",
                "care",
                "cave",
                "cask",
                "carp",
                "cate",
                "canid",
                "caked",
                "calfs",
                "carks",
                "carafe",
                "carvel",
                "cardia",
                "catsup",
                "cashier",
                "capital",
                "careful",
                "calcium",
                "catfish",
                "caribou",
                "carotid",
                "carping",
                "carjack"
        };

        for (String word : words)
            trie.insert(word);

        System.out.println(trie.findWords(""));
    }
}
