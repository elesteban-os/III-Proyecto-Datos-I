package graph;

import java.util.ArrayList;
import java.util.LinkedList;

public class Node {
    private City city;
    private int x;
    private int y;
    private ArrayList<Edge> edges = new ArrayList<Edge>();
    private LinkedList<Node> path = new LinkedList<Node>();
    private double time = Double.POSITIVE_INFINITY;

    /**
     * Constructor that creates a vertex with a city
     * @param city city in this vertex
     * @param x int for the horizontal position of the node for the interface
     * @param y int for the vertical position of the node for the interface
     */
    public Node(City city, int x, int y) {
        this.city = city;
        this.x = x;
        this.y = y;
    }

    /**
     * Getter for the city in this vertex
     * @return City of this node
     */
    public City getCity() {
        return this.city;
    }

    /**
     * Getter for the horizontal position of the node for the interface
     * @return int for horizontal position
     */
    public int getX() {
        return this.x;
    }

    /**
     * Getter for the vertical position of the node for the interface
     * @return int for vertical position
     */
    public int getY() {
        return this.y;
    }

    /**
     * Method to add an edge from this vertex to another
     * @param node vertex to point to 
     */
    public void addEdgeTo(Node node) {
        this.edges.add(new Edge(this, node));
        this.sortEdges();
    }

    /**
     * Method to place a new edge for the node in the correct position so its list is sorted by closeness
     */
    private void sortEdges() {
        for (int i = 1; i < this.edges.size(); i++) {
            if (this.edges.get(i).getWeight() < this.edges.get(i-1).getWeight()) {
                Edge temp = this.edges.get(i);
                this.edges.set(i - 1, this.edges.get(i));
                this.edges.set(i, temp);
            }
        }
    }

    /**
     * Getter for the list of edges of thiss vertex
     * @return name of this city
     */
    public ArrayList<Edge> getEdges() {
        return this.edges;
    }

    /**
     * Method to get the weight of an edge to a given vertex
     * @param node vertex to get the weight of 
     */
    public double getEdgeWeightTo(Node node) {
        double weight = Double.POSITIVE_INFINITY;
        for (Edge edge : this.edges) {
            if (edge.getDestination() == node) {
                weight = edge.getWeight();
            }
        }
        return weight;
    }

    /**
     * Method to get a list of vertexes adjacent to this one
     * @return ArrayList of nodes
     */
    public ArrayList<Node> getAdjacents() {
        ArrayList<Node> nodes = new ArrayList<Node>();
        for (Edge edge : edges) {
            nodes.add(edge.getDestination());
        }
        return nodes;
    }

    /**
     * Setter for the shorest path to this vertex
     * @param path LinkedList with the shorest path to this node from a given source calculed with the Dijkstra algorithm
     */
    public void setPath(LinkedList<Node> path) {
        this.path = path;
    }

    /**
     * Getter for the shorest path to this vertex
     * @return LinkedList with the nodes in the shorest path to this node
     */
    public LinkedList<Node> getPath() {
        return this.path;
    }

    /**
     * Setter for the time to get to this node
     * @param time double with the time to set
     */
    public void setTime(double time) {
        this.time = time;
    }

    /**
     * Getter for the time to get to to this node
     * @return double for the time
     */
    public double getTime() {
        return this.time;
    }
}
