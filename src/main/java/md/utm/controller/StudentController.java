package md.utm.controller;

import md.utm.entity.Student;
import md.utm.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// CRUD - > create , read ,update, delete
//locahost:8080 -> agora.md


//  /student/test
//  /student/test/test/test


//GET      /student
//GET      /student/{idnp}
//POST     /student
//PUT      /student/{idnp}
//DELETE   /student/{idnp}


//GET      /student/greaterThan?age=25&name='L'&gender='M'



@RestController
@RequestMapping("student")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping
    public List<Student> retrieve() {
        return studentRepository.retrieve();
    }

    @GetMapping("greaterThan")
    public List<Student> retrieveStudentGreaterThan(@RequestParam("age") int age) {
        return studentRepository.retrieveStudentGreaterThan(age);
    }

    @GetMapping("{idnp}")
    public Student retrieveByIdnp(@PathVariable String idnp) {
        return studentRepository.retrieveByIdnp(idnp);
    }

    @PostMapping
    public void create(@RequestBody Student student) {
        studentRepository.create(student);
    }

    @PutMapping("{idnp}")
    public void update(@PathVariable String idnp, @RequestBody Student student) {
        studentRepository.update(idnp, student);
    }

    @DeleteMapping("{idnp}")
    public void delete(@PathVariable String idnp) {
        studentRepository.delete(idnp);
    }
}
