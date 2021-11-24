public class Edge {
    private Node start;
    private Node end;
    private double distance;

    /**
     * Constructor to create an edge pointing from one vertex to another
     * @param start node where the edge starts
     * @param end node where the edge points
     */
    public Edge(Node start, Node end) {
        this.start = start;
        this.end = end;
        this.distance = 100;
    }

    /**
     * Getter for the staring vertex of the edge
     * @returns starting node of the edge
     */
    public Node getStart() {
        return this.start;
    }

    /**
     * Getter for the vertex the edge points to
     * @returns node the edge points
     */
    public Node getEnd() {
        return this.end;
    }

    /**
     * Getter for the weight of the edge
     * @returns distance of the edge
     */
    public double getDistance() {
        return this.distance;
    }
}
