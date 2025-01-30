package org.moozeh.learn_spring.app15_h2_jdbc;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CourseJdbcRepository {
    private final JdbcTemplate jdbcTemplate;

    private static final String DELETE_BY_ID = "DELETE FROM course WHERE id = ?";
    private static final String INSERT_QUERY = "INSERT INTO course values (?, ?, ?)";
    private static final String SELECT_BY_ID = "SELECT * FROM course WHERE id = ?";

    public CourseJdbcRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void insert(Course course) {

        jdbcTemplate.update(INSERT_QUERY,
                course.getId(),
                course.getName(),
                course.getAuthor()
        );
    }

    public void deleteById(long id) {
        jdbcTemplate.update(DELETE_BY_ID, id);
    }

    public Course findById(long id) {
        // 특정 객체를 생성한다는 뜻. 즉, 하나만을 반환할 수 있게 함
        // 두번째인자 : ResultSet -> Bean(오브젝트)에 매핑해야하기 때문에, 매핑할 클래스를 정의해주어야한다.
        // 이를 `RowMapper` 라고 한다. 이때, 테이블의 레코드 순서와 매칭이 잘 되어야할 것이다...
        // return jdbcTemplate.queryForObject(SELECT_BY_ID, Course.class, id);
        // 이렇게 할 수도 있겠지만, Row를 매핑해줄 수 있는 Mapper를 직접 호출해도 된다.
        // 세번째이후 : 매개변수
        return jdbcTemplate.queryForObject(SELECT_BY_ID,
                new BeanPropertyRowMapper<>(Course.class), id);
        // 여러개의 오브젝트를 반환하도록 하려면 어떻게해야할까.
    }
}
