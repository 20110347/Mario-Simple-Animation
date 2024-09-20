/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package asukaanimation;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 *
 * @author Saul
 */
public class drawCircleThickness {

    Color c = new Color(138, 201, 38);
    BufferedImage buffer;

    public void putPixel(Graphics g, int x, int y, Color c) {
        buffer.setRGB(0, 0, c.getRGB());
        g.drawImage(buffer, x, y, null);
    }

    public void drawSemiCircleSup(Graphics g, int xc, int yc, int radius, int thickness, Color c) {
        int inner = radius;
        int outer = radius + thickness;

        int xo = outer;
        int xi = inner;
        int y = 0;
        int erro = 1 - xo;
        int erri = 1 - xi;

        while (xo >= y) {
            xLine(g, xc - xo, xc - xi, yc - y, c);
            yLine(g, xc - y, yc - xo, yc - xi, c);
            xLine(g, xc + xi, xc + xo, yc - y, c);
            yLine(g, xc + y, yc - xo, yc - xi, c);
            y++;

            if (erro < 0) {
                erro += 2 * y + 1;
            } else {
                xo--;
                erro += 2 * (y - xo + 1);
            }

            if (y > inner) {
                xi = y;
            } else {
                if (erri < 0) {
                    erri += 2 * y + 1;
                } else {
                    xi--;
                    erri += 2 * (y - xi + 1);
                }
            }
        }
    }
    
    public void drawInfSemiCircle(Graphics g, int xc, int yc, int radius, int thickness, Color c) {
        int inner = radius;
        int outer = radius + thickness;

        int xo = outer;
        int xi = inner;
        int y = 0;
        int erro = 1 - xo;
        int erri = 1 - xi;

        while (xo >= y) {
            xLine(g, xc + xi, xc + xo, yc + y, c);
            yLine(g, xc + y, yc + xi, yc + xo, c);
            xLine(g, xc - xo, xc - xi, yc + y, c);
            yLine(g, xc - y, yc + xi, yc + xo, c);
            y++;

            if (erro < 0) {
                erro += 2 * y + 1;
            } else {
                xo--;
                erro += 2 * (y - xo + 1);
            }

            if (y > inner) {
                xi = y;
            } else {
                if (erri < 0) {
                    erri += 2 * y + 1;
                } else {
                    xi--;
                    erri += 2 * (y - xi + 1);
                }
            }
        }
    }

    public drawCircleThickness() {
        buffer = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
    }

    void xLine(Graphics g, int x1, int x2, int y, Color c) {
        while (x1 <= x2) {
            putPixel(g, x1++, y, c);
        }
    }

    void yLine(Graphics g, int x, int y1, int y2, Color c) {
        while (y1 <= y2) {
            putPixel(g, x, y1++, c);
        }
    }
}
