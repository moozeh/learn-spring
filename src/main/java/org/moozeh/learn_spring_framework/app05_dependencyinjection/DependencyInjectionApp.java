package org.moozeh.learn_spring_framework.app05_dependencyinjection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
class BusinessClass {
    @Autowired
    Dependency1 dependency1;

    @Autowired
    Dependency2 dependency2;

    @Override
    public String toString() {
        return "Using" + dependency1.toString() + dependency2.toString();
    }
}

@Component
class Dependency1 {

}

@Component
class Dependency2 {

}

@Configuration
@ComponentScan // 지정자가 없으면, 자동으로 현재 패키지에서 탐색 수행
public class DependencyInjectionApp {
    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(DependencyInjectionApp.class)) {
            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

            // 필드 선언만으로 DI가 이루어지지 않음
            // Autowire을 선언하거나,
            System.out.println(context.getBean(BusinessClass.class).toString());
        }
    }
}
