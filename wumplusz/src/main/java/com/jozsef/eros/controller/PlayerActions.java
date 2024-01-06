package com.jozsef.eros.controller;

import com.jozsef.eros.GameBoardGenerator;
import com.jozsef.eros.NewGameLoader;
import com.jozsef.eros.model.Gold;
import com.jozsef.eros.model.Player;
import com.jozsef.eros.model.WumpusGenerator;

public class PlayerActions {
    private static char playerMove;
    public static void setPlayerMove(char move) {
        playerMove = move;
        if (playerMove == 'W' || playerMove == 'w') {
            setPlayerStepForward();
            Player.PlayerSteps(Player.getPlayerSteps() + 1);
            checkGoldPosition();
            checkWumpusPosition();
            checkWallPosition();
        } else if (playerMove == 'S' || playerMove == 's') {
            setPlayerStepBackward();
            Player.PlayerSteps(Player.getPlayerSteps() + 1);
            checkGoldPosition();
            checkWumpusPosition();
            checkWallPosition();
        } else if (playerMove == 'A' || playerMove == 'a') {
            setPlayerTurnLeft();
            setPlayerStepForward();
            Player.PlayerSteps(Player.getPlayerSteps() + 1);
            checkGoldPosition();
            checkWumpusPosition();
            checkWallPosition();
        } else if (playerMove == 'D' || playerMove == 'd') {
            setPlayerTurnRight();
            setPlayerStepForward();
            Player.PlayerSteps(Player.getPlayerSteps() + 1);
            checkGoldPosition();
            checkWumpusPosition();
            checkWallPosition();
        } else if (playerMove == 'Q' || playerMove == 'q') {
            GameSaver saver = new GameSaver();
            saver.showSaverMenu();
        }
    }
    public static void setPlayerTurnLeft() {
        if (Player.getPlayerDirection() == 'N') {
            Player.PlayerDirection('W');
        } else if (Player.getPlayerDirection() == 'W') {
            Player.PlayerDirection('S');
        } else if (Player.getPlayerDirection() == 'S') {
            Player.PlayerDirection('E');
        } else if (Player.getPlayerDirection() == 'E') {
            Player.PlayerDirection('N');
        }
    }
    public static void setPlayerTurnRight() {
        if (Player.getPlayerDirection() == 'N') {
            Player.PlayerDirection('E');
        } else if (Player.getPlayerDirection() == 'E') {
            Player.PlayerDirection('S');
        } else if (Player.getPlayerDirection() == 'S') {
            Player.PlayerDirection('W');
        } else if (Player.getPlayerDirection() == 'W') {
            Player.PlayerDirection('N');
        }
    }
    public static void setPlayerStepForward() {
        if (Player.getPlayerDirection() == 'N' && Player.getPlayerPosX() > 1) {
            Player.PlayerPosX(Player.getPlayerPosX() - 1);
        } else if (Player.getPlayerDirection() == 'S' && Player.getPlayerPosX() < NewGameLoader.getSizeOfRoom() - 2) {
            Player.PlayerPosX(Player.getPlayerPosX() + 1);
        } else if (Player.getPlayerDirection() == 'W' && Player.getPlayerPosY() > 1) {
            Player.PlayerPosY(Player.getPlayerPosY() - 1);
        } else if (Player.getPlayerDirection() == 'E' && Player.getPlayerPosY() < NewGameLoader.getSizeOfRoom() - 2) {
            Player.PlayerPosY(Player.getPlayerPosY() + 1);
        } else {
            System.out.println("Operation not executable.\nYou have reached the wall of the room.");
        }
    }
    public static void setPlayerStepBackward() {
        if (Player.getPlayerDirection() == 'N' && Player.getPlayerPosX() < NewGameLoader.getSizeOfRoom() - 2) {
            Player.PlayerPosX(Player.getPlayerPosX() + 1);
        } else if (Player.getPlayerDirection() == 'S' && Player.getPlayerPosX() > 1) {
            Player.PlayerPosX(Player.getPlayerPosX() - 1);
        } else if (Player.getPlayerDirection() == 'W' && Player.getPlayerPosY() < NewGameLoader.getSizeOfRoom() - 2) {
            Player.PlayerPosY(Player.getPlayerPosY() + 1);
        } else if (Player.getPlayerDirection() == 'E' && Player.getPlayerPosY() > 1) {
            Player.PlayerPosY(Player.getPlayerPosY() - 1);
        } else {
            System.out.println("Operation not executable.\nYou have reached the wall of the room.");
        }
    }
    public static void checkGoldPosition() {
        if (Player.getPlayerPosX() == Gold.getGoldPosX() &&
        Player.getPlayerPosY() == Gold.getGoldPosY()) {
            Player.NumberOfGolds(Player.getNumberOfGolds() + 1);
        }
    }
    public static void checkWumpusPosition() {
        if (
                (Player.getPlayerPosX() == WumpusGenerator.getWumpus1X() &&
                        Player.getPlayerPosY() == WumpusGenerator.getWumpus1Y()) ||
                        (Player.getPlayerPosX() == WumpusGenerator.getWumpus2X() &&
                                Player.getPlayerPosY() == WumpusGenerator.getWumpus2Y()) ||
                        (Player.getPlayerPosX() == WumpusGenerator.getWumpus3X() &&
                                Player.getPlayerPosY() == WumpusGenerator.getWumpus3Y())) {
            System.out.println("Sorry, you have DIED!\nGood bye");
            NewGameLoader.setExit('Q');
        }
    }
    public static void checkWallPosition() {
        if (GameBoardGenerator.getBoard()[Player.getPlayerPosX()][Player.getPlayerPosY()] == 'P') {
            Player.NumberOfArrows(Player.getNumberOfArrows() - 1);
        }
    }
}
