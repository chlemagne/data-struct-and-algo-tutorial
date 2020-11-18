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
        //graph.print();

        graph.removeNode("Naruto");
        //graph.print();

        // traversal test
        Graph graph2 = new Graph();
        graph2.addNode("A");
        graph2.addNode("B");
        graph2.addNode("C");
        graph2.addNode("D");

        graph2.addEdge("A", "B");
        graph2.addEdge("A", "C");
        graph2.addEdge("B", "D");
        graph2.addEdge("D", "C");

        graph2.print();
        graph2.traverseBreadthFirst("A");
    }
}
