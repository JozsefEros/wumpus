package com.jozsef.eros.model;

import java.util.Random;
import com.jozsef.eros.NewGameLoader;

public class Wumpus {
    static int wumpusX;
    static int wumpusY;


    // Wumpusok generálása
    public void WumpusPosition() {
        setWumpusPosition();
    }
    private void setWumpusPosition() {
        Random random = new Random();
        int min = 1;
        int max = NewGameLoader.size - 2;
        int wumpusX = random.nextInt(max - min) + min;
        int wumpusY = random.nextInt(max - min) + min;
        this.wumpusX = wumpusX;
        this.wumpusY = wumpusY;
    }
    public int getWumpusPosX() {
        return wumpusX;
    }
    public int getWumpusPosY() {
        return wumpusY;
    }

}
