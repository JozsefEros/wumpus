package com.jozsef.eros.model;

import java.util.Random;
import com.jozsef.eros.NewGameLoader;

public class Gold {
    private static int goldX;
    private static int goldY;
    // Arany generálása
    public void GoldPosition() {
        setGoldPosition();
    }
    private void setGoldPosition() {
        Random random = new Random();
        int min = 1;
        int max = NewGameLoader.size - 2;
        int goldX = random.nextInt(max - min) + min;
        int goldY = random.nextInt(max - min) + min;
        this.goldX = goldX;
        this.goldY = goldY;
    }
    public static void resetGoldPosition() {
        goldX = '\u0000';
        goldY = '\u0000';
    }
    public static int getGoldPosX() {
        return goldX;
    }
    public static int getGoldPosY() {
        return goldY;
    }
}
