package graph;

import java.util.ArrayList;
import java.util.LinkedList;

public class Dijkstra {
    /**
     * Method to get the shortest path from one vertex to another one
     * @param source strating node
     * @param destination node to get to
     * @returns LinkedLlist with the shortest path from source to destination
     */
    public LinkedList<Node> getShortestPath(Node source, Node destination, double delay) {
        source.setDistance(0.0);
        ArrayList<Node> settledNodes = new ArrayList<>();
        ArrayList<Node> unsettledNodes = new ArrayList<>();
        unsettledNodes.add(source);
        Node previous = source;
        while (unsettledNodes.size() != 0) {
            Node currentNode = getClosestNode(previous, delay, unsettledNodes);
            unsettledNodes.remove(currentNode);
            for (Node adjacentNode : currentNode.getAdjacents()) {
                if (!settledNodes.contains(adjacentNode)) {
                    getMinimumDistance(adjacentNode, currentNode, delay);
                    unsettledNodes.add(adjacentNode);
                }
            }
            settledNodes.add(currentNode);
            previous = currentNode;
        }
        LinkedList<Node> path = new LinkedList<>();
        for (Node settled : settledNodes) {
            if (settled == destination) {
                path = settled.getPath();
            }
        }
        return path;
    }

    /**
     * Method to get the closest node to a given one
     * @param currentNode node to get its closest adjacent node
     * @param unsettledNodes list of nodes
     * @return node closest to the current node
     */
    private static Node getClosestNode(Node currentNode, double delay, ArrayList<Node> unsettledNodes) {
        Node closestNode = null;
        double lowestDistance = Double.POSITIVE_INFINITY;
        for (Node node: unsettledNodes) {
            double nodeDistance = currentNode.getEdgeWeightTo(node) + delay;
            if (nodeDistance < lowestDistance) {
                lowestDistance = nodeDistance;
                closestNode = node;
            }
        }
        return closestNode;
    }

    /**
     * Method to change the shortest path to a node from another one
     * @param node node to get its closest adjacent node
     * @param sourceNode node where its coming from
     */
    private static void getMinimumDistance(Node node, Node sourceNode, double delay) {
        double weight = sourceNode.getEdgeWeightTo(node) + delay;
        double sourceDistance = sourceNode.getDistance();
        if (sourceDistance + weight < node.getDistance()) {
            node.setDistance(sourceDistance + weight);
            LinkedList<Node> shortestPath = new LinkedList<>(sourceNode.getPath());
            shortestPath.add(sourceNode);
            node.setPath(shortestPath);
    }
    }
}
