package graph;

import java.util.ArrayList;
import java.util.LinkedList;

public class Node {
    private String city;
    private int population;
    private ArrayList<String> placesOfInterest;
    private ArrayList<String> restaurants;
    private ArrayList<String> gasStations;
    private ArrayList<Edge> edges = new ArrayList<>();
    private LinkedList<Node> shortestPath = new LinkedList<>();
    private double distance = Double.POSITIVE_INFINITY;

    /**
     * Constructor that creates a vertex with a city name and information
     * @param city name of the city
     * @param placesOfInterest list of places of interests in this city
     * @param restaurants list of restaurants in this city
     * @param gasStations list of gas stations in this city
     */
    public Node(String city, int population, ArrayList<String> placesOfInterest, ArrayList<String> restaurants, ArrayList<String> gasStations) {
        this.city = city;
        this.placesOfInterest = placesOfInterest;
        this.restaurants = restaurants;
        this.gasStations = gasStations;
    }

    /**
     * Getter for the name of the city in this vertex
     * @return name of this city
     */
    public String getCity() {
        return this.city;
    }

    /**
     * Getter for the population of the city in this vertex
     * @return population of this city
     */
    public int getPopulation() {
        return this.population;
    }

    /**
     * Getter for the places of interest in the city in this vertex
     * @return places of interest in this city
     */
    public ArrayList<String> getPlacesOfInterest() {
        return this.placesOfInterest;
    }

    /**
     * Getter for the restaurants in the city in this vertex
     * @return restaurants in this city
     */
    public ArrayList<String> getRestaurants() {
        return this.restaurants;
    }

    /**
     * Getter for the gas stations in the city in this vertex
     * @return gas stations in this city
     */
    public ArrayList<String> getGasStations() {
        return this.gasStations;
    }

    /**
     * Method to add an edge from this vertex to another
     * @param node vertex to point to 
     */
    public void addEdgeTo(Node node) {
        this.edges.add(new Edge(this, node));
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
     * @param Node vertex to get the weight of 
     */
    public double getEdgeWeightTo(Node node) {
        double weight = 0.0;
        for (Edge edge : this.edges) {
            if (edge.getDestination() == node) {
                weight = edge.getDistance();
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
     * Method to set a shorest path to this vertex calculed with the Dijkstra algorithm
     * @param shortestPath shorestPath to this node from a given source
     */
    public void setShortestPath(LinkedList<Node> shortestPath) {
        this.shortestPath = shortestPath;
    }

    /**
     * Method to set a shorest path to this vertex
     * @return shorestPath to this node
     */
    public LinkedList<Node> getShortestPath() {
        return this.shortestPath;
    }

    /**
     * 
     * @param distance
     */
    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getDistance() {
        return this.distance;
    }
}
