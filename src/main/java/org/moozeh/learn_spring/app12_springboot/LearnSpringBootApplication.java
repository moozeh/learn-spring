package org.moozeh.learn_spring.app12_springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// resources/application.properties 에 들어가보면, 로그 레벨도 설정할 수 있다.
// 기본 레벨은 INFO 이다. DEBUG로 바꾸면 더욱 더 많은 로그가 보여지는 걸 확인할 수 있다.
// 이때, Negative Match, Positive Match 도 나오는데, 자동 설정이 안되고, 되고 에 대한 결과들 이다.

@SpringBootApplication
public class LearnSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(LearnSpringBootApplication.class, args);
	}

}
