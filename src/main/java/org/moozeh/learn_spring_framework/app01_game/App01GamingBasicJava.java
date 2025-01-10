package org.moozeh.learn_spring_framework.app01_game;

import org.moozeh.learn_spring_framework.app01_game.game.GameRunner;
import org.moozeh.learn_spring_framework.app01_game.game.PacmanGame;

public class App01GamingBasicJava {
    public static void main(String[] args) {

        // var game = new MarioGame();
        var game = new PacmanGame();
        var gameRunner = new GameRunner(game);
        gameRunner.run();
    }
}
