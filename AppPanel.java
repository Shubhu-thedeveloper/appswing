import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.*;
import java.io.IOException;
import java.util.Random;

import javax.imageio.*;

import javax.swing.*;

public class AppPanel extends JPanel {
    Random r = new Random();
    static ImageIcon imageIcon;
    static ImageIcon imageIcon1;
    static ImageIcon imageIcon2;

    static BufferedImage bufferImage;
    Timer timer;
    int xAxis = 435;
    int yAxis = 100;
    int xAxis2 =210;
    int yAxis2= 520;

    AppPanel() {
        setSize(500, 500);
        // setBackground(Color.CYAN);
        showBgImage();
        recallPaintComp();
        keyboardControl();
        setFocusable(true);
    }

    void showBgImage() {
        // try {
        // bufferImage = ImageIO.read(AppPanel.class.getResource("carh.png"));
        // } catch (IOException e) {
        // // TODO Auto-generated catch block
        // System.out.println("NO IMAGE FOUND");
        // e.printStackTrace();
        // }
        imageIcon = new ImageIcon(getClass().getResource("Road.gif"));
        imageIcon1 = new ImageIcon(getClass().getResource("carh.png"));
        imageIcon2 = new ImageIcon(getClass().getResource("car2h.png"));
        // imageIcon = new ImageIcon(getClass().getResource("Road.gif"));

    }

    @Override
    protected void paintComponent(Graphics g) {
        // super.paintComponent(g);
        // g.drawImage(bufferImage, 100, 100, 500, 500, null);
        // super.paintComponent(g);
        if (imageIcon != null) {
            // Draw the animated GIF
            imageIcon.paintIcon(this, g, 0, 0);
        }
        if (imageIcon1 != null) {
            // Draw the animated GIF
            imageIcon1.paintIcon(this, g,xAxis
            ,yAxis);
        }
        if (imageIcon2 != null) {
            // Draw the animated GIF
            imageIcon2.paintIcon(this, g,xAxis2
            ,yAxis2);
        }
    }

    int temp = 0;
    int temp1 = 0;

    void recallPaintComp() {
        timer = new Timer(1, e -> {
            if((yAxis < 720)){

            yAxis += 10;
            if(temp == 0)
            xAxis -= 5;
            else if(temp==1)
            xAxis+=5;
            }
            else {
            yAxis = 100;
            temp = (r.nextInt(10)%2);
            if(temp == 1){
                xAxis = 620;
            }
            else if(temp == 0){
                xAxis = 435;
            }
            }
        }
        );

        // temp = 1;
        // if(xAxis < 0){
        // temp = 0;

        // }

        // if((yAxis < 420) && temp1 == 0){
        // yAxis += 6;
        // }
        // else {
        // yAxis -= 4;
        // temp1 = 1;
        // if(yAxis < 0){
        // temp1 = 0;
        // }

        // }

        // System.out.println("x"+xAxis);
        // System.out.println("y"+yAxis);
        // });
        timer.start();
        repaint();
    }

    void keyboardControl(){
    System.out.println("KEYBOARD CALLED");
    addKeyListener(new KeyListener() {

    @Override
    public void keyTyped(KeyEvent e) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'keyTyped'");
    }

    @Override
    public void keyPressed(KeyEvent e) {
    System.out.println("KEY PRESS CALLED");
    if(e.getKeyCode() == KeyEvent.VK_RIGHT){
        if(xAxis2!=760){
            xAxis2 = 760;
        }
    }
    else if(e.getKeyCode() == KeyEvent.VK_LEFT){
        if(xAxis2!=210){
            xAxis2 = 210;

        }
    }
    // else if(e.getKeyCode() == KeyEvent.VK_UP){
    // yAxis = yAxis - 5;
    // }
    // else if(e.getKeyCode() == KeyEvent.VK_DOWN){
    // yAxis = yAxis + 5;
    // }

    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'keyPressed'");
    }

    @Override
    public void keyReleased(KeyEvent e) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method keyReleased");
    }

    });
    }
}