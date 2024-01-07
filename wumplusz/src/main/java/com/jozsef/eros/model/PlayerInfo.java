package com.jozsef.eros.model;

import java.util.Arrays;
import com.jozsef.eros.NewGameLoader;
import com.jozsef.eros.model.Player;

public class PlayerInfo {
    private static int size;
    private static char direction;
    private static char posX;
    private static int posY;
    private static char initPosX;
    private static int initPosY;
    private static int steps;
    private static int arrows;
    private static int golds;
    private static int wumpuses;

    public static void setPlayerInfo() {
        size = NewGameLoader.size;
        direction = Player.getPlayerDirection();
        posX = posXWithChar();
        posY = Player.getPlayerPosX() + 1;
        initPosX = initPosXWithChar();
        initPosY = Player.getPlayerInitPosX() + 1;
        steps = Player.getPlayerSteps();
        arrows = Player.getNumberOfArrows();
        golds = Player.getNumberOfGolds();
        wumpuses = Player.getKilledWumpus();
    }
    public void getPlayerInfo() {
        System.out.println("Playerinfo: " + size + ' ' + posX + ' ' + posY + ' ' + direction);
        System.out.println("Start position: " + initPosX + ' ' + initPosY);
        System.out.println("Steps: " + steps);
        System.out.println("Arrows: " + arrows);
        System.out.println("Golds: " + golds);
        System.out.println("Killed wumpuses:" + wumpuses);
    }
    private static char posXWithChar () {
        int auxArrayLenght = NewGameLoader.size;
        char[] auxArray = new char[auxArrayLenght];
        char currentChar = 'A';
        for (int i = 0; i < auxArrayLenght; i++) {
            auxArray[i] = currentChar;
            currentChar++;
            if (currentChar > 'Z') {
                break;
            }
        }
        return auxArray[Player.getPlayerPosY()];
    }
    private static char initPosXWithChar () {
        int auxArrayLenght = NewGameLoader.size;
        char[] auxArray = new char[auxArrayLenght];
        char currentChar = 'A';
        for (int i = 0; i < auxArrayLenght; i++) {
            auxArray[i] = currentChar;
            currentChar++;
            if (currentChar > 'Z') {
                break;
            }
        }
        return auxArray[Player.getPlayerInitPosY()];
    }


}
