package org.moozeh.learn_spring_framework.app07_lazyinitialization;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
class A {

}

@Component
@Lazy // Lazy 옵션을 달아줌으로써, 사용되지 않을때는 굳이 자동연결을 시켜주지 않도록 할 수 있다.
class B {
    public A a;

    public B(A a) {
        this.a = a;
        System.out.println("초기화 로직 수행");
    }
}

@Configurable
@ComponentScan
public class LazyInitializationApp {
    public static void main(String[] args) {
        try (var ctx = new AnnotationConfigApplicationContext(LazyInitializationApp.class)) {
            // Bean 을 사용하지 않는 이상, "초기화 로직 수행" 문자열 출력은 실행되지 않는다.
            // @Lazy 는 @Bean 을 적용한 메소드에도 적용 가능하다.
            System.out.println("컨텍스트 로드 완료");
            ctx.getBean(B.class);
            /**
             * 하지만, Eager Initialization 이 선호된다. 왜?
             * Spring 구성에 오류가 있을 때, 바로 확인할 수 있기 때문
             * 
             * 권장되지 않고, 자주 사용되지 않는다. 따라서, 특수한 경우에만 써야한다.
             * 
             * @Configuration 클래스에 적용하면, 해당 클래스 내 모든 @Bean 메소드가 Lazy Init 된다.
             */
        }
    }
}
