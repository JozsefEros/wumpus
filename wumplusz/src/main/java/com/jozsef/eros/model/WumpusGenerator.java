package com.jozsef.eros.model;

import com.jozsef.eros.NewGameLoader;

public class WumpusGenerator {
    static int wumpus1X, wumpus1Y;
    static int wumpus2X, wumpus2Y;
    static int wumpus3X, wumpus3Y;

    public void wumpusGenerator() {
        setWumpusGenerator();
    }

    public void setWumpusGenerator() {
        if (NewGameLoader.size <= 8) {
            do {
                Wumpus wumpus1 = new Wumpus();
                wumpus1.WumpusPosition();
                this.wumpus1X = wumpus1.getWumpusPosX();
                this.wumpus1Y = wumpus1.getWumpusPosY();
            } while (
                    (wumpus1X == Player.getPlayerPosX() && wumpus1Y == Player.getPlayerPosY()) ||
                            (wumpus1X == Gold.getGoldPosX() && wumpus1Y == Gold.getGoldPosY())
            );
        } else if (NewGameLoader.size > 8 && NewGameLoader.size <= 14) {
            do {
                Wumpus wumpus1 = new Wumpus();
                wumpus1.WumpusPosition();
                this.wumpus1X = wumpus1.getWumpusPosX();
                this.wumpus1Y = wumpus1.getWumpusPosY();
                Wumpus wumpus2 = new Wumpus();
                wumpus2.WumpusPosition();
                this.wumpus2X = wumpus2.getWumpusPosX();
                this.wumpus2Y = wumpus2.getWumpusPosY();
            } while (
                    (wumpus1X == Player.getPlayerPosX() && wumpus1Y == Player.getPlayerPosY()) ||
                            (wumpus2X == Player.getPlayerPosX() && wumpus2Y == Player.getPlayerPosY()) ||
                            (wumpus1X == Gold.getGoldPosX() && wumpus1Y == Gold.getGoldPosY()) ||
                            (wumpus2X == Gold.getGoldPosX() && wumpus2Y == Gold.getGoldPosY())
            );
        } else {
            do {
                Wumpus wumpus1 = new Wumpus();
                wumpus1.WumpusPosition();
                this.wumpus1X = wumpus1.getWumpusPosX();
                this.wumpus1Y = wumpus1.getWumpusPosY();
                Wumpus wumpus2 = new Wumpus();
                wumpus2.WumpusPosition();
                this.wumpus2X = wumpus2.getWumpusPosX();
                this.wumpus2Y = wumpus2.getWumpusPosY();
                Wumpus wumpus3 = new Wumpus();
                wumpus3.WumpusPosition();
                this.wumpus3X = wumpus1.getWumpusPosX();
                this.wumpus3Y = wumpus1.getWumpusPosY();
            } while (
                    (wumpus1X == Player.getPlayerPosX() && wumpus1Y == Player.getPlayerPosY()) ||
                            (wumpus2X == Player.getPlayerPosX() && wumpus2Y == Player.getPlayerPosY()) ||
                            (wumpus3X == Player.getPlayerPosX() && wumpus3Y == Player.getPlayerPosY()) ||
                            (wumpus1X == Gold.getGoldPosX() && wumpus1Y == Gold.getGoldPosY()) ||
                            (wumpus2X == Gold.getGoldPosX() && wumpus2Y == Gold.getGoldPosY()) ||
                            (wumpus3X == Gold.getGoldPosX() && wumpus3Y == Gold.getGoldPosY())
            );
        }
    }

    public static int getWumpus1X() {
        return wumpus1X;
    }
    public static int getWumpus1Y() {
        return wumpus1Y;
    }

    public static int getWumpus2X() {
        return wumpus2X;
    }

    public static int getWumpus2Y() {
        return wumpus2Y;
    }

    public static int getWumpus3X() {
        return wumpus3X;
    }

    public static int getWumpus3Y() {
        return wumpus3Y;
    }
}
