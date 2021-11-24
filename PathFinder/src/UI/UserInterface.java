package UI;

import java.awt.Font;
import java.awt.*;
import java.awt.geom.Ellipse2D;

import javax.swing.*;

public class UserInterface extends JFrame{
    private JFrame window = new JFrame("Path Finder");
    private JLabel map = new JLabel();
    private JLabel title = new JLabel();
    private JLabel origen = new JLabel();
    private JLabel destino = new JLabel();
    
    private String[] places = {"San José", "Alajuelita", "Escazú", "Desamparados", "Puriscal", "Tarrazú", "Aserrí", "Goicoechea", 
                               "Santa Ana", "Colorado", "Acosta", "Tibás", "Montes de Oca", "Pérez Zeledón", "Curridabat"};
                            
    private JComboBox<String> city1 = new JComboBox<>(places);
    private JComboBox<String> city2 = new JComboBox<>(places);

    private JButton calculate = new JButton("Calcular");

    ImageIcon mapIcon = new ImageIcon(getClass().getResource("/Images/map.png"));

    private JPanel nodes = new JPanel(){
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;
            Ellipse2D ellipse = new Ellipse2D.Double(100, 100, 100, 100);
            g2.draw(ellipse);
        }
    };
    

    public UserInterface() {
        // Mapa
        this.map.setIcon(this.mapIcon);
        this.map.setBounds(150, 0, 733, 711);


        // ComboBox
        this.city1.setBounds(10, 120, 150, 30);
        this.city2.setBounds(10, 210, 150, 30);

        // Botones
        this.calculate.setBounds(10, 250, 150, 30);

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

        // Add
        this.window.add(this.city1);
        this.window.add(this.city2);
        this.window.add(this.map);
        this.window.add(this.title);
        this.window.add(this.origen);
        this.window.add(this.destino);
        this.window.add(this.calculate);
        this.window.add(this.nodes);

       // Window
        this.window.setDefaultCloseOperation(window.EXIT_ON_CLOSE);
        this.window.setSize(1000, 720);
        this.window.setResizable(false);
        this.window.setVisible(true);
    }

    

    public static void main(String[] args){
        UserInterface user = new UserInterface();

        
    }
}
