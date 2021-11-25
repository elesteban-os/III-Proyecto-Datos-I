package graph;

import GoogleAPI.Distance;

public class Edge {
    private Node origin;
    private Node destination;
    private double time;

    /**
     * Constructor to create an edge pointing from one vertex to another
     * @param origin node where the edge starts
     * @param destination node where the edge points
     * @throws Exception
     */
    public Edge(Node origin, Node destination) {
        this.origin = origin;
        this.destination = destination;
        Distance api = new Distance();
        api.setCities(origin.getCity().getName(), destination.getCity().getName());
        String kms;
        try {
            kms = api.getDistance(Distance.getDistanceData(), "text");
        } catch (Exception e) {
            kms = "0.0";
            e.printStackTrace();
        }
        double distance = Double.parseDouble(kms);
        this.time = distance/80;
    }

    /**
     * Getter for the staring vertex of the edge
     * @returns starting node of the edge
     */
    public Node getOrigin() {
        return this.origin;
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
     * @returns time of the edge
     */
    public double getWeight() {
        return this.time;
    }
}
