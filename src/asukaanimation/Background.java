/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package asukaanimation;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.File;
import java.io.InputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 *
 * @author Saul
 */
public class Background {

    private Clip OverworldBg;

    //Background Colors(Asuka)
    Color bgColor = new Color(110, 196, 223);
    Color bgDarkColor = new Color(92, 164, 195);
    Color darkGreen = new Color(95, 110, 56);
    Color lightGreen = new Color(0, 206, 1);
    Color gray = new Color(76, 75, 95);
    Color white = new Color(254, 254, 254);
    Color black = new Color(0, 0, 0);
    //Background Colors(Mario)
    Color bgColorM = new Color(92, 148, 250);
    Color greenM = new Color(128, 208, 13);
    Color darkGreenM = new Color(18, 164, 0);
    Color brownRock = new Color(202, 151, 86);

    //Mario
    Color redM = new Color(218, 38, 0);
    Color orangeM = new Color(249, 145, 43);
    Color brownM = new Color(141, 111, 0);

    //Blues
    Color lightBlueMountain = new Color(201, 227, 232);
    Color blueMountain = new Color(115, 178, 213);
    Color greenMountain = new Color(198, 227, 231);
    Color lightGreenMountain = new Color(239, 241, 254);
    Color darkBlueMountain = new Color(23, 86, 119);
    Color darkGreenMountain = new Color(148, 197, 207);

    //Pinks
    Color maybeWhite = new Color(255, 255, 250);
    Color lightPink = new Color(244, 193, 210);
    Color darkPink = new Color(219, 138, 166);

    //BrownShoes
    Color brown = new Color(109, 68, 37);
    //Red
    Color red = new Color(158, 0, 0);
    Color lightRed = new Color(253, 0, 0);
    Color darkRedStairs = new Color(178, 0, 78);
    Color darkestRed = new Color(64, 0, 0);
    //SkinColor
    //Yellow
    Color yellow = new Color(255, 236, 186);
    Color yellowBlock = new Color(255, 217, 46);
    //Skin
    Color skin = new Color(236, 209, 186);
    Color darkSkin = new Color(224, 129, 106);

    public void drawWorld(Graphics g) {
        drawBackground(g);
        doMusic();

    }

    public void doMusic() {
        try {
            InputStream ruta = getClass().getResourceAsStream("OverworldBg.wav");
            OverworldBg = AudioSystem.getClip();
            OverworldBg.open(AudioSystem.getAudioInputStream(ruta));
            OverworldBg.start();
            OverworldBg.loop(OverworldBg.LOOP_CONTINUOUSLY);
        } catch (Exception ex) {
            System.err.println(ex);
        }
    }

    public void drawMountain(Graphics g, fillFlood f, drawLineThickness d, drawCircleThickness c) {
        //Montaña Verde
        f.fillRect(g, 110, 300, 300, 450, greenMountain);
        f.fillElipse(g, 205, 300, 95, 95, greenMountain);
        c.drawSemiCircleSup(g, 206, 300, 93, 4, darkGreenMountain);
        d.setThickness(4);
        d.drawLine(g, 110, 300, 110, 450, darkGreenMountain);
        d.drawLine(g, 300, 300, 300, 450, darkGreenMountain);
        f.fillElipse(g, 180, 350, 15, 25, lightGreenMountain);
        f.fillElipse(g, 230, 250, 15, 25, lightGreenMountain);

        //Montaña Azul
        f.fillRect(g, 6, 250, 195, 450, blueMountain);
        f.fillElipse(g, 100, 250, 95, 95, blueMountain);
        c.drawSemiCircleSup(g, 101, 250, 93, 4, darkBlueMountain);
        d.setThickness(4);
        d.drawLine(g, 6, 250, 6, 450, darkBlueMountain);
        d.drawLine(g, 195, 250, 195, 450, darkBlueMountain);
        f.fillElipse(g, 50, 250, 15, 25, lightBlueMountain);
        f.fillElipse(g, 100, 300, 15, 25, lightBlueMountain);

        //Montaña Triangular
        f.fillTriangle(g, 50, 450, 250, 450, 175, 350, lightGreen);
        d.drawTriangle(g, 50, 450, 250, 450, 175, 350, black);
    }

    public void drawCerro(Graphics g, fillFlood f, drawLineThickness d, drawCircleThickness c) {
        f.fillRect(g, 300, 350, 490, 400, lightGreen);
        f.fillElipse(g, 395, 350, 95, 95, lightGreen);
        c.drawSemiCircleSup(g, 396, 350, 93, 4, black);
//        fill.drawEllipseSup(g, 395, 350, 95, 100, black);
        d.setThickness(4);
        d.drawLine(g, 300, 350, 300, 400, black);
        d.drawLine(g, 490, 350, 490, 400, black);
        d.drawLine(g, 300, 350, 300, 400, black);
        f.fillElipse(g, 350, 300, 5, 15, black);
        f.fillElipse(g, 400, 300, 5, 15, black);

        //Barranca
        f.fillTriangle(g, 490, 400, 300, 400, 490, 490, brownRock);
        f.fillTriangle(g, 395, 490, 490, 490, 395, 445, brownRock);
//        f.fillRect(g, 0, 450, 490, 490, brownRock);
    }

