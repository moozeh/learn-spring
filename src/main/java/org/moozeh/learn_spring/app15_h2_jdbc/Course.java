package org.moozeh.learn_spring.app15_h2_jdbc;

/**
 * 이 Bean Repository 에 전달할 예정이다.
 */
public class Course {
    private long id;
    private String name;
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
