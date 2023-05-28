package com.exercise.tankgame;

import java.util.Vector;

/**
 * @author Xuanchi GUO
 * @created 27.05.23
 */
public class EnemyTank extends Tank{
    Vector<Shot> shots = new Vector<>();
    boolean isLive = true;
    public EnemyTank(int x, int y, int direction, int speed, int type) {
        super(x, y, direction, speed, type);
    }

//    public EnemyTank(int x, int y, int direction, int speed, int type, Vector<Shot> shots) {
//        super(x, y, direction, speed, type);
//        this.shots = shots;
//    }


}
