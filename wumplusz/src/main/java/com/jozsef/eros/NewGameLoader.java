package com.jozsef.eros;

import com.jozsef.eros.controller.PlayerActions;
import com.jozsef.eros.model.*;

import java.util.Scanner;

public class NewGameLoader {

    public static int size;
    private static char exit;
    public static void setExit(char code){
        exit = code;
    }

    public static void showNewGameHeader() {
        System.out.println("-----------------------------------");
        System.out.println("-         New Wumpus Game         -");
        System.out.println("-----------------------------------");
    }

    public static void SizeOfRoom() {
        setSizeOfRoom();
    }

    private static void setSizeOfRoom() {
        while (size < 6 || size > 20) {
            System.out.println("Input the size of the playground (6 to 20): ");
            Scanner sc = new Scanner(System.in);
            int roomSize = Integer.parseInt(sc.nextLine());
            size = roomSize;
        }
    }
    public static int getSizeOfRoom() {
        return size;
    }
    public void showGameBoard() {
        Player player = new Player();
        player.PlayerName();
        player.PlayerPosition();
        player.setNumberOfArrows();
        Gold gold = new Gold();
        gold.GoldPosition();
        WumpusGenerator generator = new WumpusGenerator();
        generator.wumpusGenerator();

        InnerWallGenerator innerWall = new InnerWallGenerator(size, size);
        innerWall.WallPosition();



        while (exit != 'Q'){
            GameBoardGenerator board = new GameBoardGenerator(size, size);
            board.GameBoardDisplay();

            PlayerActions action = new PlayerActions();
            System.out.println("Where would you like to go next?\nChoose an option.\nA - Left\nD - Right\nW - Forward\nS - Back\nQ - Quit");

            PlayerInfo info = new PlayerInfo();
            info.setPlayerInfo();
            info.getPlayerInfo();

            Scanner kb = new Scanner(System.in);
            action.setPlayerMove(kb.next().charAt(0));
        }

    }

}


