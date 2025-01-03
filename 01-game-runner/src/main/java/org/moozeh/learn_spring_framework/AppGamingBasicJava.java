package org.moozeh.learn_spring_framework;

import org.moozeh.learn_spring_framework.game.GameRunner;
import org.moozeh.learn_spring_framework.game.MarioGame;

public class AppGamingBasicJava {
    public static void main(String[] args) {

        var marioGame = new MarioGame();
        var gameRunner = new GameRunner(marioGame);
        gameRunner.run();
    }
}
