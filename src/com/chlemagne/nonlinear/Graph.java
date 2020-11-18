/*                  (DENSE/WORSE-CASE) GRAPHS
    +-----------------+-----------+-----------+-----------------+
    | m               | Matrix    | List      | Non-dense List  |
    +=================+===========+===========+=================+
    | Space           | o(v^2)    | o(v^2)    | o(v + e)        |
    | Add Edge        | o(1)      | o(v)      | o(k)            |
    | Remove Edge     | o(1)      | o(v)      | o(k)            |
    | Query Edges     | o(1)      | o(v)      | o(k)            |
    | Find Neighbors  | o(v)      | o(v)      | o(k)            |
    | Add Node        | o(v^2)    | o(1)      | o(k)            |
    | Remove Node     | o(v^2)    | o(v^2)    | o(1)            |
    +-----------------+-----------+-----------+-----------------+

    Where:
        v = vertex/node
        k = linked-list node
        e = edge
 */
package com.chlemagne.nonlinear;

import java.util.*;

public class Graph {
    private class Node {
        private String label;

        public Node(String label) {
            this.label = label;
        }

        @Override
        public String toString() {
            return label;
        }
    }

    private Map<String, Node> nodes;
    private Map<Node, LinkedList<Node>> edges; // adjacency list

    public Graph() {
        nodes = new HashMap<>();
        edges = new HashMap<>();
    }

    public void addNode(String label) {
        Node node = new Node(label);
        nodes.putIfAbsent(label, node);
        edges.putIfAbsent(node, new LinkedList<>());
    }

    public void addEdge(String from, String to) {
        if (!nodeExists(from) || !nodeExists(to))
            throw new IllegalArgumentException();

        Node fromNode = nodes.get(from);
        Node toNode = nodes.get(to);
        edges.get(fromNode).add(toNode);
    }

    public void removeNode(String label) {
        if (!nodeExists(label))
            throw new IllegalArgumentException();

        Node node = nodes.get(label);

        for (Node n : edges.keySet())
            edges.get(n).remove(node);

        edges.remove(node);
        nodes.remove(label);
    }

    public void removeEdge(String from, String to) {
        if (!nodeExists(from) || !nodeExists(to))
            return;

        Node fromNode = nodes.get(from);
        Node toNode = nodes.get(to);
        edges.get(fromNode).remove(toNode);
    }

    public void print() {
        System.out.println("#############################");
        for (Node node : nodes.values().toArray(new Node[0]))
            System.out.printf("%s \tis connected with %s%n", node.label, edges.get(node));

        System.out.println("\n");
    }

    public void traverseBreadthFirst(String start) {
        Node node = nodes.get(start);
        if (node == null)
            return;

        Set<Node> out = new LinkedHashSet<>();
        Queue<Node> queue = new ArrayDeque<>();

        queue.add(node);
        traverseBreadthFirst(out, queue);
    }

    private void traverseBreadthFirst(Set out, Queue queue) {
        // base condition
        if (queue.isEmpty())
            return;

        // current node is visited and added to output
        Node current = (Node) queue.remove();
        boolean isUnique = out.add(current);
        if (isUnique)
            System.out.println(current.label);

        // add nodes to queue
        for (Node next : edges.get(current))
            if (!out.contains(next))
                queue.add(next);

        // recursion
        traverseBreadthFirst(out, queue);
    }

    private boolean nodeExists(String label) {
        return nodes.containsKey(label);
    }
}
