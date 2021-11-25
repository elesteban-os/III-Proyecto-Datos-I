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

                            
    private JComboBox<String> city1 = new JComboBox<>(places);
    private JComboBox<String> city2 = new JComboBox<>(places);

    private JButton calculate = new JButton("Calcular");


    public void drawNodes(Graphics g, Color color){
        int len = this.xPlaces.length;
        for (int i = 0; i < len; i++){
            this.drawing.drawCircles(g, this.xPlaces[i], this.yPlaces[i], color); 
        }
    }    

    //dhjsjdhgagshjk
    ActionListener colors = new ActionListener(){
        public void actionPerformed(ActionEvent event){
            drawing.drawCircles(paper.getGraphics(), 100, 100, Color.BLUE);
        }
    };

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
