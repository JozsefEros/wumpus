package com.jozsef.eros.controller;

import com.jozsef.eros.controller.DataBaseManager;
import com.jozsef.eros.controller.FileManager;

import java.util.Scanner;

public class GameSaver {

    boolean exit;
    private int choice;

    public static void showSaverHeader() {
        System.out.println("-----------------------------------");
        System.out.println("-          Save the game          -");
        System.out.println("-----------------------------------");
    }

    public void showSaverMenu() {
        System.out.println("Please make a selection (0 - 3): ");
        System.out.println("1. Save to database");
        System.out.println("2. Save to file");
        System.out.println("0. Cancel");
    }

    public void runSaverMenu() {

        while (!exit) {
            showSaverMenu();
            int choice = getSaverMenuInput();
            saverMenuActions(choice);
        }
    }

    private int getSaverMenuInput() {
        Scanner kb = new Scanner(System.in);

        int choice = -1;
        while (choice < 0 || choice > 2) {
            try {
                System.out.println("\nEnter your choice (0 -2): ");
                choice = Integer.parseInt(kb.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid selection. Please try again.");
            }
        }
        return choice;
    }

    private void saverMenuActions(int choice) {
        switch (choice) {
            case 0:
                exit = true;
                System.out.println("Ide kerül majd a visszalépés az előző képernyőre");
                break;
            case 1:
                System.out.println("Ide kerül majd a mentés adatbázisba funkció\n");
                DataBaseManager saveToDb = new DataBaseManager();
                break;
            case 2:
                System.out.println("Ide kerül majd a mentés fáljba funkció\n");
                FileManager saveToFile1 = new FileManager();
                break;
            default:
                System.out.println("An unknown error has occurred.");
        }
    }
}
