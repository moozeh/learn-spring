package org.moozeh.learn_spring_framework.app03_game_with_spring_beans;

import org.moozeh.learn_spring_framework.app01_game.game.GameRunner;
import org.moozeh.learn_spring_framework.app01_game.game.GamingConsole;
import org.moozeh.learn_spring_framework.app01_game.game.MarioGame;
import org.moozeh.learn_spring_framework.app01_game.game.PacmanGame;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GamingConfiguration {
    @Bean
    public GamingConsole GamingConsole(PacmanGame pacmanGame) {
        return pacmanGame;
    }

    @Bean
    public GameRunner GameRunner(GamingConsole GamingConsole) {
        return new GameRunner(GamingConsole);
    }

    @Bean
    public MarioGame marioGame() {
        return new MarioGame();
    }

    @Bean
    public PacmanGame pacmanGame() {
        return new PacmanGame();
    }
}
