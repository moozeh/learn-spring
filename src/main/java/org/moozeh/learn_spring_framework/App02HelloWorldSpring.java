package org.moozeh.learn_spring_framework;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App02HelloWorldSpring {
    public static void main(String[] args) {
        // 1. Launch a Spring Context

        var context = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class);

        // 2. Configure the things that we want Spring to manage - @Configuration
        // HelloWorldConfiguration - @Configuration
        // name - @Bean

        // 3. 스프링이 관리하는 Bean 검색
        System.out.println(context.getBean("name"));
        System.out.println(context.getBean(Address.class));
        System.out.println(context.getBean("personWithMethodCall"));
        System.out.println(context.getBean("personWithParameters"));
    }
}
