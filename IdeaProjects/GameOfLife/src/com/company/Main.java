package com.company;

import javax.swing.*;

public class Main  {

    public static void main(String[] args) {

        Field field = new Field();
        field.activate();

        Timer timer = new Timer(300, field.getActionListener());
        timer.start();
        JOptionPane.showMessageDialog(null, field.getJPanel());
        timer.stop();
    }
}