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
import java.util.Stack;

/**
 *
 * @author Saul
 */
public class fillFlood {

    BufferedImage buffer;

    public fillFlood() {
        buffer = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
    }

    public void putPixel(Graphics g, int x, int y, Color c) {
        buffer.setRGB(0, 0, c.getRGB());
        g.drawImage(buffer, x, y, null);
    }

    public void floodFill(BufferedImage target, int x, int y, Color fillColor, Color borderColor) {
        //Uso un Stack o pila de LIFO(Last In, Fist Out) para ir añadiendo las posiciones de los puntos a colorear
        //Mientras la pila no este vacia, se sacara un punto de la pila y
        //se coloreara siempre que el color del fondo no sea el mismo que el borde
        //despues de colorear pondra cuatro elementos nuevos en la pila
        Stack<Point> stack = new Stack<>();
        stack.add(new Point(x, y));
        while (!stack.isEmpty()) {
            Point p = stack.pop();
            if (target.getRGB(p.X, p.Y) != borderColor.getRGB()
                    && target.getRGB(p.X, p.Y) != fillColor.getRGB()) {
                target.setRGB(p.X, p.Y, fillColor.getRGB());
                stack.add(new Point(p.X + 1, p.Y));
                stack.add(new Point(p.X - 1, p.Y));
                stack.add(new Point(p.X, p.Y + 1));
                stack.add(new Point(p.X, p.Y - 1));
            }
        }
    }

