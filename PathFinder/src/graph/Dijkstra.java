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
    public LinkedList<Node> getShortestPath(Node source, Node destination) {
        source.setTime(0.0);
        ArrayList<Node> settledNodes = new ArrayList<Node>();
        ArrayList<Node> unsettledNodes = new ArrayList<Node>();
        unsettledNodes.add(source);
        Node previousNode = source;
        int times = 0;
        while (unsettledNodes.size() != 0) {
            Node currentNode = getClosestNode(previousNode, unsettledNodes, times);
            if (!settledNodes.contains(destination)) {
                unsettledNodes.remove(currentNode);
                for (Node adjacentNode : currentNode.getAdjacents()) {
                    if (!settledNodes.contains(adjacentNode)) {
                        getMinimumDistance(adjacentNode, currentNode);
                        unsettledNodes.add(adjacentNode);
                    }
                }
                settledNodes.add(currentNode);
                previousNode = currentNode;
                times++;
            } else {
                unsettledNodes = new ArrayList<Node>();
            }
        }
        LinkedList<Node> path = new LinkedList<>();
        for (Node settled : settledNodes) {
            if (settled == destination) {
                path = settled.getPath();
                path.add(settled);
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
    private static Node getClosestNode(Node currentNode, ArrayList<Node> unsettledNodes, int n) {
        Node closestNode = unsettledNodes.get(0);
        double lowestDistance = Double.POSITIVE_INFINITY;
        for (Node node : unsettledNodes) {
            double nodeDistance = currentNode.getEdgeWeightTo(node);
            if (nodeDistance < lowestDistance || (currentNode == node && n == 0)) {
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
    private static void getMinimumDistance(Node node, Node sourceNode) {
        double weight = sourceNode.getEdgeWeightTo(node);
        double sourceDistance = sourceNode.getTime();
        if (sourceDistance + weight < node.getTime()) {
            node.setTime(sourceDistance + weight);
            LinkedList<Node> shortestPath = new LinkedList<>(sourceNode.getPath());
            shortestPath.add(sourceNode);
            node.setPath(shortestPath);
        }
    }
}
