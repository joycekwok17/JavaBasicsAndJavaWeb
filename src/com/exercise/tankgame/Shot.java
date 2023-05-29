package com.exercise.tankgame;

/**
 * @author Xuanchi GUO
 * @created 28.05.23
 */
public class Shot implements Runnable{
    int x;
    int y;
    int direct = 0;
    int speed = 2;
    boolean isLive = true;

    public Shot(int x, int y, int direct) {
        this.x = x;
        this.y = y;
        this.direct = direct;
    }

    @Override
    public void run() {
        do {
            try {
                Thread.sleep(50);
            } catch (Exception e) {
                e.printStackTrace();
            }
            switch (direct) {
                case 0 -> y -= speed;   // up
                case 1 -> x += speed;   // right
                case 2 -> y += speed;   // down
                case 3 -> x -= speed;   // left
            }
            System.out.println("Shot: x=" + x + ", y=" + y);
        } while (x >= 0 && x <= 1000 && y >= 0 && y <= 750 && isLive);
        isLive = false;
    }
}
