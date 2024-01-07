package com.jozsef.eros.model;

import java.util.Random;

public class InnerWallGenerator {
    private static char[][] wall;
    private static int wallX, wallY;

    public InnerWallGenerator(int rows, int cols) {
        wall = new char[rows][cols];
    }

    public void WallPosition() {
        setWallPosition();
    }

    private static void setWallPosition() {
        int selfSize = (int) (wall.length * wall.length * 0.2);
        do {
            for (int i = 0; i <= selfSize; i++) {
                Random random = new Random();
                int min = 1;
                int max = wall.length - 2;
                int wallPosX = random.nextInt(max - min) + min;
                int wallPosY = random.nextInt(max - min) + min;
                wallX = wallPosX;
                wallY = wallPosY;
                Random rnd = new Random();
                int minR = 0;
                int maxR = 100;
                int result = rnd.nextInt(maxR - minR + 1) + minR;
                if (result <= 50) {
                    wall[wallX][wallY] = 'W';
                } else {
                    wall[wallX][wallY] = 'P';
                }
            }
        } while (
                (wallX == Player.getPlayerInitPosX() && wallY == Player.getPlayerInitPosY()) &&
                        (wallX == Gold.getGoldPosX() && wallY == Gold.getGoldPosY()) &&
                        (wallX == WumpusGenerator.getWumpus1X() && wallY == WumpusGenerator.getWumpus1Y()) &&
                        (wallX == WumpusGenerator.getWumpus2X() && wallY == WumpusGenerator.getWumpus2Y()) &&
                        (wallX == WumpusGenerator.getWumpus3X() && wallY == WumpusGenerator.getWumpus3Y())
        );
    }

    public static char[][] getWall() {
        return wall;
    }
}
