package graph;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Class with an implementation of the Dijkstra algorithm
 */
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
        settledNodes.add(source);
        ArrayList<Node> unsettledNodes = source.getAdjacents();
        for (Node unsettled : unsettledNodes) {
            unsettled.setTime(source.getEdgeWeightTo(unsettled));
            LinkedList<Node> startPath = new LinkedList<Node>(source.getPath());
            startPath.add(source);
            unsettled.setPath(startPath);
        }
        Node previousNode = source;
        while (!unsettledNodes.isEmpty()) {
            Node currentNode = getClosestNode(previousNode, unsettledNodes);
            unsettledNodes.remove(currentNode);
            for (Node adjacentNode : currentNode.getAdjacents()) {
                if (!settledNodes.contains(adjacentNode)) {
                    getMinimumDistance(adjacentNode, currentNode);
                    unsettledNodes.add(adjacentNode);
                }
            }
            settledNodes.add(currentNode);
            previousNode = currentNode;
        }
        LinkedList<Node> path = destination.getPath();
        path.add(destination);
        return path;
    }

    /**
     * Method to get the closest node to a given one
     * @param currentNode node to get its closest adjacent node
     * @param unsettledNodes list of nodes
     * @return node closest to the current node
     */
    private static Node getClosestNode(Node currentNode, ArrayList<Node> unsettledNodes) {
        Node closestNode = unsettledNodes.get(0);
        double lowestDistance = Double.POSITIVE_INFINITY;
        for (Node node : unsettledNodes) {
            double nodeDistance = currentNode.getEdgeWeightTo(node);
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
    private static void getMinimumDistance(Node node, Node sourceNode) {
        double sourceTime = sourceNode.getTime() + sourceNode.getEdgeWeightTo(node);
        if (sourceTime < node.getTime()) {
            node.setTime(sourceTime);
            LinkedList<Node> shortestPath = new LinkedList<Node>(sourceNode.getPath());
            shortestPath.add(sourceNode);
            node.setPath(shortestPath);
        }
    }
}
