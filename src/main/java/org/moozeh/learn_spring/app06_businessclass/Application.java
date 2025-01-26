package org.moozeh.learn_spring.app06_businessclass;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@Configurable
@ComponentScan
public class Application {
    public static void main(String[] args) {
        try (var ctx = new AnnotationConfigApplicationContext(Application.class)) {
            var service = ctx.getBean(BusinessCalculationService.class);
            System.out.println(service.findMax());
        }
    }
}
