package asukaanimation;

import java.awt.Color;
import java.awt.Graphics;
//import java.awt.Graphics2D;
import java.awt.Panel;
//import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 *
 * @author Saul
 */
public class Rectangulo{
    
//    private BufferedImage buffer;
//    private Graphics graPixel;
//    public Panel panel;

    /*public Rectangulo() {
//        buffer = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
//        graPixel = (Graphics2D) buffer.createGraphics();
//        setBackground(new Color(34,87,122));
        setSize(500, 500);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);       
    }
    
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        // Squares
        drawRect(g, 15, 55, 65, 135);
        drawRect(g, 100, 55, 200, 135);
        drawRect(g, 150, 225, 300, 275);
        drawRect(g, 200, 400, 100, 300);
    }*/

    private void drawRect(Graphics g, int x0, int y0, int x1, int y1)
    {
        Linea obj = new Linea();
        // Linea Horizontal Sup
        obj.drawLine(g,x0, y0, x1, y0); 
        // Linea Horizontal Inferior
        obj.drawLine(g,x0, y1, x1, y1); 
        // Linea Horizontal Derecha
        obj.drawLine(g,x1, y0, x1, y1); 
        // Linea Vertical Izquierda
        obj.drawLine(g,x0, y0, x0, y1);  
    }

    /*public static void main(String[] args)
    {
        Rectangulo obj = new Rectangulo();
    }*/
}
