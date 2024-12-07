package md.utm.repository;

import md.utm.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Student> retrieve() {
        return jdbcTemplate.query("SELECT * FROM student",
         (row, index) -> {
            String idnp = row.getString("idnp");
            String firstName = row.getString("first_name");
            String lastName = row.getString("last_name");
            String email = row.getString("email");
            char gender = row.getString("gender").toCharArray()[0];
            int age = row.getInt("age");

            return new Student(idnp, firstName, lastName, email, gender, age);
        });
    }

    public Student retrieveByIdnp(String idnp) {
        return jdbcTemplate.queryForObject(
                "SELECT * FROM student where idnp = ?",
                (row, index) -> {
                        String id = row.getString("idnp");
                        String firstName = row.getString("first_name");
                        String lastName = row.getString("last_name");
                        String email = row.getString("email");
                        char gender = row.getString("gender").toCharArray()[0];
                        int age = row.getInt("age");

                        return new Student(id, firstName, lastName, email, gender, age);
                        },
                idnp);
    }

    public void create(Student student) {
        jdbcTemplate.update("insert into student values(?, ?, ?, ?, ?, ?)",
                student.getIdnp(), student.getFirstName(), student.getLastName(),
                student.getEmail(), student.getGender(), student.getAge());
    }

    public void update(String idnp, Student student) {
        jdbcTemplate.update("update student set first_name = ?, last_name = ? , " +
                "email = ?, gender = ?, age = ? where idnp = ?", student.getFirstName(),
                student.getLastName(), student.getEmail(), student.getGender(), student.getAge(), idnp);
    }

    public void delete(String idnp) {
        jdbcTemplate.update("delete from student where idnp = ?", idnp);
    }
}
