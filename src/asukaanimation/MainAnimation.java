/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package asukaanimation;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JFrame;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 *
 * @author Saul
 */
public class MainAnimation extends JFrame implements Runnable {

    //Flag Inicial
//    boolean flag = true;
    private Image fondo = null;
    private Image buffer = null;
    private Image cloudBuffer = null;
    private Graphics gAux = null;
    private Graphics gfondo = null;
    private Graphics gCloud = null;
    private boolean flag = true;
    private Thread thr;
    private Mario mObj = new Mario();
    private Nube cloudObj = new Nube();
    private Background objBg = new Background();

    //Background Colors
    Color bgColor = new Color(104, 194, 233);

    public MainAnimation() {
//        buffer = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
//        graPixel = (Graphics2D) buffer.createGraphics();
//        setBackground(new Color(34,87,122));
        setSize(500, 500);
        setVisible(true);
        setResizable(false);
        setBackground(bgColor);
        this.addKeyListener(mObj);
        thr = new Thread(this);
        thr.start();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void update(Graphics g) {
        buffer = createImage(getWidth(), getHeight());
        gAux = buffer.getGraphics();
        gAux.setColor(bgColor);
        gAux.setClip(0, 0, getWidth(), getHeight());
        gAux.drawImage(fondo, 0, 0, this);
        mObj.drawMario(gAux);
        if (mObj.getPosX() < 210) {
            if (mObj.getPosY() < 0 && mObj.getPosY() > -105) {
                if(mObj.getPosY()> -105 && mObj.getPosY() < -60){
                    mObj.setPosY(mObj.getPosY() + 3);
                }else{
                    mObj.setPosY(mObj.getPosY() + 1);
                }   
            }
        } else if (mObj.getPosX() > 210) {
            if (mObj.getPosY() < -50 && mObj.getPosY() > -150) {
                mObj.setPosY(mObj.getPosY() + 2);
            }
        }
        cloudBuffer = createImage(getWidth(), getHeight());
        gCloud = cloudBuffer.getGraphics();
        gCloud.setColor(bgColor);
        gCloud.setClip(0, 0, getWidth(), getHeight());
        gCloud.drawImage(buffer, 0, 0, this);
        if(cloudObj.getPosX()>-130){
//            System.out.println("posX"+cloudObj.getPosX());
            cloudObj.setPosX(cloudObj.getPosX() - 1);
        }else{
            cloudObj.setPosX(200);
        }            
        cloudObj.drawCloud(gCloud);
        g.drawImage(cloudBuffer, 0, 0, this);
    }

    @Override
    public void paint(Graphics g) {
//        super.paint(g);
        if (fondo == null) {
            fondo = createImage(getWidth(), getHeight());
            gfondo = fondo.getGraphics();
            gfondo.setColor(bgColor);
            gfondo.setClip(0, 0, getWidth(), getHeight());
            objBg.drawWorld(gfondo);
//          g.drawImage(fondo, 0, 0, this);
        }
        update(g);
    }

    public static void main(String[] args) {
        MainAnimation obj = new MainAnimation();
    }

    @Override
    public void run() {
        try {
            while (true) {
                repaint();
                thr.sleep(5);
            }
        } catch (Exception ex) {
            System.err.println(ex);
        }
    }

}
