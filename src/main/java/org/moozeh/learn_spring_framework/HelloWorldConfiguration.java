package org.moozeh.learn_spring_framework;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

record Person (String name, int age) {}
record Address (String street, String city) {}

@Configuration
public class HelloWorldConfiguration {

    @Bean
    public String name() {
        return "Ranga";
    }

    @Bean
    public int age() {
        return 15;
    }

    @Bean
    public Person person() {
        return new Person("Ranga", 20);
    }

    @Bean(name = "yourCustomBean")
    public Address address() {
        return new Address("test", "test");
    }

    @Bean(name = "personWithMethodCall")
    public Person person2() {
        return new Person(name(), age());
    }

    @Bean(name = "personWithParameters")
    public Person person3(String name, int age) {
        return new Person(name, age);
    }
}
