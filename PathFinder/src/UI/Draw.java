package UI;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Color;
import java.awt.BasicStroke;

/**
 * Clase para dibujar lineas o circulos, requerida par los vertices y aristas
 */
public class Draw extends JPanel {

    /**
     * Función que dibuja un circulo.
     * @param g detalles gráficos.
     * @param x coordenada x.
     * @param y coordenada y.
     * @param color color del círculo.
     */
    public void drawCircles(Graphics g, int x, int y, Color color, String name){
        Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(color);
        g2.fillOval(x, y, 10, 10); 
        g2.drawString(name, x, y); 
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
        Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        BasicStroke stroke = new BasicStroke(2);
        g2.setColor(color);
        g2.setStroke(stroke);
        g2.drawLine(x1, y1, x2, y2);
    }
}
