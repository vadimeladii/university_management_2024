package md.utm.controller;


import md.utm.entity.University;
import md.utm.entity.UniversityStudent;
import md.utm.repository.UniversityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


// /univertity/{id}/students

@RestController
@RequestMapping("university")
public class UniversityController {

    @Autowired
    private UniversityRepository universityRepository;

    @GetMapping
    public List<University> retrieve(){
        return universityRepository.retrieve();
    }

    @GetMapping("{id}")
    public University retrieveById(@PathVariable Long id){
        return universityRepository.retrieveById(id);
    }

    @GetMapping("{id}/students")
    public UniversityStudent retrieveUniversityStudents(@PathVariable Long id) {
        return universityRepository.retrieveUniversityStudents(id);
    }
}
