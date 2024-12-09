package md.utm.repository;

import md.utm.entity.Student;
import md.utm.entity.University;
import md.utm.entity.UniversityStudent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UniversityRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<University> retrieve() {
        return jdbcTemplate.query("SELECT * FROM university",
         (row, index) -> {
            Long id = row.getLong("id");
            String fullName = row.getString("full_name");
            String shortName = row.getString("short_name");
            String address = row.getString("address");

            return new University(id, fullName, shortName, address);
        });
    }

    public University retrieveById(Long id) {
        return jdbcTemplate.queryForObject(
                "SELECT * FROM university where id = ?",
                (row, index) -> {
                    Long id_internal = row.getLong("id");
                    String fullName = row.getString("full_name");
                    String shortName = row.getString("short_name");
                    String address = row.getString("address");

                    return new University(id_internal, fullName, shortName, address);
                        },
                id);
    }

    public UniversityStudent retrieveUniversityStudents(Long id) {
        UniversityStudent universityStudent = jdbcTemplate.queryForObject(
                "SELECT * FROM university where id = ?",
                (row, index) -> {
                    Long id_internal = row.getLong("id");
                    String fullName = row.getString("full_name");
                    String shortName = row.getString("short_name");
                    String address = row.getString("address");

                    return new UniversityStudent(id_internal, fullName, shortName, address, null);
                },
                id);

        List<Student> studentList = jdbcTemplate.query("select * from student s inner join\n" +
                        " student_university su on su.idnp_student = s.idnp\n" +
                        " where su.id_university = ?",
                (row, index) -> {
                    String idnp = row.getString("idnp");
                    String firstName = row.getString("first_name");
                    String lastName = row.getString("last_name");
                    String email = row.getString("email");
                    char gender = row.getString("gender").toCharArray()[0];
                    int age = row.getInt("age");

                    return new Student(idnp, firstName, lastName, email, gender, age);
                }, id);

        universityStudent.setStudentList(studentList);

        return universityStudent;
    }
}