    public void drawGrass(Graphics g, fillFlood f, drawLineThickness d, clipCircles c) {
        d.setThickness(3);
        f.fillRect(g, 0, 450, 490, 490, brownRock);

        //Grass
        for (int i = 0; i < 380; i += 10) {
            f.fillElipse(g, 15 + i, 453, 5, 5, lightGreen);
        }
        //Grass
        for (int i = 0; i < 175; i += 10) {
            f.fillElipse(g, 315 + i, 403, 5, 5, lightGreen);
        }

        c.createClippingArea(0, 450, 490, 490, brownRock, g, 380, 15, 453);
        c.createClippingArea(300, 400, 490, 410, brownRock, g, 175, 315, 403);
         
        d.drawLine(g, 300, 400, 490, 400, black);
        d.drawLine(g, 0, 450, 395, 450, black);

        //Stairs
        d.drawLine(g, 300, 400, 300, 450, darkRedStairs);
        d.drawLine(g, 320, 400, 320, 450, darkRedStairs);
        d.drawLine(g, 300, 402, 320, 402, darkRedStairs);
        d.drawLine(g, 300, 412, 320, 412, darkRedStairs);
        d.drawLine(g, 300, 424, 320, 424, darkRedStairs);
        d.drawLine(g, 300, 436, 320, 436, darkRedStairs);
        d.drawLine(g, 300, 448, 320, 448, darkRedStairs);

//        objThick.drawLine(g, 300, 400, 395, 445, black);
    }

    public void drawBlocks(Graphics g, fillFlood f, drawLineThickness d) {
        f.fillRect(g, 125, 375, 150, 400, yellowBlock);
        d.drawLine(g, 132, 380, 132, 390, black);
        d.drawLine(g, 143, 380, 143, 390, black);

        f.fillRect(g, 151, 375, 177, 400, yellowBlock);
        d.drawLine(g, 159, 380, 159, 390, black);
        d.drawLine(g, 170, 380, 170, 390, black);

        d.setThickness(2);
        d.drawRect(g, 125, 375, 150, 400, black);
//        d.drawLine(g, 125, 375, 150, 375, black);
//        d.drawLine(g, 125, 400, 150, 400, black);
//        d.drawLine(g, 125, 375, 125, 400, black);
//        d.drawLine(g, 150, 375, 150, 400, black);

        d.drawRect(g, 151, 375, 177, 400, black);
//        d.drawLine(g, 151, 375, 177, 375, black);
//        d.drawLine(g, 151, 400, 177, 400, black);
//        d.drawLine(g, 151, 375, 151, 400, black);
//        d.drawLine(g, 177, 375, 177, 400, black);

        d.setThickness(4);
    }

    public void drawBackground(Graphics g) {
        //Objects
        fillFlood fill = new fillFlood();
        drawLineThickness objThick = new drawLineThickness();
        drawCircleThickness objCircleThick = new drawCircleThickness();
        clipCircles clip = new clipCircles((Graphics2D) g);

        drawMountain(g, fill, objThick, objCircleThick);
        drawBlocks(g, fill, objThick);
        drawCerro(g, fill, objThick, objCircleThick);
        drawGrass(g, fill, objThick, clip);
    }

//    public void drawMario(Graphics g) {
//        fillFlood fill = new fillFlood();
//
//        //Gorra
//        fill.fillRect(g, 100, 418, 114, 420, red);
//        fill.fillRect(g, 99, 419, 121, 421, red);
//
//        //Clothes
//        //Front
//        fill.fillRect(g, 100, 429, 113, 437, red);
//        //Hands
//        fill.fillRect(g, 98, 429, 100, 435, red);
//        fill.fillRect(g, 114, 429, 116, 435, red);
//        //Pants
//        fill.fillRect(g, 99, 438, 105, 444, blueMountain);
//        fill.fillRect(g, 107, 438, 113, 444, blueMountain);
//        fill.fillRect(g, 101, 433, 112, 437, blueMountain);
//        fill.fillRect(g, 101, 430, 104, 432, blueMountain);
//        fill.fillRect(g, 109, 430, 112, 432, blueMountain);
//
//        //Gloves
//        fill.fillRect(g, 97, 436, 101, 438, maybeWhite);
//        fill.fillRect(g, 113, 436, 117, 438, maybeWhite);
//        //Shoes
//        fill.fillRect(g, 97, 445, 105, 448, brown);
//        fill.fillRect(g, 107, 445, 115, 448, brown);
//
//        //Skin
//        //Head
//        fill.fillRect(g, 100, 422, 114, 429, skin);
//        fill.fillRect(g, 114, 424, 116, 429, skin);
//        fill.fillRect(g, 116, 426, 118, 428, skin);
//        //Eye
//        fill.fillRect(g, 112, 422, 113, 425, black);
//
//        //Hair and moustache
//        //Hair
//        fill.fillRect(g, 99, 422, 106, 423, black);
//        fill.fillRect(g, 98, 423, 100, 426, black);
//        fill.fillRect(g, 99, 425, 103, 427, black);
//        fill.fillRect(g, 101, 423, 102, 427, black);
//        fill.fillRect(g, 101, 425, 103, 425, black);
//        //Moustache
//        fill.fillRect(g, 114, 426, 117, 427, black);
//    }
}
