package graph;

/**
 * Class for sorting the cities alphabetically
 */
public class QuickSort {
    private City[] cities;

    /**
     * Method to sort alphabetically an array of cities
     * @param cities array of cities to sort
     * @returns sorted array of the names of the cities
     */
    public String[] sort(City[] cities) {
        this.cities = cities;
        this.quickSort(0, cities.length - 1);
        String[] names = new String[15];
        for (int i = 0; i < cities.length; i++) {
            names[i] = this.cities[i].getName();
        }
        return names;
    }

    /**
     * Recursive method to do the sort
     * @param low lower limit index 
     * @param high higher limit index
     */
    private void quickSort(int low, int high) {
        int i = low, j = high;
        double pivot = this.cities[i].getPlace();
        while (i <= j) {
            while (this.cities[i].getPlace() < pivot) {
                i++;
            }
            while (this.cities[j].getPlace() > pivot) {
                j--;
            }
            if (i <= j) {
                City temp = this.cities[i];
                this.cities[i] = this.cities[j];
                this.cities[j] = temp;
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
