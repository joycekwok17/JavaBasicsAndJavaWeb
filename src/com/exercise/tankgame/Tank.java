package com.exercise.tankgame;

/**
 * @author Xuanchi Guo
 * @project TankGameHSP
 * @created 5/26/23
 */
public class Tank {
    private int x;
    private int y;
    private int direction;
    private int speed;
    private int type;

    public Tank(int x, int y, int direction, int speed, int type) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.speed = speed;
        this.type = type;
    }

    public void moveUp() {
        y -= speed;
    }

    public void moveDown() {
        y += speed;
    }

    public void moveLeft() {
        x -= speed;
    }

    public void moveRight() {
        x += speed;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public int getDirection() {
        return direction;
    }
    public int getSpeed() {
        return speed;
    }
    public int getType() {
        return type;
    }
}
