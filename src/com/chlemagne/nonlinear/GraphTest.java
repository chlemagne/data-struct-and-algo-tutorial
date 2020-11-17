package com.chlemagne.nonlinear;

public class GraphTest {
    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addNode("John");
        graph.addNode("Mary");
        graph.addNode("Bob");
        graph.addNode("Alice");
        graph.addNode("Naruto");


        graph.addEdge("Alice", "John");
        graph.addEdge("John", "Alice");
        graph.addEdge("John", "Bob");
        graph.addEdge("John", "Mary");
        graph.removeEdge("John", "Alice");
        graph.addEdge("Naruto", "Bob");
        graph.print();

        graph.removeNode("Naruto");
        graph.print();
    }
}
