package com.exercise.tankgame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.Vector;

/**
 * @author Xuanchi Guo
 * @project TankGameHSP
 * @created 5/26/23
 */
public class Panel extends JPanel implements KeyListener, Runnable {
    MyTank myTank = null;
    Vector<EnemyTank> enemyTanks = new Vector<>();
    Vector<Node> nodes = new Vector<>();
    Vector<Bomb> bombs = new Vector<>();
    int enemyTankNum = 3;

    Image image1 = null;
    Image image2 = null;
    Image image3 = null;


    public Panel(String choice) throws IOException {
        Recorder.setEnemyTanks(enemyTanks);
        myTank = new MyTank(500, 500, 3,5, 0); // create my tank

        switch (choice) {
            case "1" -> {
                Recorder.setAllEnemyTankNum(enemyTankNum);
                for (int i = 0; i < enemyTankNum; i++) {
                    EnemyTank enemyTank = new EnemyTank(100 * (i + 1), 0, 2, 1, 1);
                    Thread thread1 = new Thread(enemyTank);
                    thread1.start();
                    Shot shot = new Shot(enemyTank.getX() + 10, enemyTank.getY() + 35, enemyTank.getDirection());
                    enemyTank.shots.add(shot);
                    Thread thread = new Thread(shot);
                    thread.start();
                    enemyTanks.add(enemyTank); // create enemy tanks
                    enemyTank.setEnemyTanks(enemyTanks);
                }
            }
            case "2" -> {
                nodes = Recorder.getNodesAndEnemyTanks();
                for (Node node : nodes) {
                    EnemyTank enemyTank = new EnemyTank(node.x, node.y, node.direction, 1, 1);
                    Thread thread1 = new Thread(enemyTank);
                    thread1.start();
                    Shot shot = new Shot(enemyTank.getX() + 10, enemyTank.getY() + 35, enemyTank.getDirection());
                    enemyTank.shots.add(shot);
                    Thread thread = new Thread(shot);
                    thread.start();
                    enemyTanks.add(enemyTank); // create enemy tanks
                    enemyTank.setEnemyTanks(enemyTanks);
                }
            }
            default -> {
                System.out.println("Invalid input!");
                System.exit(0);
            }
        }

        image1 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_1.gif"));
        image2 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_2.gif"));
        image3 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_3.gif"));

    }

    public void showInfo(Graphics g){
        g.setColor(Color.BLACK);
        Font font = new Font("Times New Roman", Font.BOLD, 20);
        g.setFont(font);
        g.drawString("You have " + Recorder.getAllEnemyTankNum() + " enemy tanks left", 1020, 50);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0, 0, 1000, 750); // draw background
        showInfo(g);

        if (myTank != null && myTank.isLive) {
            drawTank(myTank.getX(), myTank.getY(), g, myTank.getDirection(), myTank.getType()); // draw my tank
        }

        assert myTank != null;
        for (Shot shot : myTank.shots) {
            if (shot.isLive) {
                g.draw3DRect(shot.x, shot.y, 1, 1, false); // draw my tank's shots
            }else {
                myTank.shots.remove(shot); // remove dead shots
            }
        }

        for (EnemyTank enemyTank : enemyTanks) {
            if (enemyTank.isLive){
                drawTank(enemyTank.getX(), enemyTank.getY(), g, enemyTank.getDirection(), enemyTank.getType()); // draw enemy tanks
                for (Shot shot : enemyTank.shots) {
                    if (shot.isLive) {
                        g.draw3DRect(shot.x, shot.y, 1, 1, false);  // draw enemy tanks' shots
                    }else {
                        enemyTank.shots.remove(shot); // remove dead shots
                    }
                }
            }
        }

        for (Bomb bomb: bombs) {
            if (bomb.life > 6) {
                g.drawImage(image1, bomb.x, bomb.y, 30, 30, this);
            } else if (bomb.life > 3) {
                g.drawImage(image2, bomb.x, bomb.y, 30, 30, this);
            } else {
                g.drawImage(image3, bomb.x, bomb.y, 30, 30, this);
            }
            bomb.lifeDown();
            if (bomb.life == 0) {
                bombs.remove(bomb);
            }
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



    public void hitEnemy(){
        for (Shot s : myTank.shots) {
            if (s.isLive) {
                for (EnemyTank enemyTank : enemyTanks) {
                    if (enemyTank.isLive) {
                        hitTank(s, enemyTank);
                    }
                }
            }
        }
    }

    public void hitMe() {
        for (EnemyTank enemyTank : enemyTanks) {
            if (enemyTank.isLive) {
                for (Shot shot : enemyTank.shots) {
                    if (shot.isLive && myTank.isLive) {
                        hitTank(shot, myTank);
                    }
                }
            }
        }
    }

    public void hitTank(Shot s, Tank enemyTank) { // check if the shot hit the enemy tank
        switch (enemyTank.getDirection()) {
            case 0, 2 -> {
                if (s.x > enemyTank.getX() && s.x < enemyTank.getX() + 20 && s.y > enemyTank.getY() && s.y < enemyTank.getY() + 30) {
                    s.isLive = false;
                    enemyTank.isLive = false;
                    enemyTanks.remove(enemyTank);
                    if (enemyTank instanceof EnemyTank) {
                        Recorder.addEnemyTankNum();
                    }
                    Bomb bomb = new Bomb(enemyTank.getX(), enemyTank.getY());
                    bombs.add(bomb);
                }
            }
            case 1, 3 -> {
                if (s.x > enemyTank.getX() && s.x < enemyTank.getX() + 30 && s.y > enemyTank.getY() && s.y < enemyTank.getY() + 20) {
                    s.isLive = false;
                    enemyTank.isLive = false;
                    enemyTanks.remove(enemyTank);
                    if (enemyTank instanceof EnemyTank) {
                        Recorder.addEnemyTankNum();
                    }
                    Bomb bomb = new Bomb(enemyTank.getX(), enemyTank.getY());
                    bombs.add(bomb);
                }
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
            if (myTank.getY() > 0) {
                myTank.moveUp();
            }
        } else if(e.getKeyCode() == KeyEvent.VK_D) {
            myTank.setDirection(1);
            if (myTank.getX() + 35 < 1000) {
                myTank.moveRight();
            }
        } else if(e.getKeyCode() == KeyEvent.VK_S) {
            myTank.setDirection(2);
            if (myTank.getY() + 35 < 750) {
                myTank.moveDown();
            }
        } else if(e.getKeyCode() == KeyEvent.VK_A) {
            myTank.setDirection(3);
            if (myTank.getX() > 0) {
                myTank.moveLeft();
            }
        } else if(e.getKeyCode() == KeyEvent.VK_J) {
            System.out.println("shot");
            myTank.shotEnemy();
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
    @Override
    public void run() { // repaint the panel every 50ms to make the shot move

        while (true) {
            try {
            Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
//            if(this.myTank.shot != null && this.myTank.shot.isLive) { // check if the shot is live
//                for (EnemyTank enemyTank : enemyTanks) {
//                    hitTank(this.myTank.shot, enemyTank); // check if the shot hit the enemy tank
//                }
//            }
            this.hitMe();
            hitEnemy();
            this.repaint();
        }
    }
}
