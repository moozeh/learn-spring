package org.moozeh.learn_spring.app17_spring_data_jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * interface 로 정의함에 주의
 *
 * JpaRepository 를 상속받아서 사용하게 된다.
 *
 * 그럼 실제로 누가 만들까? 그것은 다른 의존성에서 직접 Spring Data JPA 가 생성하도록 만드는 것이다.
 *
 * 우리가 해주어야할 건 그냥 Entity 와 ID 자료형만 정의해주면 끝이다!
 */
public interface CourseSpringDataJpaRepository extends JpaRepository<Course, Long> {
    List<Course> findByAuthor(String author);
}
