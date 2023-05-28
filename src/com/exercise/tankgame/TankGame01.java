package com.exercise.tankgame;

import javax.swing.*;

/**
 * @author Xuanchi Guo
 * @project TankGameHSP
 * @created 5/26/23
 */
public class TankGame01 extends JFrame {
    Panel panel;
    public static void main(String[] args) {
        new TankGame01();
    }

    public TankGame01() {
        panel = new Panel();
        new Thread(panel).start();
        this.add(panel);
        this.addKeyListener(panel);
        this.setSize(1000, 750);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
