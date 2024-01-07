package com.jozsef.eros.controller;

import com.jozsef.eros.NewGameLoader;
import com.jozsef.eros.model.Player;
import com.jozsef.eros.model.WumpusGenerator;
import com.jozsef.eros.view.GameBoardGenerator;

public class PlayerActions {
    private static char action;

    public static void setPlayerMove(char move) {
        action = move;
        if (action == 'W' || action == 'w') {
            setPlayerStepForward();
            Player.PlayerSteps(Player.getPlayerSteps() + 1);
            CheckStatus.checkPositionStatus();
            ;
        } else if (action == 'S' || action == 's') {
            setPlayerStepBackward();
            Player.PlayerSteps(Player.getPlayerSteps() + 1);
            CheckStatus.checkPositionStatus();
        } else if (action == 'A' || action == 'a') {
            setPlayerTurnLeft();
        } else if (action == 'D' || action == 'd') {
            setPlayerTurnRight();
        } else if (action == 'F' || action == 'f') {
            if (Player.getNumberOfArrows() > 0) {
                playerFire();
                Player.NumberOfArrows(Player.getNumberOfArrows() - 1);
            } else {
                System.out.println("*******************************************************");
                System.out.println("*    You do not have enough arrow to kill a wumpus.   *");
                System.out.println("*******************************************************");
                Player.NumberOfArrows(0);
            }
        } else if (action == 'X' || action == 'x') {
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
        } else if (Player.getPlayerDirection() == 'S' &&
                Player.getPlayerPosX() < NewGameLoader.getSizeOfRoom() - 2) {
            Player.PlayerPosX(Player.getPlayerPosX() + 1);
        } else if (Player.getPlayerDirection() == 'W' &&
                Player.getPlayerPosY() > 1) {
            Player.PlayerPosY(Player.getPlayerPosY() - 1);
        } else if (Player.getPlayerDirection() == 'E' &&
                Player.getPlayerPosY() < NewGameLoader.getSizeOfRoom() - 2) {
            Player.PlayerPosY(Player.getPlayerPosY() + 1);
        } else {
            System.out.println("********************************************");
            System.out.println("*     You cannot step through the wall!    *");
            System.out.println("*  You have reached the wall of the room.  *");
            System.out.println("********************************************");
        }
    }

    public static void setPlayerStepBackward() {
        if (Player.getPlayerDirection() == 'N' &&
                Player.getPlayerPosX() < NewGameLoader.getSizeOfRoom() - 2) {
            Player.PlayerPosX(Player.getPlayerPosX() + 1);
        } else if (Player.getPlayerDirection() == 'S' &&
                Player.getPlayerPosX() > 1) {
            Player.PlayerPosX(Player.getPlayerPosX() - 1);
        } else if (Player.getPlayerDirection() == 'W' &&
                Player.getPlayerPosY() < NewGameLoader.getSizeOfRoom() - 2) {
            Player.PlayerPosY(Player.getPlayerPosY() + 1);
        } else if (Player.getPlayerDirection() == 'E' &&
                Player.getPlayerPosY() > 1) {
            Player.PlayerPosY(Player.getPlayerPosY() - 1);
        } else {
            System.out.println("********************************************");
            System.out.println("*     You cannot step through the wall!    *");
            System.out.println("*  You have reached the wall of the room.  *");
            System.out.println("********************************************");
        }
    }

    public static void playerFire() {

        if (Player.getPlayerDirection() == 'N') {
            for (int i = Player.getPlayerPosX(); i >= 0; i--) {
                if (GameBoardGenerator.getBoard()[i][Player.getPlayerPosY()] == 'W') {
                    System.out.println("***********************************************");
                    System.out.println("*     You hit the wall and lost an arrow.     *");
                    System.out.println("***********************************************");
                    break;
                } else if (GameBoardGenerator.getBoard()[i][Player.getPlayerPosY()] == 'U') {
                    System.out.println("************************************************");
                    System.out.println("*  Great! You hit a WUMPUS and lost an arrow.  *");
                    System.out.println("************************************************");
                    WumpusGenerator.deleteWumpus(i, Player.getPlayerPosY());
                    Player.KilledWumpus(Player.getKilledWumpus() + 1);
                    break;
                }
            }
        } else if (Player.getPlayerDirection() == 'E') {
            for (int i = Player.getPlayerPosY(); i >= 0; i++) {
                if (GameBoardGenerator.getBoard()[Player.getPlayerPosX()][i] == 'W') {
                    System.out.println("***************************************");
                    System.out.println("* You hit the wall and lost an arrow. *");
                    System.out.println("***************************************");
                    break;
                } else if (GameBoardGenerator.getBoard()[Player.getPlayerPosX()][i] == 'U') {
                    System.out.println("************************************************");
                    System.out.println("*  Great! You hit a WUMPUS and lost an arrow.  *");
                    System.out.println("************************************************");
                    WumpusGenerator.deleteWumpus(Player.getPlayerPosX(), i);
                    Player.KilledWumpus(Player.getKilledWumpus() + 1);
                    break;
                }
            }
        } else if (Player.getPlayerDirection() == 'S') {
            for (int i = Player.getPlayerPosX(); i >= 0; i++) {
                if (GameBoardGenerator.getBoard()[i][Player.getPlayerPosY()] == 'W') {
                    System.out.println("***************************************");
                    System.out.println("* You hit the wall and lost an arrow. *");
                    System.out.println("***************************************");
                    break;
                } else if (GameBoardGenerator.getBoard()[i][Player.getPlayerPosY()] == 'U') {
                    System.out.println("************************************************");
                    System.out.println("*  Great! You hit a WUMPUS and lost an arrow.  *");
                    System.out.println("************************************************");
                    WumpusGenerator.deleteWumpus(i, Player.getPlayerPosY());
                    Player.KilledWumpus(Player.getKilledWumpus() + 1);
                    break;
                }
            }
        } else if (Player.getPlayerDirection() == 'W') {
            for (int i = Player.getPlayerPosY(); i >= 0; i--) {
                if (GameBoardGenerator.getBoard()[Player.getPlayerPosX()][i] == 'W') {
                    System.out.println("***************************************");
                    System.out.println("* You hit the wall and lost an arrow. *");
                    System.out.println("***************************************");
                    break;
                } else if (GameBoardGenerator.getBoard()[Player.getPlayerPosX()][i] == 'U') {
                    System.out.println("************************************************");
                    System.out.println("*  Great! You hit a WUMPUS and lost an arrow.  *");
                    System.out.println("************************************************");
                    WumpusGenerator.deleteWumpus(Player.getPlayerPosX(), i);
                    Player.KilledWumpus(Player.getKilledWumpus() + 1);
                    break;
                }
            }
        }
    }
}

