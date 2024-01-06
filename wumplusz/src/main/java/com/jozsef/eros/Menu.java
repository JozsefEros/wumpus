package com.jozsef.eros;

import java.util.Scanner;
import com.jozsef.eros.controller.GameSaver;

public class Menu {
    boolean exit;
    //static int size = 0;

    public static void showMainMenuHeader() {
        System.out.println("-----------------------------------");
        System.out.println("-       Welcome in Wumplusz       -");
        System.out.println("-     An awesome console game     -");
        System.out.println("-----------------------------------");
    }

    public static void showMainMenu() {
        System.out.println("Please make a selection (0 - 3): ");
        System.out.println("1. New Game");
        System.out.println("2. Load game");
        System.out.println("3. Save game");
        System.out.println("0. Exit game");
    }

    public void runMainMenu() {

        //while (!exit) {
            showMainMenu();
            int choice = getMainMenuInput();
            mainMenuActions(choice);
        //}
    }

    private int getMainMenuInput() {
        Scanner kb = new Scanner(System.in);

        int choice = -1;
        while (choice < 0 || choice > 3) {
            try {
                System.out.println("\nEnter your choice (0 -3): ");
                choice = Integer.parseInt(kb.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid selection. Please try again.");
            }
        }
        return choice;
    }

    private void mainMenuActions(int choice) {
        switch (choice) {
            case 0:
                exit = true;
                System.out.println("Good bye!");
                break;
            case 1:
                NewGameLoader game = new NewGameLoader();
                game.showNewGameHeader();
                game.SizeOfRoom();

                game.showGameBoard();
                break;
            case 2:
                System.out.println("Load game\n");
                break;
            case 3:
                GameSaver saver = new GameSaver();
                saver.showSaverHeader();
                break;
            default:
                System.out.println("An unknown error has occurred!");
        }
    }
}
