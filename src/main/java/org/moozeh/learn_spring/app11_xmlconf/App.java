package org.moozeh.learn_spring.app11_xmlconf;

import java.util.Arrays;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 이전에는 xml 파일로부터 Bean을 정의할 수 있었다.
 * resources/contextConfiguration.xml 파일을 보자.
 *
 * 컴포넌트 스캔도 가능하다. -> 인자로 오는 것 자체가 모두 다른 Bean 이기 때문에 가능은 하다..!
 * 또한 xml 로 구성하기 때문에, Pojo 로 만들기 깔끔해진다. -> XML 설정에서는 자바 코드를 바꿀 일이 없다.
 * 디버깅도 Annotation 에 비해선 쉬운 편이다.
 * 반대로 어떻게보면, Bean 정의가 바뀔 경우 적용하기 어렵다고 볼 수도 있다.
 *
 * 그런데 굳이 써야할까? -> 그건 아니다! 거의 필요 없다. 그냥 Annotation 기반으로 만들면 된다.
 * 혼용해서 사용하지만 말자.
 * 옛날 설정 파일은 수천개가 된다.
 *
 * 하지만 이해하고 인지하는 건 중요한데, 오래된 프로젝트에서는 해당 설정을 사용하기 때문에 알아두면 좋다.
 */
@Configuration
@ComponentScan
public class App {
    public static void main(String[] args) {
        try (var ctx = new ClassPathXmlApplicationContext("contextConfiguration.xml")) {
            Arrays.stream(ctx.getBeanDefinitionNames()).forEach(System.out::println);

            System.out.println(ctx.getBean("name"));
            System.out.println(ctx.getBean("age"));
        }
    }
}
