package org.moozeh.learn_spring.app04_game;

import org.moozeh.learn_spring.app04_game.game.GameRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("org.moozeh.learn_spring.app04_game.game")
public class App04GamingAppLauncherApplication {
    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(App04GamingAppLauncherApplication.class)) {
            context.getBean(GameRunner.class).run();
        }
    }
}
