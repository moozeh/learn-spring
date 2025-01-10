package org.moozeh.learn_spring_framework.app03_game_with_spring_beans;

import org.moozeh.learn_spring_framework.app01_game.game.GameRunner;
import org.moozeh.learn_spring_framework.app01_game.game.GamingConsole;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App03GamingSpringBeans {
    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(GamingConfiguration.class)) {
            context.getBean(GameRunner.class).run();
        }
    }
}
