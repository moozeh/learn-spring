package org.moozeh.learn_spring.app13_springboot_devtools;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * DevTools 를 사용하면, 변경사항이 있을 경우 서버를 자동으로 재시작할 수 있어 편하다.
 *
 * maven 에 spring-boot-devtools 를 추가하자.
 *
 * 추가하기만 해도 알아서 설정되어서 재시작이 되는 걸 볼 수 있다.
 *
 * 당연히, pom.xml을 바꾸면 새롭게 다시 열어야 한다. 하지만 그 외 파일. property 등을 수정해도 다시 종료했다가 시작할 필욘 없다.
 */

@SpringBootApplication
public class LearnSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(LearnSpringBootApplication.class, args);
	}

}
