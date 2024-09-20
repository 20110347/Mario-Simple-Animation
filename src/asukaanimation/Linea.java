
package asukaanimation;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
/**
 *
 * @author Saul
 */
public class Linea {

    BufferedImage buffer;
    Color c = new Color(87,204,153);

    public Linea() {
        buffer = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
    }

    public void putPixel(Graphics g, int x, int y, Color c) {
        buffer.setRGB(0, 0, c.getRGB());
        g.drawImage(buffer, x, y, null);
    }

    void drawLine(Graphics g, int x0, int y0, int x1, int y1) {
        int dx = (x1 - x0);
        int dy = (y1 - y0);

        int stepx, stepy;

        if (dy < 0) {
            dy = -dy;
            stepy = -1;
        } else {
            stepy = 1;
        }

        if (dx < 0) {
            dx = -dx;
            stepx = -1;
        } else {
            stepx = 1;
        }

        int x = x0;
        int y = y0;

        if (dx > dy) {
            int p = 2 * dy - dx;
            int A = 2 * dy;
            int B = 2 * (dy - dx);

            while (x != x1) {
                x = x + stepx;
                if (p < 0) {
                    p = p + A;
                } else {
                    y = y + stepy;
                    p = p + B;
                }
                putPixel(g, x, y, c);
            }
        } else {
            int p = 2 * dx - dy;
            int A = 2 * dx;
            int B = 2 * (dx - dy);

            while (y != y1) {
                y = y + stepy;
                if (p < 0) {
                    p = p + A;
                } else {
                    x = x + stepx;
                    p = p + B;
                }
                putPixel(g, x, y, c);
            }
        }
    }
}
