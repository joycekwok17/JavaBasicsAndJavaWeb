package com.exercise.tankgame;

import java.util.Vector;

/**
 * @author Xuanchi GUO
 * @created 27.05.23
 */
public class EnemyTank extends Tank implements Runnable {
    Vector<Shot> shots = new Vector<>();
    Vector<EnemyTank> enemyTanks = new Vector<>();
    boolean isLive = true;

    public EnemyTank(int x, int y, int direction, int speed, int type) {
        super(x, y, direction, speed, type);
    }

    public EnemyTank(int x, int y, int direction, int speed, int type, Vector<Shot> shots) {
        super(x, y, direction, speed, type);
        this.shots = shots;
    }

    public void setEnemyTanks(Vector<EnemyTank> enemyTanks) { // set enemy tanks from panel
        this.enemyTanks = enemyTanks;
    }

    public boolean isTouchEnemyTank() {
        switch (this.getDirection()) {
            case 0 -> {
                for (EnemyTank enemyTank : enemyTanks) {
                    if (enemyTank != this) {
                        if (this.getX() >= enemyTank.getX() && this.getX() <= enemyTank.getX() + 30
                                && this.getY() >= enemyTank.getY() && this.getY() <= enemyTank.getY() + 30) {
                            return true;
                        }
                        if (this.getX() + 30 >= enemyTank.getX() && this.getX() + 30 <= enemyTank.getX() + 30
                                && this.getY() >= enemyTank.getY() && this.getY() <= enemyTank.getY() + 30) {
                            return true;
                        }
                    }
                }
            }
            case 1 -> {
                for (int i = 0; i < enemyTanks.size(); i++) {
                    EnemyTank enemyTank = enemyTanks.get(i);
                    if (enemyTank != this) {
                        if (this.getX() + 30 >= enemyTank.getX() && this.getX() + 30 <= enemyTank.getX() + 30
                                && this.getY() >= enemyTank.getY() && this.getY() <= enemyTank.getY() + 30) {
                            return true;
                        }
                        if (this.getX() + 30 >= enemyTank.getX() && this.getX() + 30 <= enemyTank.getX() + 30
                                && this.getY() + 30 >= enemyTank.getY() && this.getY() + 30 <= enemyTank.getY() + 30) {
                            return true;
                        }
                    }
                }
            }
            case 2 -> {
                for (int i = 0; i < enemyTanks.size(); i++) {
                    EnemyTank enemyTank = enemyTanks.get(i);
                    if (enemyTank != this) {
                        if (this.getX() >= enemyTank.getX() && this.getX() <= enemyTank.getX() + 30
                                && this.getY() + 30 >= enemyTank.getY() && this.getY() + 30 <= enemyTank.getY() + 30) {
                            return true;
                        }
                        if (this.getX() + 30 >= enemyTank.getX() && this.getX() + 30 <= enemyTank.getX() + 30
                                && this.getY() + 30 >= enemyTank.getY() && this.getY() + 30 <= enemyTank.getY() + 30) {
                            return true;
                        }
                    }
                }
            }
            case 3 -> {
                for (int i = 0; i < enemyTanks.size(); i++) {
                    EnemyTank enemyTank = enemyTanks.get(i);
                    if (enemyTank != this) {
                        if (this.getX() >= enemyTank.getX() && this.getX() <= enemyTank.getX() + 30
                                && this.getY() >= enemyTank.getY() && this.getY() <= enemyTank.getY() + 30) {
                            return true;
                        }
                        if (this.getX() >= enemyTank.getX() && this.getX() <= enemyTank.getX() + 30
                                && this.getY() + 30 >= enemyTank.getY() && this.getY() + 30 <= enemyTank.getY() + 30) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    @Override
    public void run() {
        while (true) {

            if (isLive && shots.size() < 1) {  // multiple shots
                Shot s = null;
                switch (getDirection()) {
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
                        for (int i = 0; i < 30; i++) {
                            if (this.getY() > 0 && !this.isTouchEnemyTank()) {
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
                        for (int i = 0; i < 30; i++) {
                            if (this.getX() < 1000 - 60 && !this.isTouchEnemyTank()) {
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
                        for (int i = 0; i < 30; i++) {
                            if (this.getY() < 750 - 60 && !this.isTouchEnemyTank()) {
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
                        for (int i = 0; i < 30; i++) {
                            if (this.getX() > 0 && !this.isTouchEnemyTank()) {
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
