package UI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class UserInterface extends JFrame{
    
    private JFrame window = new JFrame("Path Finder");
    private JLabel map = new JLabel();
    private JLabel title = new JLabel();
    private JLabel origen = new JLabel();
    private JLabel destino = new JLabel();
    private Draw drawing = new Draw();
    ImageIcon mapIcon = new ImageIcon(getClass().getResource("/Images/map.png"));
    private JPanel paper = new JPanel(){
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.drawImage(mapIcon.getImage(), 0, 0, 600, 600, null);
            drawNodes(g, Color.BLACK);
        }
    };
    
    private String[] places = {"San José", "Alajuelita", "Escazú", "Desamparados", "Puriscal", "Tarrazú", "Aserrí", "Goicoechea", 
    "Santa Ana", "Colorado", "Acosta", "Tibás", "Montes de Oca", "Pérez Zeledón", "Curridabat"};
    //                       1    2    3    4    5    6    7    8    9    10   11   12   13   14   15
    private int[] xPlaces = {205, 246, 230, 284,  98, 286, 245, 320, 204, 340, 185, 262, 286, 440, 290};
    private int[] yPlaces = {149, 175, 159, 187, 251, 327, 247, 127, 150,  91, 247, 126, 142, 439, 152};
    
    private String[] habitants = {"342.188", "89.154", "67.392", "235.863", "33.004", "16.280", 
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
                            
    private JComboBox<String> city1 = new JComboBox<>(places);
    private JComboBox<String> city2 = new JComboBox<>(places);

    private JButton calculate = new JButton("Calcular");


    public void drawNodes(Graphics g, Color color){
        int len = this.xPlaces.length;
        for (int i = 0; i < len; i++){
            this.drawing.drawCircles(g, this.xPlaces[i], this.yPlaces[i], color); 
        }
    }    

    public UserInterface() {
        // ComboBox
        this.city1.setBounds(10, 120, 150, 30);
        this.city2.setBounds(10, 210, 150, 30);

        // Botones
        this.calculate.setBounds(10, 250, 150, 30);
        //this.calculate.addActionListener(colors);

        // Labels
        this.title.setText("PATH FINDER");
        this.title.setBounds(10, 10, 300, 40);
        this.title.setFont(new Font("Bahnschrift", Font.PLAIN, 40));

        this.origen.setText("Origen");
        this.origen.setBounds(10, 90, 100, 40);
        this.origen.setFont(new Font("Bahnschrift", Font.PLAIN, 20));

        this.destino.setText("Destino");
        this.destino.setBounds(10, 180, 100, 40);
        this.destino.setFont(new Font("Bahnschrift", Font.PLAIN, 20));

        // Paper
        this.paper.setBounds(250, 0, 1000, 720);

        // Add          
        this.window.add(this.paper);
        this.window.add(this.city1);
        this.window.add(this.city2);
        this.window.add(this.map);
        this.window.add(this.title);
        this.window.add(this.origen);
        this.window.add(this.destino);
        this.window.add(this.calculate);

       // Window
        this.window.setDefaultCloseOperation(window.EXIT_ON_CLOSE);
        this.window.setLayout(null);
        this.window.setSize(1000, 720);
        this.window.setResizable(false);
        this.window.setVisible(true);
    }

    public static void main(String[] args){
        UserInterface user = new UserInterface();
        System.out.println(user.map.getGraphics());
    }
}
