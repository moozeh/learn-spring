package org.moozeh.learn_spring.app04_game.game;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("PacmanGame")
public class PacmanGame implements GamingConsole {

    public void up() {
        System.out.println("Pacman up");
    }

    public void down() {
        System.out.println("Pacman down");
    }

    public void left() {
        System.out.println("Pacman left");
    }

    public void right() {
        System.out.println("Pacman right");
    }
}
