/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package asukaanimation;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

/**
 *
 * @author Mariza
 */
public class clipCircles {

    private BufferedImage buffer;
    Graphics2D graphics2D;

    public clipCircles(Graphics2D graphics2D) {
        this.graphics2D = graphics2D;
        buffer = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
    }

    public void createClippingArea(int initalX, int initalY, int x1, int y1, Color c, Graphics g, int Max, int xc, int yc) {
        Rectangle medidas = graphics2D.getClipBounds();
        int ancho = medidas.width;
        int altura = medidas.height;

        BufferedImage bufferedImage = new BufferedImage(ancho, altura, BufferedImage.TYPE_INT_ARGB);
        Graphics2D gBuffer = bufferedImage.createGraphics();

        drawPuntoMedio(initalX, initalY, x1, initalY, c, gBuffer);
        drawPuntoMedio(initalX, initalY, initalX, y1, c, gBuffer);
        drawPuntoMedio(initalX, y1, x1, y1, c, gBuffer);
        drawPuntoMedio(x1, initalY, x1, y1, c, gBuffer);

//        drawMiddlePointCircleClipped(initalX, initalY, 40, c, initalX, initalY, x1, y1, gBuffer);
        for (int i = 0; i < Max; i += 10) {
            drawMiddlePointCircleClipped(xc+i, yc, 5, Color.BLACK, initalX, initalY, x1, y1, gBuffer);
        }
        
        g.drawImage(bufferedImage, 0, 0, null);
    }

    public void drawMiddlePointCircleClipped(int xCentro, int yCentro, int radio, Color c, int x1, int y1, int x2, int y2, Graphics g) {
        double x, y;
        for (int t = 0; t <= 360; t++) {
            x = xCentro + radio * Math.sin(t);
            y = yCentro + radio * Math.cos(t);
            if ((x1 < (int) Math.round(x) && x2 > (int) Math.round(x))
                    && (y1 < (int) Math.round(y) && y2 > (int) Math.round(y))) {
                putPixel((int) Math.round(x), (int) Math.round(y), c, g);

            }
        }
    }

    private void drawPuntoMedio(int x0, int y0, int x1, int y1, Color color, Graphics g) {
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

        putPixel(x0, y0, color, g);

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
                putPixel(x, y, color, g);
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
                putPixel(x, y, color, g);
            }
        }
    }

    public void putPixel(int x, int y, Color c, Graphics g) {
        buffer.setRGB(0, 0, c.getRGB());
        g.drawImage(buffer, x, y, null);
    }
}
