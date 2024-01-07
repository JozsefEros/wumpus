package com.jozsef.eros.model;

import com.jozsef.eros.NewGameLoader;
import com.jozsef.eros.controller.GameSaver;

import java.util.Random;
import java.util.Scanner;


public class Player {
    // properties
    private String playerName;
    private static int playerPosX;
    private static int playerPosY;
    private static int playerInitPosX;
    private static int playerInitPosY;
    private static char direction = 'N';
    private static int numberOfArrows;
    private static int numberOfGolds = 0;
    private static int killedWumpus = 0;
    private static int playerSteps = 0;
    // Konstruktor a játékos nevének bekérésére
    public void PlayerName() {
        setPlayerName();
    }
    public void PlayerPosition(){
        setPlayerPosition();
    }
    public static void PlayerDirection(char dir) {
        setPlayerDirection(dir);
    }
    public static void PlayerPosX(int posX) {
        setPlayerPosX(posX);
    }
    public static void PlayerPosY(int posY) {
        setPlayerPosY(posY);
    }
    public static void  NumberOfArrows(int arrows) {
        numberOfArrows = arrows;
    }
    public static void NumberOfGolds(int gold) {
        setNumberOfGolds(gold);
    }
    public static void KilledWumpus(int wumpus) {
        killedWumpus = wumpus;
    }
    public static void PlayerSteps(int step) {
        setPlayerSteps(step);
    }
    // Metódus a játékos nevének beállítására
    private void setPlayerName() {
        // Név bekérése
        Scanner kb = new Scanner(System.in);
        System.out.print("Kérem, adja meg a játékos nevét: ");
        playerName = kb.nextLine();
        // Mentés adatbázisba
        GameSaver saver = new GameSaver();
        saver.savePlayer(playerName);
    }
    private static void setPlayerDirection(char dir) {
        direction = dir;
    }
    private static void setPlayerPosX(int posX){
        playerPosX = posX;

    }
    private static void setPlayerPosY(int posY){
        playerPosY = posY;

    }
    private static void setPlayerSteps(int step) {
        playerSteps = step;
    }
    private void setPlayerPosition(){
        Random random = new Random();
        int min = 1;
        int max = NewGameLoader.size - 2;
        int playerPositionX = random.nextInt(max - min) + min;
        int playerPositionY = random.nextInt(max - min) + min;
        this.playerPosX = playerPositionX;
        this.playerPosY = playerPositionY;
        playerInitPosX = playerPositionX;
        playerInitPosY = playerPositionY;
    }
    public void setNumberOfArrows() {
        if (NewGameLoader.size <= 8){
            this.numberOfArrows = 1;
        } else if (
            NewGameLoader.size > 8 && NewGameLoader.size <= 14){
            this.numberOfArrows = 2;
        } else {
            this.numberOfArrows = 3;
        }
    }
    private static void setNumberOfGolds(int gold) {
        numberOfGolds = gold;
    }
    // Metódusok a játékos nevének, pozíciójának és irányának lekérdezésére
    public String getPlayerName() {
        return playerName;
    }
    public static int getPlayerPosX() {
        return playerPosX;
    }
    public static int getPlayerPosY() {
        return playerPosY;
    }
    public static int getPlayerInitPosX() {
        return playerInitPosX;
    }
    public static int getPlayerInitPosY() {
        return playerInitPosY;
    }
    public static char getPlayerDirection(){
        return direction;
    }
    public static int getNumberOfArrows() {
        return numberOfArrows;
    }
    public static int getNumberOfGolds() {
        return numberOfGolds;
    }
    public static int getKilledWumpus() {
        return killedWumpus;
    }
    public static int getPlayerSteps() {
        return playerSteps;
    }
}
