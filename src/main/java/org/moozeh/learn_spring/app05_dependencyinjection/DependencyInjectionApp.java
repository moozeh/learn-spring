package org.moozeh.learn_spring.app05_dependencyinjection;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
class BusinessClass {
    // @Autowired
    /**
     * 1. reflection 을 이용하여 필드에서 주입할 수 있다.
     * 하지만 jetbrains 에 의하면, final 선언이 불가능하기에 의도치않은 필드 변조 가능성이 있어 권장되지 않는다.
     */
    public final Dependency1 dependency1;

    public final Dependency2 dependency2;
//
//    2. Getter, Setter 를 이용해서도 의존성 주입이 가능하다.
//    Component 에 다른 Component dependency1, 2 를 인자로 받게 하므로, 의존성 주입이 되는 것이다.
//    @Autowired
//    public void setDependency1(Dependency1 dependency1) {
//        this.dependency1 = dependency1;
//    }
//
//    @Autowired
//    public void setDependency2(Dependency2 dependency2) {
//        this.dependency2 = dependency2;
//    }
    public BusinessClass(Dependency1 dependency1, Dependency2 dependency2) {
        /**
         * 3. 마지막으로 생성자 주입 방법.
         *
         * 생성자에서 arguments 에 DI를 자동으로 알아서 해준다.
         * 우리는 그 의존성을 받아서 필드로 설정하면 된다.
         * 생성자에도 @Autowired 를 달아야하지만, 이는 의무가 아니다.
         *
         * Spring Team 에서도 생성자 기반 DI를 추천하고 있다.
         * 모든 Bean 이 시작점을 한 곳에서 알 수 있기 때문이다.
         * 생성자가 끝나고나면, 본 Component(Bean)이 준비가 완료되기 때문이다.
         * 초기화 시점이 명확하기 때문이다.
         */
        this.dependency1 = dependency1;
        this.dependency2 = dependency2;
    }

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
