package org.moozeh.learn_spring.app15_h2_jdbc;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseJdbcCommandLineRunner implements CommandLineRunner {
    private final CourseJdbcRepository courseJdbcRepository;

    public CourseJdbcCommandLineRunner(CourseJdbcRepository courseJdbcRepository) {
        this.courseJdbcRepository = courseJdbcRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        this.courseJdbcRepository.insert(new Course(1, "Learn AWS", "moozeh"));
        this.courseJdbcRepository.insert(new Course(2, "Learn DevOps", "moozeh"));
        this.courseJdbcRepository.insert(new Course(3, "Learn Spring", "moozeh"));
        this.courseJdbcRepository.deleteById(1);
        System.out.println(this.courseJdbcRepository.findById(2));
    }
}
