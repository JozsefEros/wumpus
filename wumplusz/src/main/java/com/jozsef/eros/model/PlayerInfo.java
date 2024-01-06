package com.jozsef.eros.model;

import java.util.Arrays;
import com.jozsef.eros.NewGameLoader;
import com.jozsef.eros.model.Player;

public class PlayerInfo {
    private static int size;
    private static char direction;
    private static char posX;
    private static int posY;
    private static int steps;
    private static int arrows;

    public static void PlayerInfo(){
    }
    public static void setPlayerInfo(){
        size = NewGameLoader.size;
        direction = Player.getPlayerDirection();
        posX = posXWithChar();
        posY = Player.getPlayerPosX() + 1;
        steps = Player.getPlayerSteps();
        arrows = Player.getNumberOfArrows();
    }
    public void getPlayerInfo(){
        System.out.println("Playerinfo: " + size + ' ' + posX + ' ' + posY + ' ' + direction);
        System.out.println("Steps: " + steps);
        System.out.println("Arrows: " + arrows);
    }
    private static char posXWithChar (){
        int auxArrayLenght = NewGameLoader.size;
        char[] auxArray = new char[auxArrayLenght];
        char currentChar = 'A';
        for (int i = 0; i < auxArrayLenght; i++){
            auxArray[i] = currentChar;
            currentChar++;
            if (currentChar > 'Z'){
                break;
            }
        }
        return auxArray[Player.getPlayerPosY()];
    }


}
