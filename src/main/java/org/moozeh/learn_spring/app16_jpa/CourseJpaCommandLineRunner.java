package org.moozeh.learn_spring.app16_jpa;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseJpaCommandLineRunner implements CommandLineRunner {
    private final CourseJpaRepository courseJpaRepository;

    public CourseJpaCommandLineRunner(CourseJpaRepository courseJpaRepository) {
        this.courseJpaRepository = courseJpaRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        this.courseJpaRepository.insert(new Course(1, "Learn AWS", "moozeh"));
        this.courseJpaRepository.insert(new Course(2, "Learn DevOps", "moozeh"));
        this.courseJpaRepository.insert(new Course(3, "Learn Spring", "moozeh"));
        this.courseJpaRepository.deleteById(1);
        System.out.println(this.courseJpaRepository.findById(2));
    }
}
