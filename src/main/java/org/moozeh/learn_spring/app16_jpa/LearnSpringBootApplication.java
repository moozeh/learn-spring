package org.moozeh.learn_spring.app16_jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * JPA를 사용하는 이유는 쿼리를 수행하는 테이블의 개수가 복잡해질수록 간단하게 코드 구현이 가능하기 때문이다.
 *
 * JPA를 사용하면, Bean 데이터를 직접 테이블로 매핑할 수 있는데, 이때 이 Bean을 엔티티 라고 부르게 된다. (아..!)
 *
 * 이 테이블 - 엔티티 간 '매핑'을 이용해서 값을 삽입하고 조작할 수 있게 되는 것이다.
 *
 * 엔티티가 정의되면, 이를 이용해 repository 를 정의할 수 있다.
 *
 * application.properties 값으로 아래와 같은 값을 추가하면, 생성된 SQL을 확인할 수 있다.
 * spring.jpa.show-sql=true
 */

@SpringBootApplication
public class LearnSpringBootApplication {

	public static void main(String[] args) { SpringApplication.run(LearnSpringBootApplication.class, args);
	}

}
