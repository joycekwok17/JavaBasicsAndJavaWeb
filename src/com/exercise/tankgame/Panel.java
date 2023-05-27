package com.exercise.tankgame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

/**
 * @author Xuanchi Guo
 * @project TankGameHSP
 * @created 5/26/23
 */
public class Panel extends JPanel implements KeyListener {
    MyTank myTank = null;
    Vector<EnemyTank> enemyTanks = new Vector<>();
    int enemyTankNum = 3;
    public Panel() {
        myTank = new MyTank(100, 100, 1, 5, 0); // create my tank
        for (int i = 0; i < enemyTankNum; i++) {
            enemyTanks.add(new EnemyTank(100 * (i + 1), 0, 2, 5, 1)); // create enemy tanks
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0, 0, 1000, 750); // draw background
        drawTank(myTank.getX(), myTank.getY(), g, myTank.getDirection(), myTank.getType()); // draw my tank
        for (EnemyTank enemyTank : enemyTanks) {
            drawTank(enemyTank.getX(), enemyTank.getY(), g, enemyTank.getDirection(), enemyTank.getType()); // draw enemy tanks
        }
    }

    public void drawTank(int x, int y, Graphics g, int direction, int type) {
        switch (type) {
            case 0 -> g.setColor(Color.cyan);
            case 1 -> g.setColor(Color.yellow);
        }
        switch (direction) {
            case 0 -> { // up
                g.fill3DRect(x, y, 5, 30, false);   // draw tank body
                g.fill3DRect(x + 15, y, 5, 30, false);      // draw tank body
                g.fill3DRect(x + 5, y + 5, 10, 20, false);  // draw tank body
                g.fillOval(x + 5, y + 10, 10, 10);      // draw tank body
                g.drawLine(x + 10, y + 15, x + 10, y - 5);
            }
            case 1 -> {     // right
                g.fill3DRect(x, y, 30, 5, false);
                g.fill3DRect(x, y + 15, 30, 5, false);
                g.fill3DRect(x + 5, y + 5, 20, 10, false);
                g.fillOval(x + 10, y + 5, 10, 10);
                g.drawLine(x + 15, y + 10, x + 35, y + 10);
            }
            case 2 -> {    // down
                g.fill3DRect(x, y, 5, 30, false);
                g.fill3DRect(x + 15, y, 5, 30, false);
                g.fill3DRect(x + 5, y + 5, 10, 20, false);
                g.fillOval(x + 5, y + 10, 10, 10);
                g.drawLine(x + 10, y + 15, x + 10, y + 35);
            }
            case 3 -> {   // left
                g.fill3DRect(x, y, 30, 5, false);
                g.fill3DRect(x, y + 15, 30, 5, false);
                g.fill3DRect(x + 5, y + 5, 20, 10, false);
                g.fillOval(x + 10, y + 5, 10, 10);
                g.drawLine(x + 15, y + 10, x - 5, y + 10);
            }
        }
    }

    /**
     * Invoked when a key has been typed.
     * See the class description for {@link KeyEvent} for a definition of
     * a key typed event.
     *
     * @param e the event to be processed
     */
    @Override
    public void keyTyped(KeyEvent e) {

    }

    /**
     * Invoked when a key has been pressed.
     * See the class description for {@link KeyEvent} for a definition of
     * a key pressed event.
     *
     * @param e the event to be processed
     */
    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_W) {
            myTank.setDirection(0);
            myTank.moveUp();
        } else if(e.getKeyCode() == KeyEvent.VK_D) {
            myTank.setDirection(1);
            myTank.moveRight();
        } else if(e.getKeyCode() == KeyEvent.VK_S) {
            myTank.setDirection(2);
            myTank.moveDown();
        } else if(e.getKeyCode() == KeyEvent.VK_A) {
            myTank.setDirection(3);
            myTank.moveLeft();
        }
        this.repaint(); // repaint the panel
    }

    /**
     * Invoked when a key has been released.
     * See the class description for {@link KeyEvent} for a definition of
     * a key released event.
     *
     * @param e the event to be processed
     */
    @Override
    public void keyReleased(KeyEvent e) {

    }
}
