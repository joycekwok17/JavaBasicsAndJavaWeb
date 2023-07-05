package com.exercise.tankgame;

/**
 * @author Xuanchi Guo
 * @project TankGameHSP
 * @created 5/29/23
 */
public class Bomb {
    int x;
    int y;
    int life = 9;
    boolean isLive = true;

    public Bomb(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void lifeDown() {
        if (life > 0) {
            life--;
        } else {
            this.isLive = false;
        }
    }
}
