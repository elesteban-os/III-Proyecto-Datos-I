package graph;

import java.util.ArrayList;

public class QuickSort {
    private ArrayList<Node> nodes = new ArrayList<>();

    public void sort(ArrayList<Node> nodes) {
        this.nodes = nodes;
        sorter(0, nodes.size() - 1);
    }

    private void sorter(int low, int high) {
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
            sorter(low, j);
        }
        if (i < high) {
            sorter(i, high);
        }
    }
}