    void drawLine(Graphics g, int x0, int y0, int x1, int y1, Color c) {
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

    public void fillElipse(Graphics g, int xCenter, int yCenter, int rx, int ry, Color c) {
        Rectangle bounds = g.getClipBounds();
        int width = (int) bounds.getWidth();
        int height = (int) bounds.getHeight();
        BufferedImage buffImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D buffGraphics = buffImage.createGraphics();
        int rx2 = rx * rx;
        int ry2 = ry * ry;

        int x = 0;
        int y = ry;
        int p;

        int px = 0;
        int py = 2 * rx2 * y;

        drawEllipsePlotpoint(buffGraphics, xCenter, yCenter, x, y, c);

        // Región 1
        p = (int) (ry2 - (rx2 * ry) + (0.25 + rx2));
        while (px < py) {
            x++;
            px += 2 * ry2;
            if (p < 0) {
                p += ry2 + px;
            } else {
                y--;
                py -= 2 * rx2;
                p += ry2 + px - py;
            }
            drawEllipsePlotpoint(buffGraphics, xCenter, yCenter, x, y, c);
        }

        // Región 2
        p = (int) (ry2 * (x + 0.5) * (x + 0.5) + rx2 * (y - 1) * (y - 1) - rx2 * ry2);
        while (y > 0) {
            y--;
            py -= 2 * rx2;
            if (p > 0) {
                p += ry2 - py;
            } else {
                x++;
                px += 2 * ry2;
                p += rx2 + px - py;
            }
            drawEllipsePlotpoint(buffGraphics, xCenter, yCenter, x, y, c);
        }

        floodFill(buffImage, xCenter, yCenter, c, c);
        g.drawImage(buffImage, 0, 0, null);
    }

    //xc = xCenter e yc = yCenter
    public void drawEllipsePlotpoint(Graphics g, int xc, int yc, int x, int y, Color c) {
        putPixel(g, xc + x, yc + y, c);
        putPixel(g, xc - x, yc + y, c);
        putPixel(g, xc + x, yc - y, c);
        putPixel(g, xc - x, yc - y, c);
    }

    public void fillCircle(Graphics g, int xCenter, int yCenter, int radio, Color c) {
        Rectangle bounds = g.getClipBounds();
        int width = (int) bounds.getWidth();
        int height = (int) bounds.getHeight();
        BufferedImage buffImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D buffGraphics = buffImage.createGraphics();
        int x = 0;
        int y = radio;
        int d = 3 - 2 * radio;

        drawPoints(buffGraphics, xCenter, yCenter, x, y, c);

        while (x < y) {
            x++;
            if (d < 0) {
                d = d + 4 * x + 6;
            } else {
                y--;
                d = d + 4 * (x - y) + 10;
            }
            drawPoints(buffGraphics, xCenter, yCenter, x, y, c);
        }

        floodFill(buffImage, xCenter, yCenter, c, c);
        g.drawImage(buffImage, 0, 0, null);
    }

    //xc = xCenter e yc = yCenter
    private void drawPoints(Graphics g, int xc, int yc, int x, int y, Color c) {
        putPixel(g, xc + x, yc + y, c);
        putPixel(g, xc - x, yc + y, c);
        putPixel(g, xc + x, yc - y, c);
        putPixel(g, xc - x, yc - y, c);
        putPixel(g, xc + y, yc + x, c);
        putPixel(g, xc - y, yc + x, c);
        putPixel(g, xc + y, yc - x, c);
        putPixel(g, xc - y, yc - x, c);
    }

    public void fillTriangle(Graphics g, int x0, int y0, int x1, int y1, int posx, int posy, Color c) {
        Rectangle bounds = g.getClipBounds();
        int width = (int) bounds.getWidth();
        int height = (int) bounds.getHeight();
        BufferedImage buffImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D buffGraphics = buffImage.createGraphics();

        drawLine(buffGraphics, x0, y0, x1, y1, c);
        drawLine(buffGraphics, x0, y0, posx, posy, c);
        drawLine(buffGraphics, x1, y1, posx, posy, c);

        int x0c = x0 + (x1 - x0) / 3;
        int y1pos = y1 + ((posy - y1) / 2);

        putPixel(g, x0c, y1pos, c);
        floodFill(buffImage, x0c, y1pos, c, c);
        g.drawImage(buffImage, 0, 0, null);
    }

    public void fillRect(Graphics g, int x0, int y0, int x1, int y1, Color c) {
        Rectangle bounds = g.getClipBounds();
        int width = (int) bounds.getWidth();
        int height = (int) bounds.getHeight();
        BufferedImage buffImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D buffGraphics = buffImage.createGraphics();

        //Arriba Horizontal
        drawLine(buffGraphics, x0, y0, x1, y0, c);
        // Izquierda Vertical
        drawLine(buffGraphics, x0, y0, x0, y1, c);
        //Abajo Vertical
        drawLine(buffGraphics, x0, y1, x1, y1, c);
        //Derecha Horizontal
        drawLine(buffGraphics, x1, y0, x1, y1, c);

        floodFill(buffImage, x0 + ((x1 - x0) / 2), y0 + ((y1 - y0) / 2), c, c);
        g.drawImage(buffImage, 0, 0, null);
    }

    public void drawEllipseSup(Graphics g, int xCenter, int yCenter, int rx, int ry, Color c) {
        int rx2 = rx * rx;
        int ry2 = ry * ry;

        int x = 0;
        int y = ry;
        int p;

        int px = 0;
        int py = 2 * rx2 * y;

        drawLineSupEllipsePlotpoint(g, xCenter, yCenter, x, y, c);

        // Región 1
        p = (int) (ry2 - (rx2 * ry) + (0.25 + rx2));
        while (px < py) {
            x++;
            px += 2 * ry2;
            if (p < 0) {
                p += ry2 + px;
            } else {
                y--;
                py -= 2 * rx2;
                p += ry2 + px - py;
            }
            drawLineSupEllipsePlotpoint(g, xCenter, yCenter, x, y, c);
        }

        // Región 2
        p = (int) (ry2 * (x + 0.5) * (x + 0.5) + rx2 * (y - 1) * (y - 1) - rx2 * ry2);
        while (y > 0) {
            y--;
            py -= 2 * rx2;
            if (p > 0) {
                p += ry2 - py;
            } else {
                x++;
                px += 2 * ry2;
                p += rx2 + px - py;
            }
            drawLineSupEllipsePlotpoint(g, xCenter, yCenter, x, y, c);
        }
    }

    //xc = xCenter e yc = yCenter
    public void drawLineSupEllipsePlotpoint(Graphics g, int xc, int yc, int x, int y, Color c) {
        putPixel(g, xc + x, yc - y, c);
        putPixel(g, xc - x, yc - y, c);
    }
    
    public void drawEllipseInf(Graphics g, int xCenter, int yCenter, int rx, int ry, Color c) {
        int rx2 = rx * rx;
        int ry2 = ry * ry;

        int x = 0;
        int y = ry;
        int p;

        int px = 0;
        int py = 2 * rx2 * y;

        drawLineInfEllipsePlotpoint(g, xCenter, yCenter, x, y, c);

        // Región 1
        p = (int) (ry2 - (rx2 * ry) + (0.25 + rx2));
        while (px < py) {
            x++;
            px += 2 * ry2;
            if (p < 0) {
                p += ry2 + px;
            } else {
                y--;
                py -= 2 * rx2;
                p += ry2 + px - py;
            }
            drawLineInfEllipsePlotpoint(g, xCenter, yCenter, x, y, c);
        }

        // Región 2
        p = (int) (ry2 * (x + 0.5) * (x + 0.5) + rx2 * (y - 1) * (y - 1) - rx2 * ry2);
        while (y > 0) {
            y--;
            py -= 2 * rx2;
            if (p > 0) {
                p += ry2 - py;
            } else {
                x++;
                px += 2 * ry2;
                p += rx2 + px - py;
            }
            drawLineInfEllipsePlotpoint(g, xCenter, yCenter, x, y, c);
        }
    }

    //xc = xCenter e yc = yCenter
    public void drawLineInfEllipsePlotpoint(Graphics g, int xc, int yc, int x, int y, Color c) {
        putPixel(g, xc + x, yc + y, c);
        putPixel(g, xc - x, yc + y, c);
    }

    class Point {

        int X, Y;

        Point(int X, int Y) {
            this.X = X;
            this.Y = Y;
        }
    }
}
