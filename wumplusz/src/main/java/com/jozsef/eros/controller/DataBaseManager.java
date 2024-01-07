package com.jozsef.eros.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseManager {

    private static final Logger logger = LoggerFactory.getLogger(DataBaseManager.class);

    /** The database connection. */
    private Connection connection;

    /** Database URL. */
    private static final String URL = "jdbc:h2:~/wumpus";
    /** Database user. */
    private static final String USER = "sa";
    /** Database password. */
    private static final String PASSWORD = "";

    public DataBaseManager() {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            initializeDatabase();
        } catch (SQLException e) {
            logger.error("SQL Exception: ", e);
        }
    }

    private void initializeDatabase() {
        try (Statement statement = connection.createStatement()) {
            // Highscores tábla létrehozása
            statement.execute(
                    "CREATE TABLE IF NOT EXISTS highscores (" +
                            "id INT AUTO_INCREMENT, " +
                            "player_name VARCHAR(255), " +
                            "score INT, " +
                            "victories INT, " +
                            "steps INT, " +
                            "timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP, " +
                            "PRIMARY KEY(id));"
            );
            logger.info("Highscores table created or already exists.");


            // Players tábla létrehozása
            statement.execute(
                    "CREATE TABLE IF NOT EXISTS players (" +
                            "id INT AUTO_INCREMENT, " +
                            "name VARCHAR(255), " +
                            "timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP, " +
                            "PRIMARY KEY(id));"
            );
            logger.info("Players table created or already exists.");
            // Game States tábla létrehozása
            statement.execute(
                    "CREATE TABLE IF NOT EXISTS gamestate (" +
                            "id INT AUTO_INCREMENT, " +
                            "player_name VARCHAR(255), " +
                            "current_map TEXT, " +
                            "hero_positionX VARCHAR(255), " +
                            "hero_positionY VARCHAR(255), " +
                            "hero_start_positionX INT, " +
                            "hero_start_positionY INT, " +
                            "killed_wumpuses INT, " +
                            "steps INT, " +
                            "has_gold BOOLEAN, " +
                            "PRIMARY KEY(id));"
            );
            logger.info("Game States table created or already exists.");
        } catch (SQLException e) {
            logger.error("SQL Exception while initializing database: ", e);
        }
    }

    public Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            logger.error("Error getting database connection", e);
            return null;
        }
    }
}
