package UI;

import java.util.LinkedList;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import info.Data;
import graph.City;
import graph.QuickSort;
import graph.Graph;
import graph.Dijkstra;
import graph.Node;

public class UserInterface extends JFrame{
    
    private JFrame window = new JFrame("Path Finder");
    private JLabel kms = new JLabel(); 
    private JLabel time = new JLabel(); 
    private JLabel map = new JLabel();
    private JLabel title = new JLabel();
    private JLabel origen = new JLabel();
    private JLabel destino = new JLabel();
    private JLabel kmsTitle = new JLabel();
    private JLabel timeTitle = new JLabel();
    private JLabel helpLabel = new JLabel();
    private JButton calculate = new JButton("Calcular");
    private JButton helpButton = new JButton("Consultar");
    private Draw drawing = new Draw();
    private Data data = new Data();
    private QuickSort sorter = new QuickSort();
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
            drawResetLines(g);
        }
    };
    
    private String[] places = {"San José", "Alajuelita", "Escazú", "Desamparados", "Puriscal", "Tarrazú", "Aserrí", "Goicoechea", 
                               "Santa Ana", "Vázquez de Coronado", "Acosta", "Tibás", "Montes de Oca", "Pérez Zeledón", "Curridabat"};
    private String[] sortedPlaces;
    //                       1    2    3    4    5    6    7    8    9    10   11   12   13   14   15
    private int[] xPlaces = {240, 246, 230, 284,  98, 286, 245, 320, 204, 340, 185, 262, 286, 440, 290};
    private int[] yPlaces = {130, 175, 159, 187, 251, 327, 247, 127, 150,  91, 247, 126, 142, 439, 152};
                            
    private JComboBox<String> city1 = new JComboBox<>(places);
    private JComboBox<String> city2 = new JComboBox<>(places);
    private JComboBox<String> help;


    public void drawNodes(Graphics g, Color color){
        int len = this.xPlaces.length;
        for (int i = 0; i < len; i++){
            this.drawing.drawCircles(g, this.xPlaces[i], this.yPlaces[i], color, this.places[i]); 
        }
    }

    public void drawResetLines(Graphics g){
        int[][] matrix = data.getMatrix();
        for (int i = 0; i < 15; i++){
            for (int j = 0; j < 15; j++){
                if (matrix[i][j] == 1){
                    this.drawing.drawLines(g, this.xPlaces[j] + 5, this.yPlaces[j] + 5, this.xPlaces[i] + 5, this.yPlaces[i] + 5, Color.BLACK);
                }
            }
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

    public void calculateDistance() {
        this.drawResetLines(this.paper.getGraphics());
        Node origin = graph.getNode(this.places[this.city1.getSelectedIndex()]);
        Node destiny = graph.getNode(this.places[this.city2.getSelectedIndex()]);
        System.out.println("from: " + origin.getCity().getName() + " to: " + destiny.getCity().getName());
        LinkedList<Node> path = this.calculator.getShortestPath(origin, destiny);
        for (Node node : path) {
            System.out.print(" go to: " + node.getCity().getName());
        }
        System.out.println(" got there");
        Node node = path.remove();
        int lastX = node.getX();
        int lastY = node.getY();
        Integer expectedDelay =  (int) this.delay.getValue();
        double time = expectedDelay.doubleValue() / 60;
        while (path.size() != 0) {
            Node currentNode = path.remove();
            int x = currentNode.getX();
            int y = currentNode.getY();
            time = currentNode.getTime();
            this.drawing.drawLines(this.paper.getGraphics(), lastX, lastY, x, y, Color.BLUE);
            lastX = x;
            lastY = y;
        }
        this.time.setText(time + " h");
        this.kms.setText((time - expectedDelay.doubleValue() / 60) * 80 + " kms");
    }

    private void openJOptionPane() {
        JOptionPane.showMessageDialog(null, this.graph.getNode(this.sortedPlaces[this.help.getSelectedIndex()]).getCity().getInfo());
    }

    public UserInterface() {
        this.setCities();
        this.sortedPlaces = this.sorter.sort(this.cities);
        this.help = new JComboBox<>(sortedPlaces);

        // ComboBox
        this.city1.setBounds(10, 120, 150, 30);
        this.city2.setBounds(10, 210, 150, 30);
        this.help.setBounds(10, 420, 150, 30);

        // Botones
        this.calculate.setBounds(10, 250, 110, 30);
        this.calculate.addActionListener(action -> this.calculateDistance());
        this.calculate.setEnabled(false);

        this.helpButton.setBounds(10, 460, 150, 30);
        this.helpButton.addActionListener(e -> {
            openJOptionPane();
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
        this.kmsTitle.setBounds(10, 280, 100, 40);
        this.kmsTitle.setFont(new Font("Bahnschrift", Font.PLAIN, 20));

        this.kms.setText("0.0 km");
        this.kms.setBounds(10, 300, 100, 40);
        this.kms.setFont(new Font("Bahnschrift", Font.PLAIN, 20));

        this.timeTitle.setText("Tiempo");
        this.timeTitle.setBounds(10, 330, 100, 40);
        this.timeTitle.setFont(new Font("Bahnschrift", Font.PLAIN, 20));

        this.time.setText("0.0 h");
        this.time.setBounds(10, 350, 100, 40);
        this.time.setFont(new Font("Bahnschrift", Font.PLAIN, 20));

        this.helpLabel.setText("Ayuda al viajero");
        this.helpLabel.setBounds(10, 390, 170, 40);
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
        this.window.add(this.timeTitle);
        this.window.add(this.time);
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
