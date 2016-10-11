package com.company;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Field extends JPanel {

    private final int fieldSize = 60;
    private Unit[][] field = new Unit[fieldSize][fieldSize];
    private Unit[][] aliveCells = new Unit[fieldSize][fieldSize];
    private JPanel gui = new JPanel(new GridLayout(fieldSize, fieldSize, 2, 2));
    private ActionListener actionListener;

    public Field() {

        for (int i = 0; i < fieldSize; i++) {
            for (int j = 0; j < fieldSize; j++) {
                Unit cell = new Unit();
                cell.setPreferredSize(new Dimension(10, 10));
                gui.add(cell);
                field[i][j] = cell;
                aliveCells[i][j] = new Unit();
            }
        }
    }

    public void activate(){
        actionListener = new ActionListener() {
            public void actionPerformed(ActionEvent event) {

                for (int i = 0; i < fieldSize; i++)
                    for (int j = 0; j < fieldSize; j++) {
                        int aliveNeighbors = countAliveAround(j, i);

                        if (field[i][j].isAlive() && (aliveNeighbors == 2 || aliveNeighbors == 3))
                            aliveCells[i][j].setAlive();
                        if (!field[i][j].isAlive() && aliveNeighbors == 3)
                            aliveCells[i][j].setAlive();
                        if (field[i][j].isAlive() && (aliveNeighbors < 2 || aliveNeighbors > 3))
                            aliveCells[i][j].setDead();
                    }

                for (int i = 0; i < fieldSize; i++)
                    for (int j = 0; j < fieldSize; j++)
                        if (aliveCells[i][j].isAlive())
                            field[i][j].setAlive();
                        else field[i][j].setDead();

                gui.repaint();
            }
        };
    }

    private int countAliveAround(int x, int y) {
        int counter = 0;
        if (x > 0 && y > 0 && x < (fieldSize - 1) && y < (fieldSize - 1))
            for (int i = y - 1; i <= y + 1; i++)
                for (int j = x - 1; j <= x + 1; j++){
                    if (field[i][j].isAlive() && !(x == j && y == i))
                        counter++;
                }
        return counter;
    }

    public JPanel getJPanel(){
        return gui;
    }

    public ActionListener getActionListener()
    {
        return actionListener;
    }

}