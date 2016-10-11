package com.company;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Unit extends JPanel {

    private boolean stat;

    public Unit(){
        Random random = new Random();
        this.stat = random.nextBoolean();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (stat) {
            g.fillRect(0, 0, getWidth() - 1, getHeight() - 1);
        } else {
            g.drawRect(0, 0, getWidth() - 1, getHeight() - 1);
        }
    }

    public void setDead() {
        stat = false;
    }

    public void setAlive() {
        stat = true;
    }

    public boolean isAlive() {
        return stat;
    }
}