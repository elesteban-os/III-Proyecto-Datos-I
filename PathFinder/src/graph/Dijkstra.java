package graph;

import java.util.ArrayList;
import java.util.LinkedList;

public class Dijkstra {
    /**
     * 
     * @param source
     */
    public void getClosestPath(Node source) {
        source.setDistance(0.0);
        ArrayList<Node> settledNodes = new ArrayList<>();
        ArrayList<Node> unsettledNodes = new ArrayList<>();
        unsettledNodes.add(source);
        Node previous = source;
        while (unsettledNodes.size() != 0) {
            Node currentNode = getClosestNode(previous, unsettledNodes);
            unsettledNodes.remove(currentNode);
            for (Node adjacentNode : currentNode.getAdjacents()) {
                double edgeWeight = currentNode.getEdgeWeightTo(adjacentNode);
                if (!settledNodes.contains(adjacentNode)) {
                    getMinimumDistance(adjacentNode, edgeWeight, currentNode);
                    unsettledNodes.add(adjacentNode);
                }
            }
            settledNodes.add(currentNode);
            previous = currentNode;
        }
    }

    /**
     * 
     * @param currentNode
     * @param unsettledNodes
     * @return
     */
    private static Node getClosestNode(Node currentNode, ArrayList<Node> unsettledNodes) {
        Node closestNode = null;
        double lowestDistance = Double.POSITIVE_INFINITY;
        for (Node node: unsettledNodes) {
            double nodeDistance = currentNode.getEdgeWeightTo(node);
            if (nodeDistance < lowestDistance) {
                lowestDistance = nodeDistance;
                closestNode = node;
            }
        }
        return closestNode;
    }

    private static void getMinimumDistance(Node evaluationNode, double edgeWeigh, Node sourceNode) {
    double sourceDistance = sourceNode.getDistance();
    if (sourceDistance + edgeWeigh < evaluationNode.getDistance()) {
        evaluationNode.setDistance(sourceDistance + edgeWeigh);
        LinkedList<Node> shortestPath = new LinkedList<>(sourceNode.getShortestPath());
        shortestPath.add(sourceNode);
        evaluationNode.setShortestPath(shortestPath);
    }
    }
}
