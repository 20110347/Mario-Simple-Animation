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
public class drawLineThickness {

    BufferedImage buffer;
    int thickness = 0;
    int defaultThickness = 1;
    Color c1 = new Color(255, 87, 51);
    Color c2 = new Color(118, 68, 138);

    public drawLineThickness() {
        buffer = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
        thickness = defaultThickness;
    }

    public void putPixel(Graphics g, int x, int y, Color c) {
        buffer.setRGB(0, 0, c.getRGB());
        g.drawImage(buffer, x, y, null);
    }

    public void drawLine(Graphics g, int x0, int y0, int x1, int y1, Color c) {
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

        double m = (double) dy / dx;

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
                addThickness(g, m, thickness, x, y, c);
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
                addThickness(g, m, thickness, x, y, c);
            }

        }

    }

    public void drawRect(Graphics g, int x0, int y0, int x1, int y1, Color c) {
        drawLine(g, x0, y0, x1, y0, c);
        drawLine(g, x0, y1, x1, y1, c);
        drawLine(g, x0, y0, x0, y1, c);
        drawLine(g, x1, y0, x1, y1, c);
    }

    public void drawTriangle(Graphics g, int x0, int y0, int x1, int y1, int posx, int posy, Color c) {
        drawLine(g, x0, y0, x1, y1, c);
        drawLine(g, x0, y0, posx, posy, c);
        drawLine(g, x1, y1, posx, posy, c);
    }

    private void addThickness(Graphics g, double m, int thickness, int x, int y, Color c) {
        boolean b = false;
        int t = thickness;
        int left = 1;
        int right = 1;

        while (t-- > 1) {
            if (b) {
                if (Math.abs(m) >= 1) {
                    putPixel(g, x - left, y, c);
                }
                if (Math.abs(m) < 1) {
                    putPixel(g, x, y - left, c);
                }
                left++;
            } else {
                if (Math.abs(m) >= 1) {
                    putPixel(g, x + right, y, c);
                }
                if (Math.abs(m) < 1) {
                    putPixel(g, x, y + right, c);
                }
                right++;
            }
            b = !b;
        }
    }

    public void setThickness(int thickness) {
        this.thickness = thickness;
    }

    public void setThickness() {
        thickness = defaultThickness;
    }
}
