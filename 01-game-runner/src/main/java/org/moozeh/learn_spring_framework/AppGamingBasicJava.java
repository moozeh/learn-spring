package org.moozeh.learn_spring_framework;

import org.moozeh.learn_spring_framework.game.GameRunner;
import org.moozeh.learn_spring_framework.game.MarioGame;
import org.moozeh.learn_spring_framework.game.PacmanGame;

public class AppGamingBasicJava {
    public static void main(String[] args) {

        // var game = new MarioGame();
        var game = new PacmanGame();
        var gameRunner = new GameRunner(game);
        gameRunner.run();
    }
}
