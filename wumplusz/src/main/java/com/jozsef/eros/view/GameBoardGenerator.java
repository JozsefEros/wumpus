package com.jozsef.eros.view;

import com.jozsef.eros.model.*;

public class GameBoardGenerator {
    private static char[][] room;

    public GameBoardGenerator(int rows, int cols) {
        room = new char[rows][cols];
    }

    public void GameBoardDisplay() {
        fillBoard();
        printBoard();
    }
    public static void fillBoard() {
        int numRows = room.length;
        int numCols = room[0].length;

        /** A játéktér falainak elhelyezése
         * Feltöltés az első sorban és az utolsó sorban
         */
        for (int col = 0; col < numCols; col++) {
            room[0][col] = 'W';
            room[numRows - 1][col] = 'W';
        }

        /** Feltöltés az első oszlopban és az utolsó oszlopban */
        for (int row = 0; row < numRows; row++) {
            room[row][0] = 'W';
            room[row][numCols - 1] = 'W';
        }

        /** Játékos és az arany elhelyezése a pályán */
        room[Player.getPlayerPosX()][Player.getPlayerPosY()] = 'H';
        if (Player.getNumberOfGolds() < 1) {
            room[Gold.getGoldPosX()][Gold.getGoldPosY()] = 'G';
        }
        /** Wumpusok elhelyezése a pályán */
        if (numRows <= 8) {
            room[WumpusGenerator.getWumpus1X()][WumpusGenerator.getWumpus1Y()] = 'U';
        } else if (numRows > 8 && numRows <= 14) {
            room[WumpusGenerator.getWumpus1X()][WumpusGenerator.getWumpus1Y()] = 'U';
            room[WumpusGenerator.getWumpus2X()][WumpusGenerator.getWumpus2Y()] = 'U';
        } else {
            room[WumpusGenerator.getWumpus1X()][WumpusGenerator.getWumpus1Y()] = 'U';
            room[WumpusGenerator.getWumpus2X()][WumpusGenerator.getWumpus2Y()] = 'U';
            room[WumpusGenerator.getWumpus3X()][WumpusGenerator.getWumpus3Y()] = 'U';
        }
        /** Belső falak elhelyezése */
        for (int i = 0; i < room.length; i++)
            for (int j = 0; j < room.length; j++) {
                if (room[i][j] == '\u0000') {
                    room[i][j] = InnerWallGenerator.getWall()[i][j];
                }
            }
    }
    public void printBoard() {
        /** Kiírás az oszlopok felett az oszlopok neve betűkkel */
        System.out.print("     ");
        for (int col = 0; col < room[0].length; col++) {
            char columnName = (char) ('A' + col);
            System.out.print(columnName + " | ");
        }
        System.out.println();
        System.out.print("   ");
        for (int col = 0; col < room[0].length; col++) {
            System.out.print("----");
        }
        System.out.print("-");
        System.out.println();

        for (int row = 0; row < room.length; row++) {
            /** Kiírás az első oszlopban a sorok megszámozásával */
            if (row < 9) {
                System.out.print(" " + (row + 1) + " | ");
            } else {
                System.out.print((row + 1) + " | ");
            }
            for (int col = 0; col < room[0].length; col++) {
                char c = room[row][col];
                if (c != 0) {
                    System.out.print(c + " | ");
                } else {
                    System.out.print("  | "); /** Üres mező */
                }
            }
            System.out.println();
            System.out.print("---");
            for (int col = 0; col < room[0].length; col++) {
                System.out.print("|---");
            }
            System.out.print("|");
            System.out.println();
        }
    }

    public static char[][] getBoard() {
        return room;
    }

}
