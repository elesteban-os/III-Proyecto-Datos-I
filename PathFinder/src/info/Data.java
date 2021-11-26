package info;

/**
 * Clase con los datos de los cantones.
 */
public class Data {
    private String[] populations = {"342.188", "89.154", "67.392", "235.863", "33.004", "16.280", 
                                  "61.338", "113.557", "60.453", "68.725", "21.335", "82.216", 
                                  "61.661", "143.117", "77.028"};

    private String[] spots = {"Volcán Arenal, Museo Nacional, Museo del Jade, Museo del Banco Central de Costa Rica.", 
                              "Cerro San Miguel, Alto del Palo de Campana, La Piedra del Minero.",
                              "Alto de la Granadilla, Parque La Rosa Linda.",
                              "Parque Centenario, Parque para el Adulto Mayor, Polideportivo El Porvenir, Museo de la Carreta.",
                              "Parque de Puriscal, Iglesia de Jilgueral.", 
                              "Cerro La Trinidad, Finca Araliza, La Concepción Tarrazu.",
                              "Parque de Aserrí, Altos Del Bosque, Parque Acuático Los Sueños.",
                              "Reserva Los Coyotes, Quinta La Yoyita, Parque Ecológico Don Edgar Calle Gutiérrez.",
                              "Furati Wellness, 9Round Santa Ana.",
                              "Parroquia de San Isidro Labrador, Coronado a caballo, Underfire paintball.",
                              "Parroquia San Ignacio de Loyola, Río Grande de Candelaria, Río Pirris, Fila Bustamente.",
                              "Parroquia San Juan Bautista, Estadio Ricardo Saprissa, Iglesia Sagrado Corazón de Jesús.",
                              "Cruz de Sabanilla, Mall San Pedro, Rotonda de la Hispanidad, Parque del Este.",
                              "Parque Central, Aeropuerto de Pérez Zeledón, Bosque La Bambú, Estadio Municipal.",
                              "Multiplaza Curridabat, Indoor Club, Parque Súper Perro."
                            };

    private String[] restaurants= {"Restaurante Grano de Oro, Ibérik Restaurant, Furca, Café Rojo.",
                                  "Restaurante La Cueva.",
                                  "Rincón De Las Delicias, La Casona de Laly, La Posada de las Brujas, Picola Pizza Pub.",
                                  "Cheesus, Pizza Hut, Mr. Monchis, Soda Yoguis.",
                                  "Soda Bar y Restaurant Santa Marta, Bar Restaurant El Rinconcito del Sabor.",
                                  "Lagos Los Ángeles, Vista del Lago Coffee Tour, Bar y Restaurante Menfis.",
                                  "Chicharronera Cacique Acserí, Wil’s, La Bodeguita Artesanal Aserrí.",
                                  "Restaurante La Chola Tila, Seiku, Pops, Agnus Restaurante y Salón.",
                                  "Bacchus Restaurante, Edu’s Sandwiches",  
                                  "Eloticos Benditos, Pizza Hut, KFC, McDonald 's.",
                                  "Restaurante Los Pozos, El 7 de cada mes Cafetería.",
                                  "Soda Pilar, Sodita San Juán, Checa Comidas, Soda Cucharra Oriental.",
                                  "Kopi Café, Xcape Bar & Lounge, La Gata Gastronómica.",
                                  "McDonald 's, Kingyo Sushi & Fusión.",
                                  "Burger King, Kbaña Classic."
                                };

    private String[] gasStations = {"Uno, Bomba Costa Rica, Tournon, Bomba La Pista.",
                                    "Bomba Alajuelita.",
                                    "Delta San Rafael de Escazú.",
                                    "Gasolinera Anatot.",
                                    "Delta Puriscal.",
                                    "BASADIA, Bomba Gasolinera San Marcos.",
                                    "Gasolinera Trova, Gasotica Aserrí.",
                                    "Delta, Servicentro El Carmen, Servicentro El Carmen.",
                                    "Gasolinera Santa Ana.",
                                    "Gasolinera Coronado.",
                                    "Estación de Servicio Coopecaraigres.",
                                    "Servicentro J.S.M, Estación de Servicio San Juan, Uno, Delta.",
                                    "Servicentro San Rafael.",
                                    "Gasotica",
                                    "La Galera, ServiIndoor, Gasolinera y Gas LP El Ranchito.",
                                   };

                        //     1  2  3  4  5  6  7  8  9 10 11 12 13 14 15  
    private int[][] matrix = {{0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0}, // 1
                              {0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1}, // 2
                              {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, // 3
                              {0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, // 4
                              {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0}, // 5
                              {0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0}, // 6 
                              {0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0}, // 7
                              {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0}, // 8
                              {1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, // 9
                              {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0}, // 10
                              {0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0}, // 11
                              {0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0}, // 12
                              {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0}, // 13
                              {0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0}, // 14
                              {0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}}; // 15

    /**
     * Getter for the array containing the populations of different cities
     * @return array of strings with populations 
     */
    public String[] getPopulations() {
        return populations;
    }

    /**
     * Getter for the adjacency matrix for the desired graph
     * @return adjacency matrix 
     */
    public int[][] getMatrix() {
        return matrix;
    }

     /**
     * Getter for the array containing the gas stations of different cities
     * @return array of strings with gas stations 
     */
    public String[] getGasStations() {
        return gasStations;
    }

     /**
     * Getter for the array containing the restaurants of different cities
     * @return array of strings with restaurants 
     */
    public String[] getRestaurants() {
        return restaurants;
    }

     /**
     * Getter for the array containing the places of interest of different cities
     * @return array of strings with places of interest 
     */
    public String[] getSpots() {
        return spots;
    }

    
}
