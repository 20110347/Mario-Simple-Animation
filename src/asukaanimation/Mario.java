/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package asukaanimation;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.InputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 *
 * @author Saul
 */
public class Mario implements KeyListener {

    //Saltos o Movimientos
    private Clip jump;
    int posY = 0;
    int posX = 0;
    int aumento = 5;

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
    Color lightBlue = new Color(140, 247, 233);
    Color blue = new Color(8, 121, 166);
    Color darkBlue = new Color(39, 145, 172);
    Color darkestBlue = new Color(4, 75, 108);

    //Pinks
    Color maybeWhite = new Color(255, 255, 250);
    Color lightPink = new Color(244, 193, 210);
    Color darkPink = new Color(219, 138, 166);

    //BrownShoes
    Color brown = new Color(109, 68, 37);
    //Red
    Color red = new Color(158, 0, 0);
    Color lightRed = new Color(253, 0, 0);
    Color darkRed = new Color(151, 55, 60);
    Color darkestRed = new Color(64, 0, 0);
    //SkinColor
    //Yellow
    Color yellow = new Color(255, 236, 186);
    //Skin
    Color skin = new Color(236, 209, 186);
    Color darkSkin = new Color(224, 129, 106);

    public void drawMario(Graphics g) {
        drawMarioSprite(g);
    }

    public void drawMarioSprite(Graphics g) {
        fillFlood fill = new fillFlood();

//        fill.fillRect(g, 96 + posX, 417 + posY, 119 + posX, 449 + posY, bgColor);
        //Gorra
        fill.fillRect(g, 100 + posX, 418 + posY, 114 + posX, 420 + posY, red);
        fill.fillRect(g, 99 + posX, 419 + posY, 121 + posX, 421 + posY, red);

        //Clothes
        //Front
        fill.fillRect(g, 100 + posX, 429 + posY, 113 + posX, 437 + posY, red);
        //Hands
        fill.fillRect(g, 98 + posX, 429 + posY, 100 + posX, 435 + posY, red);
        fill.fillRect(g, 114 + posX, 429 + posY, 116 + posX, 435 + posY, red);
        //Pants
        fill.fillRect(g, 99 + posX, 438 + posY, 105 + posX, 444 + posY, blue);
        fill.fillRect(g, 107 + posX, 438 + posY, 113 + posX, 444 + posY, blue);
        fill.fillRect(g, 101 + posX, 433 + posY, 112 + posX, 437 + posY, blue);
        fill.fillRect(g, 101 + posX, 430 + posY, 104 + posX, 432 + posY, blue);
        fill.fillRect(g, 109 + posX, 430 + posY, 112 + posX, 432 + posY, blue);

        //Gloves
        fill.fillRect(g, 97 + posX, 436 + posY, 101 + posX, 438 + posY, maybeWhite);
        fill.fillRect(g, 113 + posX, 436 + posY, 117 + posX, 438 + posY, maybeWhite);
        //Shoes
        fill.fillRect(g, 97 + posX, 445 + posY, 105 + posX, 448 + posY, brown);
        fill.fillRect(g, 107 + posX, 445 + posY, 115 + posX, 448 + posY, brown);

        //Skin
        //Head
        fill.fillRect(g, 100 + posX, 422 + posY, 114 + posX, 429 + posY, skin);
        fill.fillRect(g, 114 + posX, 424 + posY, 116 + posX, 429 + posY, skin);
        fill.fillRect(g, 116 + posX, 426 + posY, 118 + posX, 428 + posY, skin);
        //Eye
        fill.fillRect(g, 112 + posX, 422 + posY, 113 + posX, 425 + posY, black);

        //Hair and moustache
        //Hair
        fill.fillRect(g, 99 + posX, 422 + posY, 106 + posX, 423 + posY, black);
        fill.fillRect(g, 98 + posX, 423 + posY, 100 + posX, 426 + posY, black);
        fill.fillRect(g, 99 + posX, 425 + posY, 103 + posX, 427 + posY, black);
        fill.fillRect(g, 101 + posX, 423 + posY, 102 + posX, 427 + posY, black);
        fill.fillRect(g, 101 + posX, 425 + posY, 103 + posX, 425 + posY, black);
        //Moustache
        fill.fillRect(g, 114 + posX, 426 + posY, 117 + posX, 427 + posY, black);
    }

    @Override
    public void keyTyped(KeyEvent e) {
//        switch (e.getKeyChar()) {
//            case 'd':
//                posX++;
//                System.out.println("posX: " + posX);
//                break;
//            case 'a':
//                posX--;
//                System.out.println("posX: " + posX);
//                break;
//            case 'w':
//                posY--;
//                System.out.println("posY: " + posY);
//                break;
//            case 's':
//                posY++;
//                System.out.println("posY: " + posY);
//                break;
//            default:
//                System.out.println("Tecla no Usada");
//                break;
//        }
    }
    
     public void doSound(){
        if (true) {
            try {
            InputStream ruta = getClass().getResourceAsStream("MarioJump.wav");    
            jump = AudioSystem.getClip();
            jump.open(AudioSystem.getAudioInputStream(ruta));
            jump.start();
            }catch(Exception ex){
                System.err.println(ex);
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W:
                if(posX<190 || posX >190 && posY <= -50){
                doSound();
                }
//                System.out.println("PosY: " + posY);
                if (posY > -100) {
                    posY -= aumento;
                } else if (posX > 200) {
                    if (posY > -50) {
                        posY -= aumento;
                    }
                }
                break;
            case KeyEvent.VK_A:
//                System.out.println("PosX: " + posX);
                if (posX > -95) {
                    posX -= aumento;;
                }
                break;
            case KeyEvent.VK_S:
//                System.out.println("PosY: " + posY);
                if (posY < 0 && posX < 205) {
                    posY += 2;
                } else if (posX > 200) {
                    if (posY < -50) {
                        posY += aumento;
                    }
                }
                break;
            case KeyEvent.VK_D:
//                System.out.println("PosX: " + posX);
                if (posX <= 205) {
                    posX += aumento;
                } else if (posY <= -50) {
                    if (posX <= 370) {
                        posX += aumento;
                    }
                }
                break;
            case KeyEvent.VK_E:
                break;
            default:
                System.out.println("Tecla no Usada");
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e
    ) {
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }
}
