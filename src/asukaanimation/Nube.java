/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package asukaanimation;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Saul
 */
public class Nube {

    int posX = 0;

    //Pinks
    Color maybeWhite = new Color(255, 255, 250);
    Color lightPink = new Color(244, 193, 210);
    Color darkPink = new Color(219, 138, 166);
    Color black = new Color(0, 0, 0);

    public void drawCloud(Graphics g) {
        drawCloudSprite(g);
    }

    public void drawCloudSprite(Graphics g) {
        fillFlood fill = new fillFlood();

        fill.fillElipse(g, 200+posX, 150, 60, 30, maybeWhite);
        fill.fillElipse(g, 160+posX, 125, 30, 15, maybeWhite);
        fill.fillElipse(g, 240+posX, 145, 45, 30, maybeWhite);
        fill.fillElipse(g, 240+posX, 180, 25, 10, maybeWhite);
        fill.fillElipse(g, 175+posX, 150, 2, 10, black);
        fill.fillElipse(g, 200+posX, 150, 2, 10, black);
    } 
     public int getPosX() {
        return posX;
    }


    public void setPosX(int posX) {
        this.posX = posX;
    }

}
