package graph;

import java.util.ArrayList;

public class Graph {
    private ArrayList<Node> nodes = new ArrayList<Node>();

    /**
     * Constructor to create a graph
     * @param cities array of cities for the nodes
     * @param xs array of horizontal positions for the nodes
     * @param ys array of vertical positions for the nodes
     * @param adjacents adjacency matrix for the graph
     */
    public Graph(City[] cities, int[] xs, int[] ys, int[][] adjacents) {
        for (int i = 0; i < cities.length; i++) {
            nodes.add(new Node(cities[i], xs[i], ys[i]));
        }
        this.createEdges(adjacents);
        this.sortNodes();
    }

    /**
     * Method to create the edges for the nodes given an adjancency matrix
     * @param adjancets adjacency matrix for the graph
     */
    public void createEdges(int[][] adjacents) {
        for (int i = 0; i < adjacents.length; i++) {
            for (int j = 0; j < adjacents[i].length; j++) {
                if (adjacents[i][j] == 1) {
                    nodes.get(i).addEdgeTo(nodes.get(j));
                }
            }
        }
    }

    /**
     * Method to sort the nodes list alphabeticaly
     */
    public void sortNodes() {
        QuickSort sorter = new QuickSort();
        this.nodes = sorter.sort(this.nodes);
    }

    /**
     * Method to get the node of a given city
     * @param name String with the name of the city
     * @returns Node for the city
     */
    public Node getNode(String name) {
        Node result = null;
        for (Node node : this.nodes) {
            if (node.getCity().getName().equals(name)) {
                result = node;
            }
        }
        return result;
    }
}