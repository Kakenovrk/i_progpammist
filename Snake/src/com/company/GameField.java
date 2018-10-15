package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Random;

public class GameField extends JPanel implements ActionListener {
    private final int SIZE = 320;
    private final int DOTSIZE = 16;
    private final int ALL_DOTS = 400;
    private Image dot;
    private Image apple;
    private int applex;
    private int appley;
    private int[] x = new int[ALL_DOTS];
    private int[] y = new int[ALL_DOTS];
    private int dots;
    private Timer timer;
    private boolean left;
    private boolean right = true;
    private boolean up = false;
    private boolean down = false;
    private boolean inGame = true;

    public GameField() {
        setBackground(Color.BLACK);
    }

    public void InitGame(){
        dots = 3;
        for (int i = 0; i < dots; i++) {
            x[i] = 48 -i*DOTSIZE;
            y[i] = 48;
        }
        timer = new Timer(250, this);
        timer.start();
        createApple();
    }
    public void createApple(){
        applex = new Random().nextInt(20)*DOTSIZE;
        appley = new Random().nextInt(20)*DOTSIZE;
    }
    public void loadImages(){
        ImageIcon iia = new ImageIcon("apple.png");
        apple = iia.getImage();
        ImageIcon iid = new ImageIcon("dot.png");
        dot = iid.getImage();
    }
    p
    public void move(){
        for (int i = dots; i > 0; i--) {
            x[i] = x[i-1];
            y[i] = y[i-1];
        }
        if (left){
            x[0] -= DOTSIZE;
        }
        if (right){
            x[0] += DOTSIZE;
        }
        if (up){
            x[0] -= DOTSIZE;
        }
        if (down){
            x[0] += DOTSIZE;
        }
    }
    @Override
    public void actionPerformed(ActiveEvent e){
        if (inGame){
            move();
        }
    }
}