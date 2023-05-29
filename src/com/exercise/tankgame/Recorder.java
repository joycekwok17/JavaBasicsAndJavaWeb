package com.exercise.tankgame;

import java.io.*;
import java.util.Vector;

/**
 * @author Xuanchi Guo
 * @project TankGameHSP
 * @created 5/29/23
 * record the game and save it to a file
 */
public class Recorder {
    private static int allEnemyTankNum = 0;
    private static FileWriter fw = null;
    private static BufferedWriter bw = null;
    private static String recordFile = "src/record.txt";
    private static Vector<EnemyTank> enemyTanks = new Vector<>();
    private static Vector<Node> nodes = new Vector<>();

    public static Vector<Node> getNodes() {
        return nodes;
    }

    public static void setNodes(Vector<Node> nodes) {
        Recorder.nodes = nodes;
    }

    public static void saveRecord() throws IOException {
        bw = new BufferedWriter(new FileWriter(recordFile));
        bw.write(allEnemyTankNum + "\r\n");
        for (EnemyTank enemyTank : enemyTanks) {
            if (enemyTank.isLive) {
                String record = enemyTank.getX() + " " + enemyTank.getY() + " " + enemyTank.getDirection();
                bw.write(record + "\r\n");
            }
        }
        bw.close();
    }

    public static Vector<Node> getNodesAndEnemyTanks() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(recordFile));
        allEnemyTankNum = Integer.parseInt(br.readLine());
        String line;
        while (br.readLine() != null) {
            line = br.readLine();
            String[] xyd = line.split(" ");
            Node node = new Node(Integer.parseInt(xyd[0]), Integer.parseInt(xyd[1]), Integer.parseInt(xyd[2]));
            nodes.add(node);
        }
        return nodes;
    }

    public static Vector<EnemyTank> getEnemyTanks() {
        return enemyTanks;
    }

    public static void setEnemyTanks(Vector<EnemyTank> enemyTanks) {
        Recorder.enemyTanks = enemyTanks;
    }

    public static int getAllEnemyTankNum() {
        return allEnemyTankNum;
    }

    public static void setAllEnemyTankNum(int allEnemyTankNum) {
        Recorder.allEnemyTankNum = allEnemyTankNum;
    }

    public static void addEnemyTankNum() {
        allEnemyTankNum++;
    }
}
