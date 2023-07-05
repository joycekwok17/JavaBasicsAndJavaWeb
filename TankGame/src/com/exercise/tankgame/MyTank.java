package com.exercise.tankgame;

import java.util.Vector;

/**
 * @author Xuanchi Guo
 * @project TankGameHSP
 * @created 5/26/23
 */
public class MyTank extends Tank {
    Shot shot = null;
    Vector<Shot> shots = new Vector<>();

    public MyTank(int x, int y, int direction, int speed, int type) {
        super(x, y, direction, speed, type);
    }

    public void shotEnemy() {
        if (shots.size() > 4) {
            return;
        }
        switch (this.getDirection()) {
            case 0 -> shot = new Shot(this.getX() + 10, this.getY(), this.getDirection()); // up
            case 1 -> shot = new Shot(this.getX() + 35, this.getY() + 10, this.getDirection()); // right
            case 2 -> shot = new Shot(this.getX() + 10, this.getY() + 35, this.getDirection()); // down
            case 3 -> shot = new Shot(this.getX() - 5, this.getY() + 10, this.getDirection());     // left
        }
        shots.add(shot);
        Thread thread = new Thread(shot);
        thread.start();
    }

}
