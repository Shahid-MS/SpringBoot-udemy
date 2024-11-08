package com.ms.h2database.JDBC;

import com.ms.h2database.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CourseJdbcRepository {

  @Autowired
  private JdbcTemplate springJdbcTemplate;

  //   private static String INSERT_QUERY =
  //     """
  //             INSERT INTO course(id, name, author)
  //             values(1, 'Learn SQL', 'MS')
  //             """;

  private static String INSERT_QUERY =
    """
            INSERT INTO course(id, name, author)
            values(?, ?, ?)
            """;

  private static String DELETE_QUERY =
    """
                    DELETE FROM course
                    WHERE id = ?
                    """;

  private static String SELECT_QUERY =
    """
                           SELECT * from course WHERE id = ? 
                            """;

  //   public void insert() {
  //     springJdbcTemplate.update(INSERT_QUERY);
  //   }

  public void insert(Course course) {
    springJdbcTemplate.update(
      INSERT_QUERY,
      course.getId(),
      course.getName(),
      course.getAuthor()
    );
  }

  public void delete(long id) {
    springJdbcTemplate.update(DELETE_QUERY, id);
  }

  Course findCourseById(long id) {
    return springJdbcTemplate.queryForObject(
      SELECT_QUERY,
      new BeanPropertyRowMapper<>(Course.class),
      id
    );
  }
}
