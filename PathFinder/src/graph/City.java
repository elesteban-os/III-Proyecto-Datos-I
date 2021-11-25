package graph;

import java.util.ArrayList;

public class City {
    private String name;
    private int population;
    private ArrayList<String> placesOfInterest;
    private ArrayList<String> restaurants;
    private ArrayList<String> gasStations;
    private int place;
    
    /**
     * Constructor that creates a vertex with a city
     * @param city city in this vertex
     * @param placesOfInterest list of places of interests in this city
     * @param restaurants list of restaurants in this city
     * @param gasStations list of gas stations in this city
     */
    public City(String name, int population, ArrayList<String> placesOfInterest, ArrayList<String> restaurants, ArrayList<String> gasStations) {
        this.name = name;
        this.population = population;
        this.placesOfInterest = placesOfInterest;
        this.restaurants = restaurants;
        this.gasStations = gasStations;
        this.setPlace();
    }
    /**
     * Getter for the name of the city in this vertex
     * @return name of this city
     */
    public String getName() {
        return this.name;
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
     * Method to assing a number depending on the letters in the city name of the node 
     */
    public void setPlace() {
        String lowered = this.name.toLowerCase();
        char[] chars = lowered.toCharArray();
        int e = 0;
        for (char c : chars) {
            int add;
            switch (c) {
                case 'a', 'á' -> add = 1;
                case 'b' -> add = 2;
                case 'c' -> add = 3;
                case 'd' -> add = 4;
                case 'e', 'é' -> add = 5;
                case 'f' -> add = 6;
                case 'g' -> add = 7;
                case 'h' -> add = 8;
                case 'i', 'í' -> add = 9;
                case 'j' -> add = 10;
                case 'k' -> add = 11;
                case 'l' -> add = 12;
                case 'm' -> add = 13;
                case 'n' -> add = 14;
                case 'o', 'ó' -> add = 15;
                case 'p' -> add = 16;
                case 'q' -> add = 17;
                case 'r' -> add = 18;
                case 's' -> add = 19;
                case 't' -> add = 20;
                case 'u', 'ú' -> add = 21;
                case 'v' -> add = 22;
                case 'w' -> add = 23;
                case 'x' -> add = 24;
                case 'y' -> add = 25;
                case 'z' -> add = 26;
                default -> add = 0;
            }
            this.place += add * Math.pow(10,e);
            if (add != 0) {
                e++;
            }
        }
    }

    /**
     * Getter for the place to position the node containing this city
     * @return integer with the priority
     */
    public int getPlace() {
        return this.place;
    }
}
