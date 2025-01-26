package org.moozeh.learn_spring.app12_springboot;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

// Rest Controller 가 그냥 Controller 와 다른 점은 무엇인가?

@RestController
public class CourseController {

    // ~~ Mapping 메서드를 달아주면 알아서 요청에 대한 리턴 값을 해당 함수의 리턴값으로 매핑해준다.
    @RequestMapping("/courses")
    public List<Course> retrieveAllCourses() {
        return Arrays.asList(
                new Course(1, "Learn 1", "moozeh"),
                new Course(2, "Learn 2", "moozeh")
        );
    }
}
