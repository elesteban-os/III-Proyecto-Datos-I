package UI;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;

public class Draw extends JPanel {

    public void drawCircles(Graphics g, int x, int y, Color color){
        g.setColor(color);
        g.fillOval(x, y, 10, 10);   
         
    }

    //public void drawLines(Graphics g, int x, int y,)
}
