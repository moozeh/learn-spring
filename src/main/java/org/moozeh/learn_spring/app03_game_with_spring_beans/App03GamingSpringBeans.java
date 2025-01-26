package org.moozeh.learn_spring.app03_game_with_spring_beans;

import org.moozeh.learn_spring.app01_game.game.GameRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App03GamingSpringBeans {
    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(GamingConfiguration.class)) {
            context.getBean(GameRunner.class).run();
        }
    }
}
