package org.moozeh.learn_spring.app15_h2_jdbc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * H2 데이터베이스를 연결할 때, 아래와 같은 설정을 알아두자.
 *
 * 당장 마땅한 데이터베이스가 없을때, 사용하기 쉽다. (JPA 단에서 연결해주므로)
 *
 * spring.h2.console.enabled=true -> 콘솔을 활성화하는 설정
 *
 * spring.datasource.url=jdbc:h2:mem:testdb -> 데이터베이스 url을 설정
 */

@SpringBootApplication
public class LearnSpringBootApplication {

	public static void main(String[] args) { SpringApplication.run(LearnSpringBootApplication.class, args);
	}

}
