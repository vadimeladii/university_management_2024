package md.utm.controller;

import jakarta.validation.Valid;
import lombok.extern.log4j.Log4j;
import md.utm.entity.Student;
import md.utm.exception.type.AlreadyExistException;
import md.utm.exception.type.NotFoundException;
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
@Log4j
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
        if (!studentRepository.exists(idnp))
            throw new NotFoundException();

        return studentRepository.retrieveByIdnp(idnp);
    }

    @PostMapping
    public void create(@Valid @RequestBody Student student) {
        if(studentRepository.exists(student.getIdnp()))
            throw new AlreadyExistException();
        studentRepository.create(student);
    }

    @PutMapping("{idnp}")
    public void update(@PathVariable String idnp, @Valid @RequestBody Student student) {
        studentRepository.update(idnp, student);
    }

    @DeleteMapping("{idnp}")
    public void delete(@PathVariable String idnp) {
        studentRepository.delete(idnp);
    }
}
