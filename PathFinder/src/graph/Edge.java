package graph;

import maps.Distance;

public class Edge {
    private Node source;
    private Node destination;
    private double distance;

    /**
     * Constructor to create an edge pointing from one vertex to another
     * @param source node where the edge starts
     * @param destination node where the edge points
     */
    public Edge(Node source, Node destination) {
        this.source = source;
        this.destination = destination;
        this.distance = Double.MAX_VALUE;
    }

    /**
     * Getter for the staring vertex of the edge
     * @returns starting node of the edge
     */
    public Node getSource() {
        return this.source;
    }

    /**
     * Getter for the vertex the edge points to
     * @returns node the edge points
     */
    public Node getDestination() {
        return this.destination;
    }

    /**
     * Getter for the weight of the edge
     * @returns distance of the edge
     */
    public double getDistance() {
        return this.distance;
    }
}
