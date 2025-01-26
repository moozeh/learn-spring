package org.moozeh.learn_spring.app09_postconstruct_predestroy;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
class SomeClass {
    private SomeDependency someDependency;

    public SomeClass(SomeDependency someDependency) {
        super();
        this.someDependency = someDependency;
        System.out.println("All dep are ready!");
    }

    /**
     * 의존성이 준비되었으니 로직을 넣고싶다!
     * 
     * 그런데.. 의존성이 준비되면서 바로 아래 메소드를 실행시키고싶다면..?
     * 
     * 생성자에서 하게 되면, 해당 의존성 SomeClass 가 생성되고 난 후의 작업을 지정해줄 수 없다.
     * 
     * 즉, 와이어링 이후의 작업, 다시 말해 Post-Construct 시의 작업을 정의할 수 있는 것이다..
     * 
     * 그때 `@PostConstruct` 를 붙이면 된다.
     * 이는 `jakarta` 어노테이션 패키지에 있는 어노테이션이다.
     */
    @PostConstruct
    public void initialize() {
        someDependency.getReady();
    }

    /**
     * 이와 마찬가지로, 반대로 애플리케이션이 종료될 때,
     * 그때 이전에 실행할 작업을 정의할 수도 있을 것이다.
     * 
     * 이때 @PreDestory 어노테이션을 붙여주면 된다.
     */
    @PreDestroy
    public void cleanup() {
        // 데이터 베이스 연결 종료 등의 작업
        System.out.println("Clean up! Bye");
    }
}

@Component
class SomeDependency {
    public void getReady() {
        System.out.println("Some logics");
    }
}

@Configurable
@ComponentScan
public class PostConPreDes {
    public static void main(String[] args) {
        try (var ctx = new AnnotationConfigApplicationContext(PostConPreDes.class)) {
            ctx.getBean(SomeClass.class);
        }
    }
}
