package com.exercise.tankgame;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

/**
 * @author Xuanchi Guo
 * @project TankGameHSP
 * @created 5/26/23
 */
public class TankGame01 extends JFrame {
    Panel panel;

    public static void main(String[] args) throws IOException {

        new TankGame01();
    }

    public TankGame01() throws IOException {

        System.out.println("Input your choice (1: new game; 2: continue game): ");
        String choice = new java.util.Scanner(System.in).nextLine();

        panel = new Panel(choice);
        new Thread(panel).start();
        this.add(panel);
        this.addKeyListener(panel);
        this.setSize(1500, 850);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                try {
                    System.out.println("Recorder.saveRecord()");
                    Recorder.saveRecord();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                System.exit(0);
            }
        });
    }

}
