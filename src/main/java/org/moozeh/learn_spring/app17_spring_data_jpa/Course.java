package org.moozeh.learn_spring.app17_spring_data_jpa;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

/**
 * jakarta.persistence.Entity 도 있고, org.hibernate.annotations 도 있다.
 * 이는 결국 구현체가 hibernate 이기 때문이다.
 *
 * Entity는 데이터베이스와 매핑이 되는 Bean 이기 때문에, Primary 키가 존재해야할 것이다. @Id
 */

@Entity(name="courses")
public class Course {
    @Id
    private long id;

    @Column(name="name") // 같은 이름으로 매칭된다면 이 값(annotation 전체)은 사실 불필요하다.
    private String name;
    // @Column(name="author")
    private String author;

    public Course() {}

    public Course(long id, String name, String author) {
        this.id = id;
        this.name = name;
        this.author = author;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
