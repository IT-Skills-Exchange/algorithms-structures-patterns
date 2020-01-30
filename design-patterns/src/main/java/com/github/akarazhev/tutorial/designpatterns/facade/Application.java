package com.github.akarazhev.tutorial.designpatterns.facade;

import com.github.akarazhev.tutorial.designpatterns.bridge.InMemRepository;
import com.github.akarazhev.tutorial.designpatterns.bridge.LockTransaction;
import com.github.akarazhev.tutorial.designpatterns.bridge.PropertyRepository;
import com.github.akarazhev.tutorial.designpatterns.factorymethod.DbServer;
import com.github.akarazhev.tutorial.designpatterns.factorymethod.DbServers;
import com.github.akarazhev.tutorial.designpatterns.factorymethod.WebServer;
import com.github.akarazhev.tutorial.designpatterns.factorymethod.WebServers;
import com.github.akarazhev.tutorial.designpatterns.singleton.Logger;

import java.sql.SQLException;

/**
 * Provides functionality for the application.
 */
final class Application {
    private final Logger logger;
    private final DbServer dbServer;
    private final WebServer webServer;
    private final PropertyRepository repository;
    private boolean isRunning;

    /**
     * Constructs an application logic.
     */
    Application() throws Exception {
        logger = Logger.INSTANCE;
        dbServer = DbServers.newH2dbServer();
        webServer = WebServers.newHttpServer();
        repository = new InMemRepository(new LockTransaction());
    }

    /**
     * Starts the application.
     */
    public void start() {
        try {
            dbServer.start();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        webServer.start();
        logger.setLevel(1);
        isRunning = true;
    }

    /**
     * Checks if the application is run.
     *
     * @return a state of the application.
     */
    boolean isRunning() {
        return isRunning;
    }

    /**
     * Stops the application.
     */
    void stop() {
        logger.setLevel(0);
        webServer.stop();
        dbServer.stop();
        isRunning = false;
    }
}
