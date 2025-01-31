package org.moozeh.learn_spring.app16_jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Entity 와 레포지토리를 매핑시키려면, EntityManager 를 불러오면 된다.
 * 이 또한, Jpa 에 정의되어 있다.
 *
 * Entity 매니저는 말그대로 엔티티와 관련된 작업들이 수많이 정의되어있는 매니징 클래스이다.
 *
 * 기존 코드대로 사용한다면 (즉, @Transactional 이 없다면) 트랜잭션이 없다고 하며 문제가 생긴다.
 * 즉, 기본적으로 JPA 레포지토리 코드는 트랜잭션을 기반으로 작동해야 함을 의미한다.
 *
 * 트랜잭션을 '필수'로 넣은 이유가 무엇일까? 단순 JDBC와는 사정이 매우 달라졌다.
 *
 * 하나 중요한 점은 `setter` 가 필요하지 않게 되었다는 점이다.
 *
 * 즉, Bean이 시작 될 때, 값 Setting을 미리 전부 마칠 수 있게 된 것이다.
 * 다시 말해, Entity 생성 시점이 JPA 내에서 캡슐화되었다고 볼 수 있겠다.
 * JDBC로 직접할 때에는 setter 가 있어야 jdbcTemplate에서 정보를 받아올 수 있었다.
 */
@Repository
@Transactional
public class CourseJpaRepository {
    // @Autowired // 단순히 Autowiring 하는 것보다 더 좋은 방식이 있는데,
    @PersistenceContext // 이것이 Jpa의 바로 그 `영속성 컨텍스트` 이다.
    private EntityManager entityManager;

    /**
     * Entity 라고 해서, 데이터베이스에서만 만들 필요는 없다.
     *
     * 기존 Bean으로 사용하듯이 그냥 사용하면 되는 것이다.
     * @param course
     */
    public void insert(Course course) {
        entityManager.merge(course); // 이렇게 하면, 엔티티 내 Bean과 매핑된 데이터베이스에 알아서 저장할 것이다! 정말 편하다.
    }

    public Course findById(long id) {
        return entityManager.find(Course.class, id); // 두번째 인자로 PK가 들어간다.
        // 그렇다면, PK가 아닌 다른 인덱싱된 레코드로 검색하려면..?
    }

    public void deleteById(long id) {
        Course course = entityManager.find(Course.class, id);
        entityManager.remove(course);
    }
}
