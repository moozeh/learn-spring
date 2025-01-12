package org.moozeh.learn_spring_framework.app04_game.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class GameRunner {
    private final GamingConsole game;

    public GameRunner(@Qualifier("pacmanGame") GamingConsole game) {
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
