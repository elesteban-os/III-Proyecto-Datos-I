import java.util.ArrayList;

public class Node {
    private String city;
    private int population;
    private ArrayList<String> placesOfInterest;
    private ArrayList<String> restaurants;
    private ArrayList<String> gasStations;
    private ArrayList<Edge> edges = new ArrayList<>();

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
     * 
     */
    public void addEdgeTo(Node node) {
        edges.add(new Edge(this, node));
    }

    /**
     * Getter for the list of edges of thiss vertex
     * @return name of this city
     */
    public ArrayList<Edge> getEdges() {
        return this.edges;
    }
}
