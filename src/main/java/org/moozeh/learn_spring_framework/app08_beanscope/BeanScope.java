package org.moozeh.learn_spring_framework.app08_beanscope;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
class NormalClass {

}

@Scope(value=ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Component
class PrototypeClass {

}

/**
 * Bean의 스코프는 두가지로 선언될 수 있다.
 * Normal - 컨텍스트에서 불러와지는 인스턴스는 항상 같다. (싱글톤) - IOC Container 당 하나.
 * Prototype - 컨텍스트에서 불러올 때마다 새로운 인스턴스를 생성하고 사용한다.
 * 
 * 웹에서만 적용되는 특별한 스코프도 존재한다.
 * 
 * Request - 요청당 하나의 인스턴스로 고정한다.
 * Session - 세션 당 하나의 인스턴스로 고정한다.
 * Application - 웹 서버 런타임당 하나
 * Websocket - 웹 소켓 당 하나
 * 
 * 자바 싱글톤은 디자인패턴이지만, 스프링 싱글톤은 다르다.
 * 스프링 싱글톤의 경우, `Ioc Container` 당 하나라고 얘기한다.
 * 자바 싱글톤은 JVM 당 하나기 때문에 엄밀하게 다른 개념이다.
 * 여러개의 스프링 런타임을 사용한다면, 아닐 수도 있는 것이다. 그러므로 유의해두자.
 */

@Configurable
@ComponentScan
public class BeanScope {
    public static void main(String[] args) {
        try (var ctx = new AnnotationConfigApplicationContext(BeanScope.class)) {
            System.out.println("컨텍스트 로드 완료");
            
            System.out.println(ctx.getBean(NormalClass.class));
            System.out.println(ctx.getBean(NormalClass.class));

            System.out.println(ctx.getBean(PrototypeClass.class));
            System.out.println(ctx.getBean(PrototypeClass.class));
            System.out.println(ctx.getBean(PrototypeClass.class));
        }
    }
}
