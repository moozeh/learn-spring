package org.moozeh.learn_spring.app17_spring_data_jpa;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseJpaCommandLineRunner implements CommandLineRunner {
    private final CourseSpringDataJpaRepository repository;

    public CourseJpaCommandLineRunner(CourseSpringDataJpaRepository repository) {
        this.repository = repository;
    }

    /**
     * Repository.save 로 명세가 살짝 바뀌엇음을 알 수 있다.
     *
     * 즉, 기본적인 entity managing도 spring data jpa 가 다 해줌을 알 수 있다.
     *
     * 이전 경험에서 TypeORM 에서 제공하던 방식 그대로 활용하고 있음을 알 수 있다.
     *
     * deleteAll, DeleteAllInBatch 등 다양한 옵션들을 제공해주고 있다.
     *
     * existById 로 존재하는지 하나하나 전부 확인해볼 수 있다.
     *
     * 가장 중요한건 Repsitory 코드 자체가 날라갔음을 알 수 있다.
     */
    @Override
    public void run(String... args) throws Exception {
        this.repository.save(new Course(1, "Learn AWS", "moozeh"));
        this.repository.save(new Course(2, "Learn DevOps", "moozeh"));
        this.repository.save(new Course(3, "Learn Spring", "moozeh"));
        this.repository.deleteById(1L);
        System.out.println(this.repository.findById(2L));

        this.repository.findAll();
    }
}
