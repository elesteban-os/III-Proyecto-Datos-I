package graph;

import java.util.ArrayList;

public class QuickSort {
    private ArrayList<Node> nodes = new ArrayList<Node>();

    /**
     * Method to sort alphabetically an ArrayList of nodes
     * @param nodes ArrayList of nodes to sort
     * @returns sorted ArrayList
     */
    public ArrayList<Node> sort(ArrayList<Node> nodes) {
        this.nodes = nodes;
        this.quickSort(0, nodes.size() - 1);
        return this.nodes;
    }

    /**
     * Recursive method to do the sort
     * @param low lower limit index 
     * @param high higher limit index
     */
    private void quickSort(int low, int high) {
        int i = low, j = high;
        int pivot = this.nodes.get(i).getCity().getPlace();
        while (i <= j) {
            while (this.nodes.get(i).getCity().getPlace() > pivot) {
                i++;
            }
            while (this.nodes.get(j).getCity().getPlace() < pivot) {
                j--;
            }
            if (i <= j) {
                Node temp = this.nodes.get(i);
                this.nodes.set(i, this.nodes.get(j));
                this.nodes.set(j, temp);
                i++;
                j--;
            }
        }
        if (low < j) {
            this.quickSort(low, j);
        }
        if (i < high) {
            this.quickSort(i, high);
        }
    }
}
