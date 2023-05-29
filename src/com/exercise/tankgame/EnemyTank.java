package com.exercise.tankgame;

import java.util.Vector;

/**
 * @author Xuanchi GUO
 * @created 27.05.23
 */
public class EnemyTank extends Tank implements Runnable{
    Vector<Shot> shots = new Vector<>();
    boolean isLive = true;
    public EnemyTank(int x, int y, int direction, int speed, int type) {
        super(x, y, direction, speed, type);
    }

    public EnemyTank(int x, int y, int direction, int speed, int type, Vector<Shot> shots) {
        super(x, y, direction, speed, type);
        this.shots = shots;
    }


    @Override
    public void run() {
        while(true) {

            if (isLive && shots.size() < 1){  // multiple shots
                Shot s = null;
                switch (getDirection()){
                    case 0 -> s = new Shot(getX() + 10, getY(), getDirection());
                    case 1 -> s = new Shot(getX() + 35, getY() + 10, getDirection());
                    case 2 -> s = new Shot(getX() + 10, getY() + 35, getDirection());
                    case 3 -> s = new Shot(getX() - 5, getY() + 10, getDirection());
                }
                shots.add(s);
                Thread t = new Thread(s);
                t.start();
            }

            if (isLive) {
                switch (this.getDirection()) {
                    case 0 -> {
                        for (int i = 0;i < 30; i++) {
                            if (this.getY() > 0) {
                                this.moveUp();
                            }
                            try {
                                Thread.sleep(50);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        }
                    }
                    case 1 -> {
                        for (int i = 0;i < 30; i++) {
                            if (this.getX() < 1000 - 60) {
                                this.moveRight();
                            }
                            try {
                                Thread.sleep(50);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        }
                    }
                    case 2 -> {
                        for (int i = 0;i < 30; i++) {
                            if (this.getY() < 750 - 60) {
                                this.moveDown();
                            }
                            try {
                                Thread.sleep(50);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        }
                    }
                    case 3 -> {
                        for (int i = 0;i < 30; i++) {
                            if (this.getX() > 0) {
                                this.moveLeft();
                            }
                            try {
                                Thread.sleep(50);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        }
                    }
                }
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                setDirection((int) (Math.random() * 4));
            } else if (!isLive) {
                break;
            }

        }


    }
}
