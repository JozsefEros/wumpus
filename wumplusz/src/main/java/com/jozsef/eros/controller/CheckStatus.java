package com.jozsef.eros.controller;

import com.jozsef.eros.view.GameBoardGenerator;
import com.jozsef.eros.NewGameLoader;
import com.jozsef.eros.model.Gold;
import com.jozsef.eros.model.Player;
import com.jozsef.eros.model.WumpusGenerator;

public class CheckStatus {
    public static void checkPositionStatus() {
        checkGoldPosition();
        checkWumpusPosition();
        checkBlockagePosition();
        checkInitPosition();
    }
    public static void checkInitPosition() {
        if (Player.getPlayerPosX() == Player.getPlayerInitPosX() &&
        Player.getPlayerPosY() == Player.getPlayerInitPosY() &&
        Player.getNumberOfGolds() == 1) {
            System.out.println("****************************************************************");
            System.out.println("*                         CONGRATULATIONS                      *");
            System.out.println("*                      You have won the game.                  *");
            System.out.println("*  You have successfully got the gold and got out of the maze  *");
            System.out.println("****************************************************************");
            NewGameLoader.setExit('Q');
        }
    }
    public static void checkGoldPosition() {
        if (Player.getPlayerPosX() == Gold.getGoldPosX() &&
                Player.getPlayerPosY() == Gold.getGoldPosY()) {
            Player.NumberOfGolds(Player.getNumberOfGolds() + 1);
            Gold.resetGoldPosition();
            System.out.println("***************************************");
            System.out.println("*  You picked the gold successfully.  *");
            System.out.println("***************************************");
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
            System.out.println("*********************************");
            System.out.println("*      Sorry, you have DIED!    *");
            System.out.println("*           Good bye!           *");
            System.out.println("*********************************");
            NewGameLoader.setExit('Q');
        }
    }
    public static void checkBlockagePosition() {
        if (GameBoardGenerator.getBoard()[Player.getPlayerPosX()][Player.getPlayerPosY()] == 'P') {
            System.out.println("***************************************");
            System.out.println("*   You have fallen into a pitfall!   *");
            System.out.println("*          You lost an arrow.         *");
            System.out.println("***************************************");
            Player.NumberOfArrows(Player.getNumberOfArrows() - 1);
        } else if (GameBoardGenerator.getBoard()[Player.getPlayerPosX()][Player.getPlayerPosY()] == 'W') {
            System.out.println("**************************************");
            System.out.println("*   You cannot step into the wall!   *");
            System.out.println("**************************************");
            PlayerActions.setPlayerStepBackward();
        }
    }
}
