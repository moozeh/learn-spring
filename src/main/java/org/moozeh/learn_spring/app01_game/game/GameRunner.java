package org.moozeh.learn_spring.app01_game.game;

public class GameRunner {
    GamingConsole game;

    public GameRunner(GamingConsole game) {
        this.game = game;
    }

    public void run() {
        System.out.println("Game running : " + game); // logging 프레임워크 사용하는게 좋다.
        game.up();
        game.down();
        game.left();
        game.right();
    }
}
