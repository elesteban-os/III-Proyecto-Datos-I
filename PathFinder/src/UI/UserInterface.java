package UI;

import java.util.LinkedList;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import info.Data;
import graph.City;
import graph.Graph;
import graph.Dijkstra;
import graph.Node;

public class UserInterface extends JFrame{
    
    private JFrame window = new JFrame("Path Finder");
    private JLabel kms = new JLabel(); 
    private JLabel map = new JLabel();
    private JLabel title = new JLabel();
    private JLabel origen = new JLabel();
    private JLabel destino = new JLabel();
    private JLabel kmsTitle = new JLabel();
    private JLabel helpLabel = new JLabel();
    private JButton calculate = new JButton("Calcular");
    private JButton helpButton = new JButton("Consultar");
    private Draw drawing = new Draw();
    private Data data = new Data();
    private City[] cities = new City[15];
    private SpinnerNumberModel modelSpinner = new SpinnerNumberModel(0, 0, 60, 1);
    private JSpinner delay = new JSpinner(modelSpinner);
    private Graph graph;
    private Dijkstra calculator = new Dijkstra();
    
    ImageIcon mapIcon = new ImageIcon(getClass().getResource("/Images/map.png"));
    private JPanel paper = new JPanel() {
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.drawImage(mapIcon.getImage(), 0, 0, 600, 600, null);
            drawNodes(g, Color.BLACK);
        }
    };
    
    private String[] places = {"San José", "Alajuelita", "Escazú", "Desamparados", "Puriscal", "Tarrazú", "Aserrí", "Goicoechea", 
                               "Santa Ana", "Vázquez de Coronado", "Acosta", "Tibás", "Montes de Oca", "Pérez Zeledón", "Curridabat"};
    //                       1    2    3    4    5    6    7    8    9    10   11   12   13   14   15
    private int[] xPlaces = {205, 246, 230, 284,  98, 286, 245, 320, 204, 340, 185, 262, 286, 440, 290};
    private int[] yPlaces = {149, 175, 159, 187, 251, 327, 247, 127, 150,  91, 247, 126, 142, 439, 152};
                            
    private JComboBox<String> city1 = new JComboBox<>(places);
    private JComboBox<String> city2 = new JComboBox<>(places);
    private JComboBox<String> help = new JComboBox<>(places);


    public void drawNodes(Graphics g, Color color){
        int len = this.xPlaces.length;
        for (int i = 0; i < len; i++){
            this.drawing.drawCircles(g, this.xPlaces[i], this.yPlaces[i], color); 
        }
    }
    
    public void setCities(){
        String[] habitants = this.data.getHabitants();
        String[] spots = this.data.getSpots();
        String[] restaurants = this.data.getRestaurants();
        String[] gasStations = this.data.getGasStations();
        int len = spots.length;
        for(int i = 0; i < len; i++){
            this.cities[i] = new City(this.places[i], habitants[i], spots[i], restaurants[i], gasStations[i]);
        }
    }

    public void calulateDistance() {
        Node origin = graph.getNode("San José");
        Node destiny = graph.getNode("Curridabat");
        LinkedList<Node> path = this.calculator.getShortestPath(origin, destiny, 0);
        Node node = path.getFirst();
        int lastX = node.getX();
        int lastY = node.getY();
        for (int i = 0; i < path.size() - 1; i++) {
            Node currentNode = path.getFirst();
            int x = currentNode.getX();
            int y = currentNode.getY();
            this.drawing.drawLines(this.paper.getGraphics(), lastX, lastY, x, y, Color.BLUE);
            lastX = x;
            lastY = y;
        }
    }

    public UserInterface() {
        setCities();
        //this.graph = new Graph(this.cities, this.xPlaces, this.yPlaces, this.data.getMatrix());

        // ComboBox
        this.city1.setBounds(10, 120, 150, 30);
        this.city2.setBounds(10, 210, 150, 30);
        this.help.setBounds(10, 400, 150, 30);

        // Botones
        this.calculate.setBounds(10, 250, 110, 30);

        this.helpButton.setBounds(10, 440, 150, 30);
        this.helpButton.addActionListener(e -> {
            Graphics g = paper.getGraphics();
            drawing.drawLines(g, 12, 12, 232, 232, Color.BLACK);
        });

        // Labels
        this.title.setText("PATH FINDER");
        this.title.setBounds(5, 10, 330, 40);
        this.title.setFont(new Font("Bahnschrift", Font.PLAIN, 40));

        this.origen.setText("Origen");
        this.origen.setBounds(10, 90, 100, 40);
        this.origen.setFont(new Font("Bahnschrift", Font.PLAIN, 20));

        this.destino.setText("Destino");
        this.destino.setBounds(10, 180, 100, 40);
        this.destino.setFont(new Font("Bahnschrift", Font.PLAIN, 20));

        this.kmsTitle.setText("Distancia");
        this.kmsTitle.setBounds(10, 300, 100, 40);
        this.kmsTitle.setFont(new Font("Bahnschrift", Font.PLAIN, 20));

        this.kms.setText("0.0 KM");
        this.kms.setBounds(10, 320, 100, 40);
        this.kms.setFont(new Font("Bahnschrift", Font.PLAIN, 20));

        this.helpLabel.setText("Ayuda al viajero");
        this.helpLabel.setBounds(10, 370, 170, 40);
        this.helpLabel.setFont(new Font("Bahnschrift", Font.PLAIN, 20));

        // Paper
        this.paper.setBounds(250, 0, 1000, 720);

        // Spinner
        this.delay.setBounds(120, 250, 40, 30);

        // Add          
        this.window.add(this.paper);
        this.window.add(this.city1);
        this.window.add(this.city2);
        this.window.add(this.help);
        this.window.add(this.delay);
        this.window.add(this.map);
        this.window.add(this.title);
        this.window.add(this.helpLabel);
        this.window.add(this.kmsTitle);
        this.window.add(this.kms);
        this.window.add(this.origen);
        this.window.add(this.destino);
        this.window.add(this.calculate);
        this.window.add(this.helpButton);

        // Window
        this.window.setDefaultCloseOperation(window.EXIT_ON_CLOSE);
        this.window.setLayout(null);
        this.window.setSize(850, 640);
        this.window.setResizable(false);
        this.window.setVisible(true);
    }

    public static void main(String[] args){
        UserInterface user = new UserInterface();
        System.out.println(user.map.getGraphics());
    }
}
