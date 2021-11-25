package UI;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;

/**
 * 
 */
public class Draw extends JPanel {

    /**
     * Función que dibuja un circulo.
     * @param g detalles gráficos.
     * @param x coordenada x.
     * @param y coordenada y.
     * @param color color del círculo.
     */
    public void drawCircles(Graphics g, int x, int y, Color color){
        g.setColor(color);
        g.fillOval(x, y, 10, 10);   
         
    }

    /**
     * Función que dibuja una línea entre dos puntos.
     * @param g detalles gráficos.
     * @param x1 coordenada x1.
     * @param y1 coordenada y1.
     * @param x2 coordenada x2.
     * @param y2 coordenada y2.
     * @param color color de la línea.
     */
    public void drawLines(Graphics g, int x1, int y1, int x2, int y2, Color color){
        g.setColor(color);
        g.drawLine(x1, y1, x2, y2);
    }
}
