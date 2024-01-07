package com.jozsef.eros;

import com.jozsef.eros.controller.PlayerActions;
import com.jozsef.eros.model.*;
import com.jozsef.eros.view.GameBoardGenerator;

import java.util.Scanner;

public class NewGameLoader {

    public static int size;
    private static char exit;
    private static int roomMinSize = 6;
    private static int roomMaxSize = 20;
    public static void setExit(char code){
        exit = code;
    }

    public static void showNewGameHeader() {
        System.out.println("***********************************");
        System.out.println("*         New Wumpus Game         *");
        System.out.println("***********************************");
    }

    public static void SizeOfRoom() {
        setSizeOfRoom();
    }

    private static void setSizeOfRoom() {
        while (size < roomMinSize || size > roomMaxSize) {
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

        Scanner kb = new Scanner(System.in);
        while (exit != 'Q' && exit != 'P') {
            GameBoardGenerator board = new GameBoardGenerator(size, size);
            board.GameBoardDisplay();

            PlayerActions action = new PlayerActions();
            System.out.println("Where would you like to go next?");
            System.out.println("Choose an option.");
            System.out.println("W - Forward   | S - Back");
            System.out.println("A - Turn left | D - Turn right");
            System.out.println("          F - Fire\n");
            System.out.println("P - Save      | Q - Quit\n");

            PlayerInfo info = new PlayerInfo();
            info.setPlayerInfo();
            info.getPlayerInfo();

            char quitButton = kb.next().charAt(0);
            if (quitButton == 'Q' || quitButton == 'q') {
                System.out.println("Are you sure you want to quit? (Y/N)");
                char confirm = kb.next().charAt(0);
                if (confirm == 'Y' || confirm == 'y') {
                    exit = 'Q';
                }
            } else {
                action.setPlayerMove(quitButton);
            }
        }
    }

}


